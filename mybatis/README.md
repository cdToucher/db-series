## record of using mybatis ##

文档地址：[http://www.mybatis.org/mybatis-3/zh/index.html](http://www.mybatis.org/mybatis-3/zh/index.html)

> create SqlSessionFactory 构建该对象，mybatis提供了两种方法：
>  
>  通过 xml 构建configuration 并使用SqlSessionFactoryBuilder 生成SqlSessionFactory
>  
>  使用javaconfig ，类 Configuration加载相应的 mapper

    <configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${spring.datasource.driver-class-name}"/>
                <property name="url" value="${spring.datasource.url}"/>
                <property name="username" value="${spring.datasource.username}"/>
                <property name="password" value="${spring.datasource.password}"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="sql/AppInfoMapper.xml"/>
    </mappers>
</configuration>

    @Bean
    public SqlSessionFactory getSqlSessionFactory(@Autowired DataSource dataSource) throws IOException {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration(environment);
        SqlSessionFactory sqlSessionFactory = new SqlSessionF``actoryBuilder().build(configuration);
        configuration.addMappers("me.codebase.db_serise.mybatis.mappers");
        configuration.setDatabaseId("uem_octopus");
        return sqlSessionFactory;
    }

    @Bean
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(AppConfig.class.getClassLoader(), "mybatis-config.xml");
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
    
    public interface AppInfoMapper {
       //AppInfo selectOne(String appId);
        //@Select("SELECT * FROM app_info WHERE app_id = #{id}")
        AppInfo selectOne(String id);
        }
