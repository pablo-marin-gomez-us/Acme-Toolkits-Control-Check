package acme.features.inventor.BULET;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.BULET.BULET;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;
import features.SpamDetector;

@Service
public class InventorBULETUpdateService  implements AbstractUpdateService<Inventor,BULET>{	
	
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
		
		request.bind(entity, errors, "name", "summary", "creationMoment","startDate","finishDate","quota","link");
		
	}

	@Override
	public void unbind(final Request<BULET> request, final BULET entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		
				
		request.unbind(entity, model, "name", "summary", "creationMoment","startDate","finishDate","quota","link");
		
		
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
		
		SpamDetector spamDetector;
		String strongSpamTerms;
		String weakSpamTerms;
		int strongSpamThreshold;
		int weakSpamThreshold;
		
		spamDetector = new SpamDetector();
		strongSpamTerms = this.repository.findStrongSpamTerms();
		weakSpamTerms = this.repository.findWeakSpamTerms();
		strongSpamThreshold = this.repository.findStrongSpamTreshold();
		weakSpamThreshold = this.repository.findWeakSpamTreshold();
		
		
		if(!errors.hasErrors("name")) {
			errors.state(request, !spamDetector.containsSpam(weakSpamTerms.split(","), weakSpamThreshold, entity.getName())
				&& !spamDetector.containsSpam(strongSpamTerms.split(","), strongSpamThreshold, entity.getName()),
				"name", "inventor.BULET.form.error.spam");
		}
		
		if(!errors.hasErrors("summary")) {
			errors.state(request, !spamDetector.containsSpam(weakSpamTerms.split(","), weakSpamThreshold, entity.getSummary())
				&& !spamDetector.containsSpam(strongSpamTerms.split(","), strongSpamThreshold, entity.getSummary()),
				"summary", "inventor.BULET.form.error.spam");
		}
		
		if(!errors.hasErrors("startDate")) {
			Calendar calendar;
			
			calendar = new GregorianCalendar();
			calendar.setTime(entity.getCreationMoment());
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			
			errors.state(request, entity.getStartDate().after(calendar.getTime()), "startDate", "inventor.CHIMPUM.form.error.startDate");
		}
		
		if(!errors.hasErrors("finishDate")) {
			Calendar calendar;
			
			calendar = new GregorianCalendar();
			calendar.setTime(entity.getStartDate());
			calendar.add(Calendar.DAY_OF_MONTH, 6);
			
			errors.state(request, entity.getFinishDate().after(calendar.getTime()), "finishDate", "inventor.CHIMPUM.form.error.finishDate");
		}
		
		if (!errors.hasErrors("quota")) {
			final String currency = entity.getQuota().getCurrency();
			final String currencyAvaliable = this.repository.acceptedCurrencies();
			boolean acceptedCurrency = false;
			
			for(final String cur: currencyAvaliable.split(",")) {
				acceptedCurrency = cur.trim().equalsIgnoreCase(currency);
				if(acceptedCurrency)
					break;
			}
			
			errors.state(request, entity.getQuota().getAmount() > 0 , "quota", "inventor.BULET.form.error.negative-budget");
			errors.state(request,acceptedCurrency, "quota", "inventor.BULET.form.error.negative-currency");
		}
		
		
		
		
		
	}

	@Override
	public void update(final Request<BULET> request, final BULET entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.save(entity);
	
	}



}
