package ma.irisi.microservice.model.ws;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.irisi.microservice.beans.CommandeItem;
import ma.irisi.microservice.model.service.Impl.CommandeItemService;


@RestController
@CrossOrigin(value = "http://localhost:4200")
public class CommandeItemRest {
	@Autowired
	private CommandeItemService commandeItemService;
	
	@RequestMapping(value = "/CommandeItems/refCmd",method = RequestMethod.DELETE)
	public int deleteById(@RequestBody List<CommandeItem> cmditems) {
		return commandeItemService.deleteById(cmditems);
	}

	@RequestMapping(value = "/CommandeItems",method = RequestMethod.POST)
	public int save(@RequestBody List<CommandeItem> commandeItem) {
		return commandeItemService.save(commandeItem);
	}
	
	@RequestMapping(value = "/CommandeItems/id/{id}",method = RequestMethod.DELETE)
	public int deleteById(@PathVariable Long id) {
		return commandeItemService.deleteById(id);
	}
	@RequestMapping(value = "/CommandeItems",method = RequestMethod.PUT)
	public int update(@RequestBody List<CommandeItem> commandeItem) {
		return commandeItemService.update(commandeItem);
	}
	@RequestMapping(value = "/CommandeItems",method = RequestMethod.GET)
	public List<CommandeItem> getAll() {
		return commandeItemService.getAll();
	}
	@RequestMapping(value = "/CommandeItems/id/{id}",method = RequestMethod.GET)
	public CommandeItem findById(@PathVariable Long id) {
		return commandeItemService.findById(id);
	}
	

	@RequestMapping(value = "/CommandeItems/reference/{reference}",method = RequestMethod.GET)
	public List<CommandeItem> findByRefCmd(@PathVariable String reference) {
		return commandeItemService.findByRefCmd(reference);
	}
	@RequestMapping(value = "/CommandeItems/reference/{reference}",method = RequestMethod.DELETE)
	public int deleteByRefCmd(@PathVariable String reference) {
		return commandeItemService.deleteByRefCmd(reference);
	}
	
}
