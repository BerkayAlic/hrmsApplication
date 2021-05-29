package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>
		(jobAdvertisementDao.findAll(),"JobAdvertisements listed");
		
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("JobAdvertisement added");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEnable(Boolean enable) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(jobAdvertisementDao.getByEnable(true),"JobAdvertisements listed");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEnableAndCreatedAt(Boolean enable, Date createdAt) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(jobAdvertisementDao.getByEnableAndCreatedAt(true, createdAt),"JobAdvertisements listed");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEnableAndEmployerId(Boolean enable, int id) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(jobAdvertisementDao.getByEnableAndEmployerId(true, id),"JobAdvertisements listed");
	}

	





	
}
