SpringBoot静态资源
WebmvcAutoConfiguration--ResourceProperties--WebMvcProperties
```java
	private String staticPathPattern = "/**";
```

```java
private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/META-INF/resources/",
			"classpath:/resources/", "classpath:/static/", "classpath:/public/" };
```

```
```
```java
@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			if (!this.resourceProperties.isAddMappings()) {
				logger.debug("Default resource handling disabled");
				return;
			}
			Duration cachePeriod = this.resourceProperties.getCache().getPeriod();
			CacheControl cacheControl = this.resourceProperties.getCache().getCachecontrol().toHttpCacheControl();
			if (!registry.hasMappingForPattern("/webjars/**")) {
				customizeResourceHandlerRegistration(registry.addResourceHandler("/webjars/**")
						.addResourceLocations("classpath:/META-INF/resources/webjars/")
						.setCachePeriod(getSeconds(cachePeriod)).setCacheControl(cacheControl));
			}
			//拿到默认的路径
			String staticPathPattern = this.mvcProperties.getStaticPathPattern();
			if (!registry.hasMappingForPattern(staticPathPattern)) {
				customizeResourceHandlerRegistration(registry.addResourceHandler(staticPathPattern)
						.addResourceLocations(getResourceLocations(this.resourceProperties.getStaticLocations()))
						.setCachePeriod(getSeconds(cachePeriod)).setCacheControl(cacheControl));
			}
		}
```


1.webjars导入的情况  
2.直接从静态资源下面 默认有四个路径 存在优先级:resource > static > public 


资源映射/资源配置
1.@ConfigurationProperties(prefix = "person") 
这种是加载resources目录下的application.yaml的映射

2.@PropertySource(value = {"classpath:person.properties"})
这种是加载特定的映射文件

3.@ImportResource:导入spring的配置文件，让配置文件中的配置生效，用于自定义的配置
