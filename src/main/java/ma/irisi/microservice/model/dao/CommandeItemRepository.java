package ma.irisi.microservice.model.dao;

import org.springframework.data.repository.CrudRepository;

import ma.irisi.microservice.beans.CommandeItem;

public interface CommandeItemRepository extends  CrudRepository<CommandeItem, Long>{
    CommandeItem findByRefCmd(String reference);
}
