package com.woita.spring5webapp.bootstrap;

import com.woita.spring5webapp.model.Author;
import com.woita.spring5webapp.model.Book;
import com.woita.spring5webapp.model.Publisher;
import com.woita.spring5webapp.repositories.AuthorRepository;
import com.woita.spring5webapp.repositories.BookRepository;
import com.woita.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


/**
 * @author mcbrydr on 25/07/19
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        // Eric
        Author eric = new Author("Eric", "Evans");
        Publisher harperCollins = new Publisher("Harper Collins", "123 London Road, London");
        Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(harperCollins);
        bookRepository.save(ddd);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx", "99 Coast Avenue, Cornwall");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        publisherRepository.save(worx);
        bookRepository.save(noEJB);
    }
}
