package kodlamaio.hrms.business.abstracts;

import java.util.Date;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	
	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getByEnable(Boolean enable);
	
	DataResult<List<JobAdvertisement>> getByEnableAndCreatedAt(Boolean enable, Date createdAt);

	DataResult<List<JobAdvertisement>> getByEnableAndEmployerId(Boolean enable, int id);
}
