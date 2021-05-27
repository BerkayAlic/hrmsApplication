package kodlamaio.hrms.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class FakeMernisAdapter  implements ValidationService{

	@Override
	public boolean idendityValidate(Candidate candidate) {
		
		return true;
	}

}
