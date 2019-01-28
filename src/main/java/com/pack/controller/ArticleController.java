package com.pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pack.entity.Article;
import com.pack.service.IArticleService;

@RestController
@RequestMapping("user")
public class ArticleController 
{
	@Autowired
	private IArticleService iArticleService;
	@GetMapping("/article/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable("id") Integer id)
	{
		Article article=iArticleService.getArticleById(id);
		return new ResponseEntity<Article>(article,HttpStatus.OK);
	}
	
	@GetMapping("articles")
	public ResponseEntity<List<Article>> getAllArticles()
	{
		List<Article> list=iArticleService.getAllArticles();
		return new ResponseEntity<List<Article>>(list,HttpStatus.OK);
	}
	
	@PostMapping("article")
	public ResponseEntity<Void> addArticle(@RequestBody Article article, UriComponentsBuilder builder)
	{
		boolean flag=iArticleService.addArticle(article);
		if(flag==false)
		{
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("article")
	public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
		iArticleService.updateArticle(article);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
	@DeleteMapping("article/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		iArticleService.deleteArticle(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}

