package kodlamaio.hrms.adapters;

import org.springframework.stereotype.Service;


public interface EmailVerificationService {
	public boolean emailVerification(String email);
}
