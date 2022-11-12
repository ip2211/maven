package com.example.demo;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.kafka.core.KafkaTemplate;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping("kafka")
	public class userresource {
	    @Autowired
	    private KafkaTemplate<String, user> kafkaTemplate;
	    private static final String TOPIC = "kafka_topic1";
	    @GetMapping("/publish/{name}")
	    public String post(@PathVariable("name") final String name) {
	        kafkaTemplate.send(TOPIC, new user(1,"ip","manthani","6281889937"));
	        return "Published successfully";
	    }
	}


