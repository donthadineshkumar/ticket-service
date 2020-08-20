package com.epam.tickerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication/*(exclude = {H2ConsoleAutoConfiguration.class})*/
//@EnableEurekaClient
@RestController
//@EnableMongoRepositories(basePackages = "com.epam.tickerservice")
@ConfigurationPropertiesScan(value = "com.epam.tickerservice") //from spring 2.2
//@EnableConfigurationProperties(ConfigProps.class)
//@RibbonClient(name = "matrimony-site", configuration = MatrimonyConfiguration.class)
public class TickerServiceApplication  {

	@Value("${prop1}")
	static String val;
	public static void main(String[] args) {
		System.getProperty("prop");
		System.getProperty("prop1");

		SpringApplication.run(TickerServiceApplication.class, args);
	}

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ConfigProps configProps;

	@Autowired
	PropertyConversion propertyConversion;

	@Autowired
	ClientService clientService;

	/*@Autowired
	EurekaClient eurekaClient;*/

	@PostMapping(value = "/client", consumes = "application/json")
	public void createClient(Client client) {
		clientService.createClient(client);
	}

	@RequestMapping(value = "/greet", method = RequestMethod.GET)
	public String getGreetings() {
		System.out.println("conversion "+propertyConversion.getTimeInNano() + " "+
				propertyConversion.getTimeInDefaultUnit()+ " "+
				propertyConversion.getTimeInDays());
		System.out.println("Configuration Props: " + configProps.getHostName() + " " +
				configProps.getPort() + " " +
				configProps.getFrom() + " " +
				configProps.getDefaultRecipients() + " "+
				configProps.getAdditionalHeaders() + " "+
				configProps.getCredentials().getAuthMethod() + " "+
				configProps.getCredentials().getUsername() + " "+
				configProps.getCredentials().getPassword());
		return restTemplate.getForObject("http://MATRIMONY-SITE"+"/greet", String.class);
	}

	@Bean
	//@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
