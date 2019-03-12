package org.jacob.spring.dao.springjdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("articleDao")
public class ArticleDaoImplUsingSpringJdbc implements ArticleDao {
	static final String LIST_ARTICLES = "SELECT articleId, title, name, left(cdate,16) cdate FROM article LIMIT 10";
	static final String GET_ARTICLE = "SELECT articleId, title, content, name, left(cdate,16) cdate FROM article WHERE articleId=?";
	static final String ADD_ARTICLE = "INSERT INTO article(title, content, userId, name) VALUES (?,?,?,?)";
	static final String UPDATE_ARTICLE = "UPDATE article SET title=?, content=? WHERE articleId=?";
	static final String DELETE_ARTICLE = "DELETE FROM article WHERE articleId=?";

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * Default Constructor
	 */
	public ArticleDaoImplUsingSpringJdbc() {
		System.out.println("articleDaoImplUsingSpringJdbc가 생성되었습니다.");
	}

	/**
	 * 게시글 목록
	 */
	@Override
	public List<Article> listArticles() {
		return jdbcTemplate.query(LIST_ARTICLES, new BeanPropertyRowMapper<>(Article.class));
	}

	/**
	 * 게시글 상세
	 */
	@Override
	public Article getArticle(String articleId) {
		return jdbcTemplate.queryForObject(GET_ARTICLE, new BeanPropertyRowMapper<>(Article.class), articleId);
	}

	/**
	 * 게시글 등록
	 */
	@Override
	public void addArticle(Article article) {
		jdbcTemplate.update(ADD_ARTICLE, article.getTitle(), article.getContent(), article.getUserId(),
				article.getName());
	}

	/**
	 * 게시글 수정
	 */
	@Override
	public void updateArticle(Article article) {
		jdbcTemplate.update(UPDATE_ARTICLE, article.getTitle(), article.getContent(), article.getArticleId());
	}

	/**
	 * 게시글 삭제
	 */
	@Override
	public void deleteArticle(String articleId) {
		jdbcTemplate.update(DELETE_ARTICLE, articleId);
	}
}
