package com.ln;

import com.ln.config.RabbitFanoutConfig;
import com.ln.config.RabbitTopicConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRabbitmqApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	//测direct类型的exchange
	@Test
	void contextLoads() {
		//Direct特点 根据routingKey 查找自己设置的队列名称                     发送的消息
		rabbitTemplate.convertAndSend("hello.javaboy", "hello javaboy!!!");
	}

	/**
	 *路由策略 发送消息二Fanout
	 */
	@Test
	public void test1() {
		rabbitTemplate.convertAndSend(RabbitFanoutConfig.FANOUTNAME,null,"hello fanout!");



	}


	/**
	 *路由策略 发送消息三TOPIC
	 */
	@Test
	public void test2(){
		rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"xiaomi.news","小米新闻");
		rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"vivo.phone","vivo手机");
		rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"huawei.phone","华为手机");

	}
}
