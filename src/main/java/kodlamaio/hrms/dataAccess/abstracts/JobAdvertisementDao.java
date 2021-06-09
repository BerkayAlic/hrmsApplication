package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	List<JobAdvertisement> getByEnable(Boolean enable);
	
	List<JobAdvertisement> getByEnableAndCreatedAt(Boolean enable, Date createdAt);
	
	List<JobAdvertisement> getByEnableAndEmployerId(Boolean enable, int id);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerDto(j.id, "
			+ " e.companyName, j.position.jobTitle,  j.numberOfOpenPosition, j.createdAt, j.expirationDate)"
			+ "From JobAdvertisement j "
			+ "Inner Join j.position p"
			+ "Inner Join j.employer e")		
	List<JobAdvertisementWithEmployerDto> getAllAdvDetails();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerDto(j.id, "
			+ " e.companyName, j.position.jobTitle,  j.numberOfOpenPosition, j.createdAt, j.expirationDate)"
			+ "From JobAdvertisement j "
			+ "Inner Join j.position p"
			+ "Inner Join j.employer e")	
	List<JobAdvertisementWithEmployerDto> getByActiveAdvDetails(Boolean enable);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerDto(j.id, "
			+ " e.companyName, j.position.jobTitle,  j.numberOfOpenPosition, j.createdAt, j.expirationDate)"
			+ "From JobAdvertisement j "
			+ "Inner Join j.position p"
			+ "Inner Join j.employer e")	
	List<JobAdvertisementWithEmployerDto> getByActiveAndCreatedAtAdvDetails(Boolean enable, Date createdAt);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerDto(j.id, "
			+ " e.companyName, j.position.jobTitle,  j.numberOfOpenPosition, j.createdAt, j.expirationDate)"
			+ "From JobAdvertisement j "
			+ "Inner Join j.position p"
			+ "Inner Join j.employer e")
	List<JobAdvertisementWithEmployerDto> getByActiveAndEmployerIdAdvDetails(Boolean enable, int id);
	
	
	
}
