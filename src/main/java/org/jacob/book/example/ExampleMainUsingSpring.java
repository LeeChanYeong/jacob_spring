package org.jacob.book.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExampleMainUsingSpring {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(
				"example.xml");
		ArticleService articleService = ctx.getBean("articleService",
				ArticleService.class);
		PaymentService paymentService = ctx.getBean("paymentService",
				PaymentService.class);

		articleService.addArticle();
		paymentService.pay();
		ctx.close();
	}

}
