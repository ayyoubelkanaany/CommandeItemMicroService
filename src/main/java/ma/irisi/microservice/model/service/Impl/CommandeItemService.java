package ma.irisi.microservice.model.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import ma.irisi.microservice.beans.CommandeItem;
import ma.irisi.microservice.model.dao.CommandeItemRepository;
import ma.irisi.microservice.model.service.facad.I_CommandeItemService;

@Service
public class CommandeItemService implements I_CommandeItemService{
	

	@Autowired
    private CommandeItemRepository commandeItemRepository;
	@Override
	public int save(List<CommandeItem> commandeItems) {
		
		if(commandeItems.isEmpty() || commandeItems ==null) {
			return -1;
		}
		
		else {
		
			commandeItems.stream().forEach(cmdItm -> {
				this.commandeItemRepository.save(cmdItm);
			});
			
			return 2;
		}
		
	}
	
	@Override
	public int deleteById(Long id) {
		if(id == null) {
			return -1;
		}
		else {
			this.commandeItemRepository.deleteById(id);
			return 1;
		}
		
	}

	@Override
	public int update(List<CommandeItem> commandeItems) {
		if(commandeItems.isEmpty() || commandeItems ==null) {
			
			return -2;
		}
		else {
			this.save(commandeItems);
		}
		return 2;
	}

	@Override
	public List<CommandeItem> getAll() {
		return (List<CommandeItem>)this.commandeItemRepository.findAll();
	}

	@Override
	public CommandeItem findById(Long id) {
        if(id != null) {
        	if(this.commandeItemRepository.findById(id).isPresent()) {
        		CommandeItem loadedCommande = this.commandeItemRepository.findById(id).get();
			return loadedCommande;
        	}
        	else {
            	return null;
            }
        }
        else {
        
            	return null;
        }
        
	}

	@Override
	public List<CommandeItem> findByRefCmd(String reference) {
		List<CommandeItem> cmd = this.getAll();
		List<CommandeItem> cmdItemReturned = new ArrayList<CommandeItem>() ;
		
		if(reference != null && !cmd.isEmpty()) {
		  for(int i=0;i<cmd.size();i++) {
			  if(cmd.get(i) != null  ) {
				  if(cmd.get(i).getRefCmd().equals(reference)){
					  cmdItemReturned.add(cmd.get(i));
				  }
				  
			  }
			  }
		  return cmdItemReturned;
		}
		else {
			
			return null;
		}	
	}

	@Override
	public int deleteByRefCmd(String ref) {
		List<CommandeItem> cmd = this.getAll();
		CommandeItem cmdItemReturned = null;
		if(ref != null && !cmd.isEmpty()) {
		  for(int i=0;i<cmd.size();i++) {
			  if(cmd.get(i) != null ) {
				  if(cmd.get(i).getRefCmd().equals(ref)){
					  deleteById(cmd.get(i).getId());
				  }
				  
			  }
			  }
		  return 1;
		}
		else {
			
			return -1;
		}	

	}

	@Override
	public int deleteById(List<CommandeItem> cmditems) {
	     if(cmditems.isEmpty() || cmditems == null) {
	    	 return -1;
	     }
	     else {
	    	 cmditems.stream().forEach(cmd -> {
	    		 this.deleteById(cmd.getId());
	    	 });
	     }
		return 1;
	}


}
