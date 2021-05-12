package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
//Classin hangi katmana karsilik geldigini yazariz.
// Bu nesnenin bir veritabani nesnesi oldugunu soyler.
//Anotasyon bir classin calisma esnasinda onunla ilgili bilgi toplar
@Table(name="positions")
// Veritabaninda bu nesnenin hangi tabloya karsilik geldigini soyler.
public class Position{
	
		@Id
		@GeneratedValue
		@Column(name="id")
		private int id;
		
		@Column(name="position")
		private String position;
		
		public Position() {}
		
		public Position(int id, String position) {
			super();
			this.id = id;
			this.position = position;
		}
}
