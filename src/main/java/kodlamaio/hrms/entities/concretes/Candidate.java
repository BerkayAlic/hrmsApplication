package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@Table(name="candidates")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="userid",referencedColumnName = "id")

public class Candidate extends User{

	
	@NotNull(message = "Name cannot be null")
	@Column(name="first_name")
	private String firstName;
	
	@NotNull(message = "LastName cannot be null")
	@Column(name="last_name")
	private String lastName;
	
	@NotNull(message = "Nationalid cannot be null")
	@Column(name="national_id")
	private String nationalid;
	
	@NotNull(message = "Birth Year cannot be null")
	@Column(name="birth_year")
	private String birthYear;
	

}
