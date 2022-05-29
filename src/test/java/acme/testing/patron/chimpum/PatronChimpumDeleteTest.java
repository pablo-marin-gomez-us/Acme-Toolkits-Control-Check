package acme.testing.patron.chimpum;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;

public class PatronChimpumDeleteTest extends TestHarness {
	
	
	@Test
	@Order(10)
	public void positive() {
		
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Patron", "List chimpums");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		super.clickOnSubmit("Delete");
		super.checkNotErrorsExist();
	}
	
	@Test
	@Order(20)
	public void negative() {
		
		super.navigate("/patron/chimpum/list");
		super.checkErrorsExist();
		
	}
}
