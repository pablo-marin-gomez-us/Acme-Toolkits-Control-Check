package acme.features.inventor.BULET;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.BULET.BULET;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.helpers.CollectionHelper;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorBULETListService implements AbstractListService<Inventor, BULET>{
	
	// Internal state -------------------------------------------------------------------

		@Autowired
		protected InventorBULETRepository repository;

		// AbstractListService<Inventor, CHIMPUM> interface ---------------------------

		@Override
		public boolean authorise(final Request<BULET> request) {
			assert request != null;


			return true;
		}

		@Override
		public Collection<BULET> findMany(final Request<BULET> request) {
			assert request != null;

			final Collection<BULET> chimpums;
			chimpums = this.repository.findAllBULET();
			return chimpums;
		}

		@Override
		public void unbind(final Request<BULET> request, final Collection<BULET> entities, final Model model) {
			assert request != null;
			assert !CollectionHelper.someNull(entities);
			assert model != null;
			
			
			
		}
		@Override
		public void unbind(final Request<BULET> request, final BULET entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;
			
			model.setAttribute("code", entity.getPatternDate());

			request.unbind(entity, model,"name","summary","startDate","finishDate","quota","link");
		}


}
