package kodlamaio.hrms.api.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerDto;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();							
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getbyenable")
	public DataResult<List<JobAdvertisement>> getByEnable(){
		return this.jobAdvertisementService.getByEnable(true);							
	}
	
	@GetMapping("/getbyenableandcreatedat")
	public DataResult<List<JobAdvertisement>> getByEnableAndCreatedAt(@RequestParam Date createdAt){
		return this.jobAdvertisementService.getByEnableAndCreatedAt(true, createdAt);							
	}
	
	@GetMapping("/getbyenableandemployerid")
	public DataResult<List<JobAdvertisement>> getByEnableAndEmployerId(@RequestParam int id){
		return this.jobAdvertisementService.getByEnableAndEmployerId(true, id);							
	}
	
	@GetMapping("/getAllAdvDetails")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getAllAdvDetails(){
		return this.jobAdvertisementService.getAllAdvDetails();							
	}
	
	@GetMapping("/getActiveAdvDetails")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getActiveAdvDetails(){
		return this.jobAdvertisementService.getActiveAdvDetails(true);							
	}
	
	@GetMapping("/getByActiveAndCreatedAtAdvDetails")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getByActiveAndCreatedAtAdvDetails(@RequestParam Date createdAt){
		return this.jobAdvertisementService.getByActiveAndCreatedAtAdvDetails(true, createdAt);							
	}
	
	@GetMapping("/getByActiveAndEmployerIdAdvDetails")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getByActiveAndEmployerIdAdvDetails(@RequestParam int id){
		return this.jobAdvertisementService.getByActiveAndEmployerIdAdvDetails(true, id);							
	}
}
