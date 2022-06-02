package acme.features.patron.CHIMPUM;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.CHIMPUM.CHIMPUM;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.helpers.CollectionHelper;
import acme.framework.services.AbstractListService;
import acme.roles.Patron;

@Service
public class PatronCHIMPUMListService implements AbstractListService<Patron, CHIMPUM>{
	
	// Internal state -------------------------------------------------------------------

		@Autowired
		protected PatronCHIMPUMRepository repository;

		// AbstractListService<Patron, CHIMPUM> interface ---------------------------

		@Override
		public boolean authorise(final Request<CHIMPUM> request) {
			assert request != null;


			return true;
		}

		@Override
		public Collection<CHIMPUM> findMany(final Request<CHIMPUM> request) {
			assert request != null;

			final Collection<CHIMPUM> chimpums;
			chimpums = this.repository.findAllCHIMPUM();
			return chimpums;
		}

		@Override
		public void unbind(final Request<CHIMPUM> request, final Collection<CHIMPUM> entities, final Model model) {
			assert request != null;
			assert !CollectionHelper.someNull(entities);
			assert model != null;
			
			
			
		}
		@Override
		public void unbind(final Request<CHIMPUM> request, final CHIMPUM entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;
			
			model.setAttribute("pattern", entity.getPatternDate());

			request.unbind(entity, model,"title","description","startDate","finishDate","budget","link");
		}


}
