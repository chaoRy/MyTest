package cn.chaory.mybatisTest;

import cn.chaory.mybatisTest.bean.dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class IbatisTest1 {
    private SqlSession sqlSession ;
    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
//   InputStream is = IbatisTest1.class.getClassLoader().getResourceAsStream("resource/mybatis/mybatis_mapping.xml");
        InputStream is = Resources.getResourceAsStream("mybatis/mybatis_config.xml");
        SqlSessionFactory ssf = ssfb.build(is);
        sqlSession = ssf.openSession();
        System.out.println(sqlSession);

    }
    @Test
    public void test1(){
        dept d = new dept();
        d.setId(111);
        d.setDeptName("你好");
        d.setLoc("哈哈哈");

        sqlSession.insert("deptDemo.insert1",d);
        sqlSession.commit();
        sqlSession.close();

    }

}
