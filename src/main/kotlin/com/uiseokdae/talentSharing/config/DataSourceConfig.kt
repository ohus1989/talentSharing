package com.uiseokdae.talentSharing.config

import com.zaxxer.hikari.HikariDataSource
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.annotation.MapperScan
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import javax.sql.DataSource

@Configuration
@MapperScan(
    basePackages = ["com.uiseokdae.talentSharing.modules"],
    sqlSessionFactoryRef = "sessionFactory"
)
class DataSourceConfig {
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource")
    fun dataSource(): DataSource {
        return DataSourceBuilder.create().type(HikariDataSource::class.java).build()
    }

    @Primary
    @Bean
    fun sessionFactory(): SqlSessionFactory {
        val sqlSessionFactoryBean = SqlSessionFactoryBean()

        sqlSessionFactoryBean.setDataSource((this.dataSource()))
        sqlSessionFactoryBean.setTypeAliasesPackage("com.uiseokdae.talentSharing.modules")
        sqlSessionFactoryBean.setMapperLocations(*PathMatchingResourcePatternResolver().getResources("classpath:/mapper/**/*.xml"))
        sqlSessionFactoryBean.vfs = SpringBootVFS::class.java

        return sqlSessionFactoryBean.`object`!!
    }
}