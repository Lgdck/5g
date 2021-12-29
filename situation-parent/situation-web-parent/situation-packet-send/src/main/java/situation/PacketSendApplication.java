package situation;

import com.situation.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author lgd
 * @date 2021/10/27 20:57
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"situation.dao"})
public class PacketSendApplication {
    public static void main(String[] args){
        SpringApplication.run(PacketSendApplication.class,args);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(0,0);
    }
}
