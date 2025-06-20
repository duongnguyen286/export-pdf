package asia.duong.exportpdf;

import asia.duong.exportpdf.service.TthcService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class ExportPdfApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExportPdfApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(TthcService service) {
        return args -> service.callApi();
    }

}
