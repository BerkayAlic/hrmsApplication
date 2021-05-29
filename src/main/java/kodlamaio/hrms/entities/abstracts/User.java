package kodlamaio.hrms.entities.abstracts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="id")
	private int id;
	
	@NotNull(message = "Email cannot be null")
	@Column(name="email")
	private String email;
	
	@NotNull(message = "Password cannot be null")
	@Column(name="password")
	private String password;
	
	@NotBlank(message = "Şifre tekrarı boş bırakılamaz.")
	@Transient 
	private String passwordRepeat;
}
