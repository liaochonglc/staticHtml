package free.html;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HtmlApplicationTests {
    @Autowired
    private Configuration configuration;

    @Test
    public void contextLoads() {
        try {
            //获得指定的模板
            Template template = configuration.getTemplate("hello.ftl");
            //准备数据
            Map<String,String> map = new HashMap<>();
            map.put("key","lc");
            //准备输出流
            FileWriter fileWriter = new FileWriter("d:\\hello.html");
            //生成静态页面
            template.process(map,fileWriter);
            fileWriter.close();
            //在项目中template里面放模板页面,static放静态页面但是里面最好也建两个文件一个是page放生成页面,一个是resource放静态资源
            //怎么获得classpath
           // this.getClass().getResource("/").getPath();
            //在模板页面那里是拿不到当前项目路径的就是那个base url 但是你可以传到map里面
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

