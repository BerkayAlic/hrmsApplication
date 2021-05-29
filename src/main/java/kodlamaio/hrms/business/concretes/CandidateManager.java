package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.adapters.EmailVerificationService;
import kodlamaio.hrms.adapters.ValidationService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private ValidationService validationService;
	private EmailVerificationService emailVerificationService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao,
			ValidationService validationService, 
			EmailVerificationService emailVerificationService) {
		super();
		this.candidateDao = candidateDao;
		this.validationService = validationService;
		this.emailVerificationService = emailVerificationService;
		
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findAll(),"Candidates listed");
	}

	@Override
	public Result add(Candidate candidate) {
		
		if(!fakeMernisConfirmation(candidate))
			return new ErrorResult("Idendity number is not confirmed");
		
		if(this.candidateDao.existsByNationalid(candidate.getEmail()))
			return new ErrorResult("This nationalid already exist");
		
		if(this.candidateDao.existsByEmail(candidate.getEmail()))
			return new ErrorResult("This email alreadt exist");
		
		if(!emailVerifiy(candidate.getEmail()))
			return new ErrorResult("Email is not confirmed");
		
		if (!candidate.getPassword().equals(candidate.getPasswordRepeat())) {
			return new ErrorResult("Password should be the same with password repeat");
		}
		 			
		this.candidateDao.save(candidate);
		return new SuccessDataResult("Candidate is added");
		
		
	}
	
	private boolean fakeMernisConfirmation(Candidate candidate) {
		return validationService.idendityValidate(candidate);
	}
	
	private boolean emailVerifiy(String email) {
		return emailVerificationService.emailVerification(email);
	}
	
}
