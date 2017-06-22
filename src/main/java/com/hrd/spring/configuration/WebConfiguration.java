package com.hrd.spring.configuration;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter{

	@Override
	public void addViewControllers(ViewControllerRegistry r) {
		r.addViewController("/layout").setViewName("layout");
//		r.addViewController("/").setViewName("dashboard");
//		r.addViewController("/admin").setViewName("dashboard"); 
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry r) {
		/*I should research more about path*/
		r.addResourceHandler("/resources/**").addResourceLocations("classpath:/static/");
		r.addResourceHandler("/files/**").addResourceLocations("file:/opt/FILES_MANAGEMENT/images/");
	}
	
	
	
	/*
	 * In order for our application to be able to determine which locale is
	 * currently being used, we need to add a LocaleResolver bean:
	 */
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(new Locale("kh"));
		resolver.setCookieName("Spring_Locale");
		resolver.setCookieMaxAge(4800);
		return resolver;
	}

	/*
	 * Next, we need to add an interceptor bean that will switch to a new locale
	 * based on the value of the lang parameter appended to a request:
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}

	/*
	 * In order to take effect, this bean needs to be added to the application’s
	 * interceptor registry.
	 *
	 * To achieve this, our @Configuration class has to extend the
	 * WebMvcConfigurerAdapter class and override the addInterceptors() method:
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	/*
	 * Defining the Message Sources
	 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:/i18n/messages/message");
		messageSource.setCacheSeconds(0);
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}	
	
//	@Bean
//	public LocaleResolver localeResolver(){
//		CookieLocaleResolver resolver = new CookieLocaleResolver();
//		resolver.setDefaultLocale(new Locale("kh"));
//		resolver.setCookieName("Spring_Locale");
//		resolver.setCookieMaxAge(4800);
//		return resolver;
//	}
//	
//	@Bean
//	public LocaleChangeInterceptor localeChangeInterceptor(){
//		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
//		lci.setParamName("lang");
//		return lci;
//		
//	}
//	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(localeChangeInterceptor());
//	}
//	
//	@Bean
//	public MessageSource messageSource(){
//		ReloadableResourceBundleMessageSource reload = new ReloadableResourceBundleMessageSource();
//		reload.setBasename("classpath:/i18n/messages/message");
//		reload.setCacheSeconds(0);
//		reload.setUseCodeAsDefaultMessage(true);
//		reload.setDefaultEncoding("UTF-8");
//		
//		return reload;
//	}
}
