package top.acgnx.hitokoto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class HitokotoApplicationTests {

    @Test
    void contextLoads() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Object> list = mapper.readValue(new ClassPathResource("public/sentences/a.json").getFile(), ArrayList.class);
        System.out.println(list.get(list.size()-1));
    }

}
