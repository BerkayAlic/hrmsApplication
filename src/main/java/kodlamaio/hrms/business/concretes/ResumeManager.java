package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.cloudinary.CloudinaryImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService{
	
	private ResumeDao resumeDao;
	private CloudinaryImageService cloudinaryImageService;


	@Autowired
	public ResumeManager(ResumeDao resumeDao,CloudinaryImageService cloudinaryImageService) {
		this.resumeDao = resumeDao;
		this.cloudinaryImageService = cloudinaryImageService;
	}

	@Override
	public Result add(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("Added");
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>
		(this.resumeDao.findAll(),"Listed");
	}

	@Override
	public Result addImage(MultipartFile file, int resumeId) {
		Map<String, String> uploadImage = this.cloudinaryImageService.uploadImage(file).getData();
		String imageUrl = uploadImage.get("url");
		Resume resume = resumeDao.getOne(resumeId);
		resume.setPhoto(imageUrl);
		resumeDao.save(resume);
		return new SuccessResult("Image is added");
	}
}
