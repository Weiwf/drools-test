
- drools-test提供了一些drools的简单测试例子，drl文件放在 resources -> rules 中
- 项目提供了两种直接获取drl文件进行测试的方式：
   - 使用DroolsUtils工具类 ：DroolsUtils提供了两个方法：execute(Object[] objects)和execute(Object[] objects, List<byte[]> bytesList)，
   前者将获取rules文件夹下的所有drl规则文件进行运算，后者可以指定一个或多个drl规则文件，但需要先转成字节数组的形式传入。
   - 通过直接调用RuleServiceImpl的构造器获取RuleService：
   ```java
      byte[] bytes = FileUtils.getFileContent("CommonTest.drl");
      List<byte[]> list = Arrays.asList(bytes);
      RuleService ruleService = new RuleServiceImpl(list);
      ruleService.execute(new Object[]{});
   ```
- drools-test提供了一个获取RuleService的工厂类RuleServiceFactory，支持并发操作。

