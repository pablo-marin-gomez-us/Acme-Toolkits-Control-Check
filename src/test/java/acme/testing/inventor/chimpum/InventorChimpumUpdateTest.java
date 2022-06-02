package acme.testing.inventor.chimpum;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorChimpumUpdateTest extends TestHarness {
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/chimpum/update.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String pattern, final String title, final String description, final String creationMoment, final String startDate, final String finishDate, final String budget, final String link) {
		
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "List chimpums");
		super.checkListingExists();
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("description", description);
		
		Calendar calendar;
		
		calendar = new GregorianCalendar();
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, +1);
		
		final Date newS = calendar.getTime();
		
		calendar.add(Calendar.DAY_OF_MONTH, +9);
		
		final Date newE = calendar.getTime();

		final String newStartDate = new SimpleDateFormat("dd/MM/yyyy").format(newS);
		
		final String newEndtDate = new SimpleDateFormat("dd/MM/yyyy").format(newE);
		
		super.fillInputBoxIn("startDate", newStartDate);
		super.fillInputBoxIn("finishDate", newEndtDate);
		
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("finishDate", finishDate);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("link", link);
		
		super.clickOnSubmit("Update");
		
		super.checkNotErrorsExist();
		super.sortListing(1, "desc");
		
		super.clickOnMenu("Inventor", "List chimpums");
		super.checkListingExists();
		
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, description);
		super.checkColumnHasValue(recordIndex, 3, startDate);		
		super.checkColumnHasValue(recordIndex, 4, finishDate);
		super.checkColumnHasValue(recordIndex, 5, budget);	
		super.checkColumnHasValue(recordIndex, 6, link);	
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/chimpum/updateNegative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negative(final int recordIndex, final String pattern, final String title, final String description, final String creationMoment, final String startDate, final String finishDate, final String budget, final String link) {
		
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "List chimpums");
		super.checkListingExists();
		super.clickOnListingRecord(0);
		super.checkFormExists();
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("finishDate", finishDate);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("link", link);
		
		super.clickOnSubmit("Update");
		
		super.checkErrorsExist();
		
	}
	
}
