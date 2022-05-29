package acme.features.patron.CHIMPUM;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.CHIMPUM.CHIMPUM;
import acme.entities.artifacts.Artifact;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Patron;

@Service
public class PatronCHIMPUMDeleteService  implements AbstractDeleteService<Patron,CHIMPUM>{	
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronCHIMPUMRepository repository;
	
	// AbstractListService<Patron, CHIMPUM> interface ---------------------------
	
	@Override
	public boolean authorise(final Request<CHIMPUM> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public void bind(final Request<CHIMPUM> request, final CHIMPUM entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "pattern","title", "description", "creationMoment","startDate","finishDate","budget","link");
		
	}

	@Override
	public void unbind(final Request<CHIMPUM> request, final CHIMPUM entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		
				
		request.unbind(entity, model, "pattern","title", "description", "creationMoment","startDate","finishDate","budget","link");
		
		
	}

	@Override
	public CHIMPUM findOne(final Request<CHIMPUM> request) {
		assert request != null;

		CHIMPUM result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findCHIMPUMById(id);

		return result;
	}


	@Override
	public void validate(final Request<CHIMPUM> request, final CHIMPUM entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	}
		
		@Override
		public void delete(final Request<CHIMPUM> request, final CHIMPUM entity) {
			assert request != null;
			assert entity != null;
			
			Collection<Artifact> artifacts;
			
			artifacts = this.repository.findToolsAndComponentsByCHIMPUMId(entity.getId());
			
			for (final Artifact a: artifacts) {
				a.setChimpum(null);
			}
			
			this.repository.saveAll(artifacts);
			this.repository.delete(entity);
			
		}
		
		
		




}
