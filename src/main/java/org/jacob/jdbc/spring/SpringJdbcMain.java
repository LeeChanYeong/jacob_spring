package org.jacob.jdbc.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ArticleService를 테스트하는 main
 * 
 * @author Jacob
 */
public class SpringJdbcMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-jdbc.xml");
		ArticleService articleService = context.getBean("articleService",
				ArticleService.class);
		articleService.listArticles();
	}

}
