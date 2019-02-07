package org.jacob.spring;

import java.util.List;

import org.jacob.spring.dao.Article;
import org.jacob.spring.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UsingContainerMain {

	@Autowired
	ArticleDao articleDao;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");
		UsingContainerMain main = context.getBean("usingContainerMain", UsingContainerMain.class);
		main.getArticle();
	}

	public void listArticles() {
		List<Article> articles = articleDao.listArticles();
		System.out.println(articles);
	}

	public void getArticle() {
		Article article = articleDao.getArticle("1");
		System.out.println(article);
	}

	public void addArticle() {
		Article article = new Article();
		article.setTitle("This is title.");
		article.setContent("This is content");
		article.setUserId("1");
		article.setName("조원석");
		articleDao.addArticle(article);
	}

	public void updateArticle() {
		Article article = new Article();
		article.setArticleId("7");
		article.setTitle("This is modified title.");
		article.setContent("This is modified content");
		articleDao.updateArticle(article);
	}

	public void deleteArticle() {
		articleDao.deleteArticle("8");
	}
}