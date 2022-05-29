package acme.testing.patron.chimpum;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronChimpumCreateTest extends TestHarness {
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/chimpum/create.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String pattern, final String title, final String description, final String creationMoment, final String startDate, final String finishDate, final String budget, final String link) {
		
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Patron", "List chimpums");
		super.checkListingExists();
		super.clickOnButton("Create");
		super.checkFormExists();
		super.fillInputBoxIn("pattern", pattern);
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("finishDate", finishDate);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("link", link);
		
		super.clickOnSubmit("Create");
		
		super.checkNotErrorsExist();
		super.sortListing(0, "asc");
		
		super.clickOnMenu("Patron", "List chimpums");
		super.checkListingExists();
		super.sortListing(3, "desc");
		
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, description);
		super.checkColumnHasValue(recordIndex, 3, startDate);		
		super.checkColumnHasValue(recordIndex, 4, finishDate);
		super.checkColumnHasValue(recordIndex, 5, budget);	
		super.checkColumnHasValue(recordIndex, 6, link);	
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/chimpum/createNegative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negative(final int recordIndex, final String pattern, final String title, final String description, final String creationMoment, final String startDate, final String finishDate, final String budget, final String link) {
		
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Patron", "List chimpums");
		super.checkListingExists();
		super.clickOnButton("Create");
		super.checkFormExists();
		super.fillInputBoxIn("pattern", pattern);
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("finishDate", finishDate);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("link", link);
		
		super.clickOnSubmit("Create");
		
		super.checkErrorsExist();
		
	}
}
