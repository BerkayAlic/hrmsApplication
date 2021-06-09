package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.entities.concretes.Position;

@Service
public class PositionManager implements PositionService{

	private PositionDao positionDao;
	
	//Autowired altindaki veri tipine bakar.
	//altindaki veri tipinin implemente oldugu bir somut sinif bakar.
	//Bulunca arkada onu new ler.
	//Nerde positiondao istenirse onun referansini atar.
	//Elle new lememize gerek kalmaz.
	//Autowired da o servisi implemente eden 2 somut sinif varsa hata firlatir.
	
	@Autowired
	public PositionManager(PositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}

	@Override
	public DataResult<List<Position>> getAll() {
		
		return new SuccessDataResult<List<Position>>
		(this.positionDao.findAll(),"Positions listed");
				
				
	}

	@Override
	public Result add(Position position) {
		
		if(this.positionDao.existsByJobTitle(position.getJobTitle()))
			return new ErrorResult("Position already exist");
		this.positionDao.save(position);
		return new SuccessResult("Position is added");
	}

}
