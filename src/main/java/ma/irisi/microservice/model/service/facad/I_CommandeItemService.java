package ma.irisi.microservice.model.service.facad;

import java.util.List;

import ma.irisi.microservice.beans.CommandeItem;


public interface I_CommandeItemService {
 public int deleteById(Long id);
 public int deleteById(List<CommandeItem> cmditems);
 public int deleteByRefCmd(String ref);
 public int save(List<CommandeItem> commandeItems);
 public int update(List<CommandeItem> commandeItems);
 public List<CommandeItem> getAll();
 public CommandeItem findById(Long id);
 public List<CommandeItem> findByRefCmd(String reference);

}
