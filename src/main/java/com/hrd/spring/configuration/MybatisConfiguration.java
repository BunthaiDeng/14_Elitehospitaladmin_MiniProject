package com.hrd.spring.configuration;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan("com.hrd.spring.repository")
public class MybatisConfiguration {

	private DataSource dataSource;

	@Autowired
	public MybatisConfiguration(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager(){
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(){
		SqlSessionFactoryBean s = new SqlSessionFactoryBean();
		s.setDataSource(dataSource);
		return s;
	}
	
}
