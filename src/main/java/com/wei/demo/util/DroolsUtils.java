package com.wei.demo.util;


import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.kie.api.KieServices;
import org.kie.api.definition.KiePackage;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @Author: weiwenfeng
 * @Date: 2018/11/20
 */
@Component
public class DroolsUtils {

    /**
     *
     * @param objects 传入的对象数组，对drools来说是Fact
     */
    public static void execute(Object[] objects){
        KieContainer kieContainer  = KieServices.Factory.get().getKieClasspathContainer();
        // 引入kmodule.xml配置的ksession
        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        for (Object object : objects){
            kieSession.insert(object);
        }
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    /**
     *
     * @param objects 传入的对象数组，对drools来说是Fact
     * @param bytesList 多个DRL文件组成的字节数组列表
     */
    public static void execute(Object[] objects, List<byte[]> bytesList){
        KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        Iterator iterator = bytesList.iterator();

        while(iterator.hasNext()) {
            byte[] ruleFileContent = (byte[])iterator.next();
            Resource res = ResourceFactory.newByteArrayResource(ruleFileContent);
            builder.add(res, ResourceType.DRL);
        }
        InternalKnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        Collection<KiePackage> kiePackages = builder.getKnowledgePackages();
        knowledgeBase.addPackages(kiePackages);

        StatelessKieSession statelessKieSession = knowledgeBase.newStatelessKieSession();
        statelessKieSession.execute(Arrays.asList(objects));
    }
}
