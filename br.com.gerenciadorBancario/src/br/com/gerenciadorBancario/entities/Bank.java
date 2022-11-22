package br.com.gerenciadorBancario.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "BANK")
@DynamicUpdate
public class Bank {
	
	@Id
	@SequenceGenerator(name ="bank_sequence",
						sequenceName = "bank_Sequence",
						initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_sequence")
	@Column(name = "ID_BANK", nullable = false)
	private Integer id;
	
	@Column(name = "NAME_BANK", nullable = false, length = 30)
	private String name;
	
	@Column(name ="MANAGER", nullable = false, length =30)
	private String manager;
	
	@Column(name = "CNPJ", nullable = false, length = 14)
	private String cnpj;
	
	
	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Bank() {
	}
	
	public Bank(String nome, String cnpj) {
		this.name = nome;
		this.cnpj = cnpj;
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
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
		Bank other = (Bank) obj;
		return id == other.id;
	}
	
	@Override
	public String toString() {
		return "Banco [id=" + id + ", name=" + name + ", cnpj=" + cnpj + "]";
	}
}
