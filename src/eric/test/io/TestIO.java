package eric.test.io;

import java.io.*;
import java.util.Date;

public class TestIO {
    public String filePath;
    public String content = "今天是2018年9月5号";

    public static void main(String[] args) {

        TestIO testIO = new TestIO();
        testIO.readerFile();
    }


    public void writeFile() {
        FileOutputStream fs = null;
        FileWriter fw = null;
        //当前项目根目录 res目录下创建test.txt
        File file = new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + "test.txt");
        filePath = file.getPath();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        byte[] array = content.getBytes();
        try {
            fs = new FileOutputStream(filePath);
            fs.write(array);

            //也可以用FileWriter实现
            //fw = new FileWriter(filePath);
            //fw.write(content+" 这里是用FileWriter写入");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fs != null) {
                try {
                    fs.flush();
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//            if (fw != null) {
//                try {
//                    fw.flush();
//                    fw.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }

    }

    public void readerFile() {
        FileInputStream fileInputStream = null;
        FileReader fd = null;
        String p = System.getProperty("user.dir") + File.separator + "res" + File.separator + "test.txt";
        try {
            fileInputStream = new FileInputStream(p);
            int size = fileInputStream.available();
            byte[] array = new byte[size];
            fileInputStream.read(array);
            String result = new String(array);
            System.out.println(result + new Date().toString());
            //也可以使用FileReader读取
            fd = new FileReader(p);
            char[] charArray = new char[500];
            int i = 0;
            String s="";
            while((i=fd.read(charArray))!= -1){
                System.out.println(new String(charArray));
                System.out.println(i);
                //charArray=charArray;

            }

            System.out.println(s + i + "这里是用FileReader读取");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fd != null) {
                try {
                    fd.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
