package com.camila.languages.model;
import java.util.Date;





import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor

@Entity
@Table(name = "languages")

public class LanguageModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Size(min=2, max = 20, message = "Por favor agrege un nombre entre 2 a 20 caracteres.")
	private String name;
	
	@Size(min=2, max = 20, message = "Por favor agrege un nombre entre 2 a 20 caracteres.")
	private String creator;
	
	@NotBlank(message="No deje este espacio en blanco")
	@Size(min = 0, message = "Por favor agregue una version.")
	private String version;


	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;


//CONSTRUCTORES
	
	public LanguageModel(String name, String creator, String version) {
		this.name= name;
		this.creator= creator;
		this.version = version;
		
	}
	
	
	


	

	

	public LanguageModel(Long id2, String name2, String creator2, String version2) {
		// TODO Auto-generated constructor stub
	}









	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
		
	
@PrePersist
protected void onCreate() {
	this.createdAt = new Date();
}

@PreUpdate
protected void onUpdate() {
	this.updatedAt = new Date();
}

}
