package kodlamaio.hrms.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class EmailVerificationManager implements EmailVerificationService {

	@Override
	public boolean emailVerification(String email) {
		
		return true;
	}

	

}
