package br.com.meli.elasticsearch.service;

import br.com.meli.elasticsearch.domain.Article;
import br.com.meli.elasticsearch.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;


    public Article save(Article article) {
        return articleRepository.save(article);
    }

    public Iterable<Article> findAll() {
        return articleRepository.findAll();
    }
}
