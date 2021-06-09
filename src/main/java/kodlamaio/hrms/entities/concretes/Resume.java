package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="resumes")
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity = Candidate.class)
	@JoinColumn(name = "candidate_id", referencedColumnName = "user_id")
	private Candidate candidate;
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linkedin_link")
	private String linkedinLink;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="description")
	private String description;
	
	@Column(name="created_date")
	private LocalDate createdDate;
	
	@Column(name="is_active")
	private boolean is_active=true;
	
	@Column(name="updated_date")
	private LocalDate updated_date;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Language> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Technology> technologies;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<JobExperience> jobExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Education> educations;
}
