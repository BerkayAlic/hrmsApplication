package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="job_description")
	@Type(type="text")
	private String jobDescription;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="number_of_open_positions")
	private int numberOfOpenPosition;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="expiration_date")
	private LocalDate expirationDate;
	
	@Column(name="enable")
	private boolean enable;
	
	
	@ManyToOne(targetEntity = City.class)
	@JoinColumn(name="city_id", referencedColumnName =  "id")
	private City city;
	
	
	@ManyToOne(targetEntity = Employer.class)
	@JoinColumn(name="employer_id" , referencedColumnName =  "userid")
	private Employer employer;
	
	
	@ManyToOne(targetEntity = Position.class)
	@JoinColumn(name="position_id" , referencedColumnName =  "id")
	private Position position;
	
}
