package esb.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import esb.service.Dbservice;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class dbTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        Map<String, List> m = Dbservice.getAllByDb();
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        String jsonStr = gson.toJson(m);
        System.out.println(jsonStr);
        //写文件
        writeFile(jsonStr, "C:\\Users\\Administrator\\Desktop\\苍老师.json");

    }

    public static void writeFile(String str, String URL) throws IOException, InterruptedException {
        File f = new File(URL);
        if (!f.exists()) {
            f.createNewFile();

        }
        byte[] bt = new byte[1024];
        bt = str.getBytes();
        int b = str.length();
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(bt);
        Thread.sleep(1000);
        fos.close();

    }

}
