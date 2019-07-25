package com.woita.spring5webapp.repositories;

import com.woita.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * @author mcbrydr on 25/07/19
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
