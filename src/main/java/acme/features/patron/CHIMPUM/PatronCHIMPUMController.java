package acme.features.patron.CHIMPUM;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.CHIMPUM.CHIMPUM;
import acme.framework.controllers.AbstractController;
import acme.roles.Patron;

@Controller
public class PatronCHIMPUMController extends AbstractController<Patron, CHIMPUM>{
	
	// Internal state -------------------------------------------------------------------

	@Autowired
	protected PatronCHIMPUMListService listService;

	@Autowired
	protected PatronCHIMPUMShowService showService;
	
	@Autowired
	protected PatronCHIMPUMCreateService createService;
	
	@Autowired
	protected PatronCHIMPUMUpdateService updateService;
	
	@Autowired
	protected PatronCHIMPUMDeleteService deleteService;

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
