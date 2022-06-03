package acme.features.inventor.BULET;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.BULET.BULET;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorBULETShowService implements AbstractShowService<Inventor, BULET>{
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorBULETRepository repository;

	// AbstractShowService<Inventor, CHIMPUM> interface --------------
	
	@Override
	public boolean authorise(final Request<BULET> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public BULET findOne(final Request<BULET> request) {
		assert request != null;

		int id;

		id = request.getModel().getInteger("id");
		final BULET result = this.repository.findBULETById(id);
		

		return result;
	}
	@Override
	public void unbind(final Request<BULET> request, final BULET entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		model.setAttribute("code", entity.getPatternDate());

		request.unbind(entity, model,"code","name", "summary", "creationMoment","startDate","finishDate","quota","link");
	}


}
