package org.jacob.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDaoImpl implements ArticleDao {
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
	public ArticleDaoImpl() {
		System.out.println("articleDaoImplUsingTemplate이 생성되었습니다.");
	}

	/**
	 * 게시글 목록
	 */
	@Override
	public List<Article> listArticles() {
		return jdbcTemplate.queryForList(LIST_ARTICLES, null, rs -> {
			Article article = new Article();
			article.setArticleId(rs.getString("articleId"));
			article.setTitle(rs.getString("title"));
			article.setName(rs.getString("name"));
			article.setCdate(rs.getString("cdate"));
			return article;
		});
	}

	/**
	 * 게시글 상세
	 */
	@Override
	public Article getArticle(String articleId) {
		return jdbcTemplate.queryForObject(GET_ARTICLE, new Object[] { articleId }, rs -> {
			Article article = new Article();
			article.setArticleId(rs.getString("articleId"));
			article.setTitle(rs.getString("title"));
			article.setContent(rs.getString("content"));
			article.setName(rs.getString("name"));
			article.setCdate(rs.getString("cdate"));
			return article;
		});
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
