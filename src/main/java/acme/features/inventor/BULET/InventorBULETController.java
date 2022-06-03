package acme.features.inventor.BULET;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.BULET.BULET;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorBULETController extends AbstractController<Inventor, BULET>{
	
	// Internal state -------------------------------------------------------------------

	@Autowired
	protected InventorBULETListService listService;

	@Autowired
	protected InventorBULETShowService showService;
	
	@Autowired
	protected InventorBULETCreateService createService;
	
	@Autowired
	protected InventorBULETUpdateService updateService;
	
	@Autowired
	protected InventorBULETDeleteService deleteService;

	// Constructors ---------------------------------------------------------------------

	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
		super.addCommand("create", this.createService);
		super.addCommand("update", this.updateService);
		super.addCommand("delete", this.deleteService);
	}
	

}
