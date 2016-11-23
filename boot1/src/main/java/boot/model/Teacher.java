package boot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "teachers")
public class Teacher implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50)
	private String name;
	@Column(name = "lastname_pat", length = 50)
	private String lastNamePat;
	@Column(name = "lastname_mat", length = 50)
	private String lastNameMat;
	@Column(length = 16)
	private String dni;
	@Column(length = 100)
	private String address;
	@Column(length = 10)
	private String telephone;
	@Column(length = 100)
	private String email;

	public Teacher(String name, String lastNamePat, String lastNameMat, String dni, String address, String telephone,
			String email) {
		super();
		this.name = name;
		this.lastNamePat = lastNamePat;
		this.lastNameMat = lastNameMat;
		this.dni = dni;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
	}

	public Teacher() {
		this("", "", "", "", "", "", "");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastNamePat() {
		return lastNamePat;
	}

	public void setLastNamePat(String lastNamePat) {
		this.lastNamePat = lastNamePat;
	}

	public String getLastNameMat() {
		return lastNameMat;
	}

	public void setLastNameMat(String lastNameMat) {
		this.lastNameMat = lastNameMat;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Teacher [id= " + id + ", name=" + name + ", lastNamePat=" + lastNamePat + ", lastNameMat=" + lastNameMat
				+ ", dni=" + dni + ", address=" + address + ", telephone=" + telephone + ", email=" + email + "]";
	}

}
