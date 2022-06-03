package acme.testing.inventor.bulet;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;

public class InventorBuletDeleteTest extends TestHarness {
	
	
	@Test
	@Order(10)
	public void positive() {
		
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "List bulets");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		super.clickOnSubmit("Delete");
		super.checkNotErrorsExist();
	}
	
	@Test
	@Order(20)
	public void hacking() {
		
		super.navigate("/inventor/bulet/list");
		super.checkErrorsExist();
		
	}
}
