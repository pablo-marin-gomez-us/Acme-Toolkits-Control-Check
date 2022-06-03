package acme.testing.inventor.bulet;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorBuletUpdateTest extends TestHarness {
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/bulet/update.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String code, final String name, final String summary, final String creationMoment, final String startDate, final String finishDate, final String quota, final String link) {
		
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "List bulets");
		super.checkListingExists();
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("summary", summary);
		
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
		
		super.fillInputBoxIn("quota", quota);
		super.fillInputBoxIn("link", link);
		
		super.clickOnSubmit("Update");
		
		super.checkNotErrorsExist();
		super.sortListing(1, "desc");
		
		super.clickOnMenu("Inventor", "List bulets");
		super.checkListingExists();
		
		super.checkColumnHasValue(recordIndex, 1, name);
		super.checkColumnHasValue(recordIndex, 2, summary);
		super.checkColumnHasValue(recordIndex, 3, startDate);		
		super.checkColumnHasValue(recordIndex, 4, finishDate);
		super.checkColumnHasValue(recordIndex, 5, quota);	
		super.checkColumnHasValue(recordIndex, 6, link);	
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/bulet/updateNegative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negative(final int recordIndex, final String code, final String name, final String summary, final String creationMoment, final String startDate, final String finishDate, final String quota, final String link) {
		
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "List bulets");
		super.checkListingExists();
		super.clickOnListingRecord(0);
		super.checkFormExists();
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("summary", summary);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("finishDate", finishDate);
		super.fillInputBoxIn("quota", quota);
		super.fillInputBoxIn("link", link);
		
		super.clickOnSubmit("Update");
		
		super.checkErrorsExist();
		
	}
	
}
