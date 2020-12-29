package top.acgnx.hitokoto.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.acgnx.hitokoto.aop.LimitRequest;
import top.acgnx.hitokoto.pojo.Param;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;


@RestController
public class HitokotoApi {
    Integer accessNum = 0;
    ObjectMapper mapper = new ObjectMapper();
    ArrayList<ArrayList<Object>> lists = new ArrayList<>();
    {
        try {
            lists.add(mapper.readValue(new ClassPathResource("public/sentences/a.json").getInputStream(), ArrayList.class));
            lists.add(mapper.readValue(new ClassPathResource("public/sentences/b.json").getInputStream(), ArrayList.class));
            lists.add(mapper.readValue(new ClassPathResource("public/sentences/c.json").getInputStream(), ArrayList.class));
            lists.add(mapper.readValue(new ClassPathResource("public/sentences/d.json").getInputStream(), ArrayList.class));
            lists.add(mapper.readValue(new ClassPathResource("public/sentences/e.json").getInputStream(), ArrayList.class));
            lists.add(mapper.readValue(new ClassPathResource("public/sentences/f.json").getInputStream(), ArrayList.class));
            lists.add(mapper.readValue(new ClassPathResource("public/sentences/g.json").getInputStream(), ArrayList.class));
            lists.add(mapper.readValue(new ClassPathResource("public/sentences/h.json").getInputStream(), ArrayList.class));
            lists.add(mapper.readValue(new ClassPathResource("public/sentences/i.json").getInputStream(), ArrayList.class));
            lists.add(mapper.readValue(new ClassPathResource("public/sentences/j.json").getInputStream(), ArrayList.class));
            lists.add(mapper.readValue(new ClassPathResource("public/sentences/k.json").getInputStream(), ArrayList.class));
            lists.add(mapper.readValue(new ClassPathResource("public/sentences/l.json").getInputStream(), ArrayList.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @LimitRequest(time = 60000,count = 60)
    @RequestMapping("/hitokotoApi")
    public String hitokotoApi(Param params) throws UnsupportedEncodingException {
        //System.out.println(params);
        int jsonIndex;
        if(params.getC() == null){
            jsonIndex = (int)(Math.random() * 12);
        } else
            jsonIndex = params.getC().toCharArray()[0]-'a';
        ArrayList<Object> list = lists.get(jsonIndex);
        HashMap<String,Object> map = (HashMap) list.get((int)(Math.random() * list.size()));
        String ret = map.toString();
        if(params.getEncode()!=null&&params.getEncode().equals("text")){
            ret = (String) map.get("hitokoto");
        }
        if(params.getCharset()!=null&&params.getCharset().equals("gbk")){
            ret=new String(ret.getBytes(),"GBK");
        }
        accessNum++;
        System.out.println("被访问了：" + accessNum + "次");
        return ret;
    }

    @RequestMapping("/errorMsg")
    public String errorMsg(){
        return "服务器繁忙，请等待";
    }
}
