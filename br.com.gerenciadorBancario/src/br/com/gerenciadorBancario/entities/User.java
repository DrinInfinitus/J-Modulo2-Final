package br.com.gerenciadorBancario.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "USERS")
@DynamicUpdate
public class User {
	
	@Id
	@SequenceGenerator(name ="user_sequence",
						sequenceName = "user_Sequence",
						initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	@Column(name = "ID_USER", nullable = false)
	private Integer id;
	
	@Column(name = "NAME", nullable = false, length = 60)
	private String name;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY", nullable = false)
	private Calendar birthday;
	
	@Column(name = "CPF", nullable = false, length = 11, unique = true)
	private String cpf;
	
	public User() {}
	
	public User(String nome, Calendar dataNascimento, String cpf, String senha) {
		this.name = nome;
		this.birthday = dataNascimento;
		this.cpf = cpf;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String nome) {
		this.name = nome;
	}
	
	public Calendar getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Calendar dataNascimento) {
		this.birthday = dataNascimento;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id;
	}
	

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Usuario [id=" + id + ", name=" + name + ", birthday=" + sdf.format(birthday.getTime()) + ", cpf=" + cpf
				+ "]";
	}
	
	
}
