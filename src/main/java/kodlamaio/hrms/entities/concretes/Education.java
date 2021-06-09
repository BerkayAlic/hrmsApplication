package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="resume_educations")
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name="resume_id")
	private Resume resume;
	
	@Column(name="school_name")
	@NotBlank
	private String schoolName;
	
	@ManyToOne(targetEntity = Graduate.class)
	@JoinColumn(name = "graduate_id", referencedColumnName = "id")
	private Graduate graduate;
	
	@Column(name="school_department")
	@NotBlank
	private String schoolDepartment;
	
	@Column(name="starting_year")
	@NotBlank
	private LocalDate startingDate;
	
	@Column(name="ending_year")
	private LocalDate endingDate;
	
	@Column(name="created_date")
	private LocalDate createdDate;
}
