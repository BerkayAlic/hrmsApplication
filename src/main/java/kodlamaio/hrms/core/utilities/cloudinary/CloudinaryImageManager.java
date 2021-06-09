package kodlamaio.hrms.core.utilities.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryImageManager implements CloudinaryImageService{

	private Cloudinary cloudinary;
	
	public CloudinaryImageManager() {
		
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dtdgdrwrm",
				"api_key", "145937324359266",
				"api_secret","_k70dbiLRgfc5b8dVfr7Qn4JL6I"));
	}
	
	@Override
	public DataResult<Map> uploadImage(MultipartFile file) {
		try {
			
			Map result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(result);
		
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return new ErrorDataResult<Map>();
	}

}
