package kodlamaio.hrms.core.utilities.cloudinary;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface CloudinaryImageService {
	DataResult<Map> uploadImage(MultipartFile file);
}
