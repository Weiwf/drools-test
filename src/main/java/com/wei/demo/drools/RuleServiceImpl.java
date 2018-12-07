package com.wei.demo.drools;

import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.kie.api.definition.KiePackage;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: weiwenfeng
 * @Date: 2018/12/7
 */
public class RuleServiceImpl implements RuleService {

    private StatelessKieSession statelessKieSession;

    public RuleServiceImpl(List<byte[]> drlBytes){
        this.init(drlBytes);
    }

    private void init(List<byte[]> drlBytes){
        KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        Iterator iterator = drlBytes.iterator();

        while(iterator.hasNext()) {
            byte[] ruleFileContent = (byte[])iterator.next();
            Resource res = ResourceFactory.newByteArrayResource(ruleFileContent);
            builder.add(res, ResourceType.DRL);
        }
        InternalKnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        Collection<KiePackage> kiePackages = builder.getKnowledgePackages();
        knowledgeBase.addPackages(kiePackages);

        this.statelessKieSession = knowledgeBase.newStatelessKieSession();
    }

    @Override
    public void execute(Object[] objects) {
        statelessKieSession.execute(Arrays.asList(objects));
    }
}
