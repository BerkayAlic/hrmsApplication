package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@Table(name="employers")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="userid",referencedColumnName = "id")

public class Employer extends User{

	
	@NotBlank(message="Company name can not be empty")
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank(message="Website can not be empty")
	@Column(name="website")
	private String webSite;
	
	@NotBlank(message="Phone number can not be empty")
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="is_activated")
	private boolean isActivated;
	
//	@OneToMany(mappedBy="employer")
//	private List<JobAdvertisement> jobAdvertisements;
	
}
