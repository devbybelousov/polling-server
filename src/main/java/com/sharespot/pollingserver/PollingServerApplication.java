package com.sharespot.pollingserver;

import com.sharespot.pollingserver.controller.PollController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		PollingServerApplication.class,
		Jsr310JpaConverters.class
})
public class PollingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollingServerApplication.class, args);
	}

}
