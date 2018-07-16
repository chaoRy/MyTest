package esb.service;


import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dbservice {
    /**
     * @return
     */
    public static Map<String, List> getAllByDb() {
        Map<String, List> map = null;
        try {
            Connection conn = null;
                conn = Dbutil.getConnection();
// 创建预编译语句对象，一般都是用这个而不用Statement
            PreparedStatement pre = null;
// 创建一个结果集对象
            ResultSet result = null;

            String sql = "select table_name from user_tables order by TABLE_NAME";
            pre = conn.prepareStatement(sql);// 实例化预编译语句
            result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
            System.out.println("结果：" + result.toString());
            List list = new ArrayList();
            while (result.next()) {
                String name = result.getString("TABLE_NAME");
                list.add(name );

            }
            System.out.println(list.size());

            map = new HashMap<String, List>();
            map.put("表", list);
        } catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;


    }
}

