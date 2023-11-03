package com.spring.VideoCall.Video.Call;

import com.spring.VideoCall.Video.Call.user.User;
import com.spring.VideoCall.Video.Call.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideoCallApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoCallApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserService service){
		return args -> {

			service.register(User.builder()
							.username("Sandy")
							.email("sandy@gmail.com")
							.password("sandy")
					.build());
			service.register(User.builder()
							.username("James")
							.email("james@gmail.com")
							.password("james")
					.build());
			service.register(User.builder()
							.username("Willy")
							.email("willy@gmail.com")
							.password("willy")
					.build());
		};
	}

}
