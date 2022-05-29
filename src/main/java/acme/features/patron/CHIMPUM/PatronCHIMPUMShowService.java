package acme.features.patron.CHIMPUM;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.CHIMPUM.CHIMPUM;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronCHIMPUMShowService implements AbstractShowService<Patron, CHIMPUM>{
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronCHIMPUMRepository repository;

	// AbstractShowService<Patron, CHIMPUM> interface --------------
	
	@Override
	public boolean authorise(final Request<CHIMPUM> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public CHIMPUM findOne(final Request<CHIMPUM> request) {
		assert request != null;

		int id;

		id = request.getModel().getInteger("id");
		final CHIMPUM result = this.repository.findCHIMPUMById(id);
		

		return result;
	}
	@Override
	public void unbind(final Request<CHIMPUM> request, final CHIMPUM entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "pattern","title", "description", "creationMoment","startDate","finishDate","budget","link");
	}


}
