package acme.features.inventor.BULET;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.BULET.BULET;
import acme.entities.artifacts.Artifact;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;

@Service
public class InventorBULETDeleteService  implements AbstractDeleteService<Inventor,BULET>{	
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorBULETRepository repository;
	
	// AbstractListService<Inventor, CHIMPUM> interface ---------------------------
	
	@Override
	public boolean authorise(final Request<BULET> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public void bind(final Request<BULET> request, final BULET entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "code","name", "summary", "creationMoment","startDate","finishDate","quota","link");
		
	}

	@Override
	public void unbind(final Request<BULET> request, final BULET entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		
				
		request.unbind(entity, model, "code","name", "summary", "creationMoment","startDate","finishDate","quota","link");
		
		
	}

	@Override
	public BULET findOne(final Request<BULET> request) {
		assert request != null;

		BULET result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findBULETById(id);

		return result;
	}


	@Override
	public void validate(final Request<BULET> request, final BULET entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	}
		
		@Override
		public void delete(final Request<BULET> request, final BULET entity) {
			assert request != null;
			assert entity != null;
			
			Collection<Artifact> artifacts;
			
			artifacts = this.repository.findToolsAndComponentsByBULETId(entity.getId());
			
			for (final Artifact a: artifacts) {
				a.setBulet(null);
			}
			
			this.repository.saveAll(artifacts);
			this.repository.delete(entity);
			
		}
		
		
		




}
