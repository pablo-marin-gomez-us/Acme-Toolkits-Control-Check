package acme.testing.patron.chimpum;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronChimpumListTest extends TestHarness {
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/chimpum/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String pattern, final String title, final String description, final String creationMoment, final String startDate, final String finishDate, final String budget, final String link) {
		
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Patron", "List chimpums");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, pattern);
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, description);
		super.checkColumnHasValue(recordIndex, 3, startDate);		
		super.checkColumnHasValue(recordIndex, 4, finishDate);
		super.checkColumnHasValue(recordIndex, 5, budget);	
		super.checkColumnHasValue(recordIndex, 6, link);	
	}
	
	@Test
	@Order(20)
	public void negative() {
		
		super.navigate("/patron/chimpum/list");
		super.checkErrorsExist();
		
	}
}
