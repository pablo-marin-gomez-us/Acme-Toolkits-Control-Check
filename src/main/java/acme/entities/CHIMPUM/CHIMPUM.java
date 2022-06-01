package acme.entities.CHIMPUM;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CHIMPUM extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long		serialVersionUID	= 1L;
	
	

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Column(unique = false)
	//@Pattern(regexp="^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$") //dd/mm/yyyy
	//@Pattern(regexp="^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}-(0|[1-9][0-9]?|100)$")
	@Pattern(regexp = "[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected String				pattern;
	

	@NotBlank
	@Length(max=100)
	protected String				title;
	
	@NotBlank
	@Length(max=255)
	protected String				description;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@Past
	protected Date				creationMoment;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date				startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date				finishDate;
	
	@Valid
	@NotNull
	protected Money 			budget;

	@URL
	protected String				link;

	// Derived attributes -----------------------------------------------------
	
	public String getPatternDate() {
		
		final String date = new SimpleDateFormat("dd/MM/yyyy").format(this.creationMoment);
		return this.pattern.concat("-").concat(date);
	}
	
	
	// Relationships ----------------------------------------------------------


	
	
}
