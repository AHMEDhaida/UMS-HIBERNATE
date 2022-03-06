package com.ums.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity (name="User")
public class User {
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String login;
	private String password;
	private String role;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")

	private int  id;
    
	
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public User(int id, String nom, String prenom, String email, String telephone, String login, String password,
			String role) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.login = prenom.trim().toLowerCase() + "." + nom.trim().toLowerCase();
        this.role = role;
        
	}
	
	
    public User(String nom, String prenom, String email, String telephone, Role role) {
          this.nom = nom;
          this.prenom = prenom;
          this.email = email;
          this.telephone = telephone;
          
          // login et password par défaut ...
          this.login = prenom.trim().toLowerCase() + "." + nom.trim().toLowerCase();
          
          this.password = "p@Ss3R";
          this.role = role.getValue();
    }
    
    // générer ensuite les getters and setters 

    public User() {
    	this("", "", "", "", Role.SIMPLE_USER);
    	this.login = "";
    	this.password = "";
    	}

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
 
    
    
    
    

}