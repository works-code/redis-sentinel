package com.code;

import com.code.vo.RedisInfo;
import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class RedisSentinelApplicationTests {

    @Test
    void 테스트() {
        // 계속 반복
        while (true){
            try {
                Thread.sleep(1000); // 1초 마다 호출

                RedisInfo redisInfo = new RedisInfo();
                redisInfo.setKey("key");
                redisInfo.setValue("hello_3");
                HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/get")
                        .header("Content-Type", "application/json")
                        .body(redisInfo)
                        .asJson();

                log.info("### 테스트 결과 => status : {} | response : {}", response.getStatus() , response.getBody().getObject());

            }catch (Exception e){
                log.error("### 테스트 에러 발생 => {}", e.getMessage());
            }
        }
    }

}
