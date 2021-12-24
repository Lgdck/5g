package situation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lgd
 * @date 2021/10/30 16:19
 */
@SpringBootApplication
@EnableEurekaClient
public class FileUploadApplication {
    public static void main(String[] args){
        SpringApplication.run(FileUploadApplication.class,args);
    }
}
