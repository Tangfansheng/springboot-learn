springboot源码探析

springboot01HelloworldApplication ：springboot应用
(一)
@SpringBootApplication注解探究：
进入该注解发现他有两个子注解
```1  @SpringBootConfiguration
```
进入该SpringBootConfiguration发现他是一个Configuration组件
```java
@Configuration
public @interface SpringBootConfiguration
```
而Configuration本质上是一个Component
```java
@Component
public @interface Configuration {
```
功能是判断方法是否需要代理
```
   2  @EnableAutoConfiguration
    springboot自动配置的实现
```
进去之后有两个核心
```java
1. @AutoConfigurationPackage 自动配置包
2. @Import(AutoConfigurationImportSelector.class) 
```
1.前者可以挖到这个
```java
static class Registrar implements ImportBeanDefinitionRegistrar, DeterminableImports {

		@Override
		public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
            //其中metadata是注解标注的原信息
			register(registry, new PackageImport(metadata).getPackageName());
            //可以在register方法上添加断点
            //观察到metadata中的一项信息即本应用的class，即springboot01HelloworldApplication
            //new PackageImport(metadata).getPackageName()计算结果是com.ordo 即项目包名
		}

	}
```
**可以得出结论：@AutoConfigurationPackage 自动配置包是将@SpringBootApplication所标注的class所在的包的所有组件扫描到容器中**


2.后者 @Import(AutoConfigurationImportSelector.class) 的作用看名字推测是给容器导入组件->这是spring的底层注解@import 给spring导入括号中的类
其中主要的方法：以全类名的方式返回
```java
	public String[] selectImports(AnnotationMetadata annotationMetadata) {
		if (!isEnabled(annotationMetadata)) {
			return NO_IMPORTS;
		}
		AutoConfigurationMetadata autoConfigurationMetadata = AutoConfigurationMetadataLoader
				.loadMetadata(this.beanClassLoader);
		AutoConfigurationEntry autoConfigurationEntry = getAutoConfigurationEntry(autoConfigurationMetadata,
				annotationMetadata);
		return StringUtils.toStringArray(autoConfigurationEntry.getConfigurations());
	}

    protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
            List<String> configurations = SpringFactoriesLoader.loadFactoryNames(getSpringFactoriesLoaderFactoryClass(),
                    getBeanClassLoader());
            Assert.notEmpty(configurations, "No auto configuration classes found in META-INF/spring.factories. If you "
                    + "are using a custom packaging, make sure that file is correct.");
            return configurations;
        }

```





```java
  SpringApplication.run(Springboot01HelloworldApplication.class, args);
```