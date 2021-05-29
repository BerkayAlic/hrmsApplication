package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//Getter ve setterlari olusturur.
@Entity
//Abstractta olusturdugumuz Entity interface i yerine gecer.
//Classin hangi katmana karsilik geldigini yazariz.
// Bu nesnenin bir veritabani nesnesi oldugunu soyler.
//Anotasyon bir classin calisma esnasinda onunla ilgili bilgi toplar
@Table(name="positions")
// Veritabaninda bu nesnenin hangi tabloya karsilik geldigini soyler.
@NoArgsConstructor
//Parametresiz constructor i atar.
@AllArgsConstructor
//Tum fieldlari iceren bir constructor olusturur.
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Position{
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		//Post metoduyla veri ekledigin zaman id ler karismasin diye burdan
		//IDENDITY seciyorsun. Frontend ile senkron calisacak.
		@Column(name="id")
		private int id;
		
		@Column(name="position")
		private String position;
		
		
		@OneToMany(mappedBy="position")
		private List<JobAdvertisement> jobAdvertisements;
		
		
}
