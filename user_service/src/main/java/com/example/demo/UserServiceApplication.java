package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
/**@EnableDiscoveryClient
@AllArgsConstructor
@RequestMapping("/users")
@RestController**/
@EnableDiscoveryClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	/**@GetMapping
	public ResponseEntity<?> getStatus() {
		return ResponseEntity.status(HttpStatus.OK).body("user-service is up");
	}
	private final UserEntitySer usr;
	@PostMapping
	public ResponseEntity<UserEntity> createEmployee(@RequestBody UserEntity user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usr.create(user));
	}

	@GetMapping
	public ResponseEntity<List<UserEntity>> getEmployees() {
		return ResponseEntity.ok(usr.listAll());
	}
**/

}
