package acme.testing.inventor.bulet;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorBuletCreateTest extends TestHarness {
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/bulet/create.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String code, final String name, final String summary, final String creationMoment, final String startDate, final String finishDate, final String quota, final String link) {
		
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "List bulets");
		super.checkListingExists();
		super.clickOnButton("Create");
		super.checkFormExists();
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("summary", summary);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("finishDate", finishDate);
		super.fillInputBoxIn("quota", quota);
		super.fillInputBoxIn("link", link);
		
		super.clickOnSubmit("Create");
		
		super.checkNotErrorsExist();
		super.sortListing(0, "asc");
		
		super.clickOnMenu("Inventor", "List bulets");
		super.checkListingExists();
		super.sortListing(3, "desc");
		
		super.checkColumnHasValue(recordIndex, 1, name);
		super.checkColumnHasValue(recordIndex, 2, summary);
		super.checkColumnHasValue(recordIndex, 3, startDate);		
		super.checkColumnHasValue(recordIndex, 4, finishDate);
		super.checkColumnHasValue(recordIndex, 5, quota);	
		super.checkColumnHasValue(recordIndex, 6, link);	
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/bulet/createNegative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negative(final int recordIndex, final String code, final String name, final String summary, final String creationMoment, final String startDate, final String finishDate, final String quota, final String link) {
		
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "List bulets");
		super.checkListingExists();
		super.clickOnButton("Create");
		super.checkFormExists();
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("summary", summary);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("finishDate", finishDate);
		super.fillInputBoxIn("quota", quota);
		super.fillInputBoxIn("link", link);
		
		super.clickOnSubmit("Create");
		
		super.checkErrorsExist();
		
	}
	
	@Test
	@Order(30)
	public void hacking() {
		
		super.navigate("/inventor/bulet/create");
		super.checkErrorsExist();
		
	}
	
	
}
