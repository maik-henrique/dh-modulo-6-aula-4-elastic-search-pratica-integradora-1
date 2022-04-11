package br.com.meli.elasticsearch.controller;

import br.com.meli.elasticsearch.config.ModelMapperConfiguration;
import br.com.meli.elasticsearch.domain.Article;
import br.com.meli.elasticsearch.dto.ArticleRequest;
import br.com.meli.elasticsearch.service.ArticleService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
@AllArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> storeArticle(@RequestBody ArticleRequest article) {
        Article mappedArticle = modelMapper.map(article, Article.class);
        return ResponseEntity.ok(articleService.save(mappedArticle));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(articleService.findAll());
    }
}
