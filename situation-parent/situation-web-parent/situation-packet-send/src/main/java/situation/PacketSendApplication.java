package situation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lgd
 * @date 2021/10/27 20:57
 */
@SpringBootApplication
@EnableEurekaClient
public class PacketSendApplication {
    public static void main(String[] args){
        SpringApplication.run(PacketSendApplication.class,args);
    }
}
