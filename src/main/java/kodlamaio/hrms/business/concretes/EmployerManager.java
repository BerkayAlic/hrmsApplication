package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.adapters.EmailVerificationService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private EmailVerificationService emailVerificationService;

	@Autowired
	public EmployerManager(EmployerDao employerDao,
			EmailVerificationService emailVerificationService) {
		super();
		this.employerDao = employerDao;
		this.emailVerificationService = emailVerificationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll(),"Employers listed");
	}

	@Override
	public Result add(Employer employer) {
		
		if(this.employerDao.existsByEmail(employer.getEmail()))
		return new ErrorResult("Email already exist");
		
		if(!emailVerifiy(employer.getEmail()))
		return new ErrorResult("Email is not confirmed");
		
		if(!isSameDomain(employer))
		return new ErrorResult("Domain is not the same");
		
		if (!employer.getPassword().equals(employer.getPasswordRepeat())) {
			return new ErrorResult("Şifre - Şifre tekrarı alanları aynı olmalıdır.");
		}
		
		this.employerDao.save(employer);
		return new SuccessDataResult("Employer is added");
		
		
	}
	
	
	public boolean emailVerifiy(String email) {
		return emailVerificationService.emailVerification(email);
	}
	
	public boolean isSameDomain(Employer employer) {
		
		boolean result = false ;
		
		String employerEmail        = employer.getEmail();
		String[] employeremailSplit = employerEmail.split("@");
		
		String employerWebsite        = employer.getWebSite();
		String[] employerWebsiteSplit = employerWebsite.split("www.");
		
		if(employerWebsiteSplit[1].equals(employeremailSplit[1])) 
			result = true;
		
		return result;
	}

}
