package com.claylin.config.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by claylin on 2017/5/9.
 */
@Configuration
@MapperScan(basePackages = DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {

    static final String PACKAGE = "com.claylin.dao";
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Value("${druid.driverClass}")
    private String driverClass;

    @Value("${druid.url}")
    private String url;

    @Value("${druid.user}")
    private String user;

    @Value("${druid.password}")
    private String password;

    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "dataSourceTransactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception{
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DataSourceConfig.MAPPER_LOCATION));
        return sqlSessionFactoryBean.getObject();
    }
}
