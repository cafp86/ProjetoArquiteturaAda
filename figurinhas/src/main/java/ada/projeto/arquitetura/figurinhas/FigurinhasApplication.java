package ada.projeto.arquitetura.figurinhas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FigurinhasApplication {

	public static void main(String[] args) {
		SpringApplication.run(FigurinhasApplication.class, args);
	}

}
