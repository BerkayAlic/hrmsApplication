package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	List<JobAdvertisement> getByEnable(Boolean enable);
	
	List<JobAdvertisement> getByEnableAndCreatedAt(Boolean enable, Date createdAt);
	
	List<JobAdvertisement> getByEnableAndEmployerId(Boolean enable, int id);
}
