package com.pack.dao;

import java.util.List;

import com.pack.entity.Article;

public interface IArticleDAO 
{
	//UserInfo getActiveUser(String userName);
	
	List<Article> getAllArticles();
    Article getArticleById(int articleId);
    void addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(int articleId);
    boolean articleExists(String title, String category);
}
