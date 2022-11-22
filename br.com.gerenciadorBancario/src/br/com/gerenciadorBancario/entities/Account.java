package br.com.gerenciadorBancario.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "Account")
@DynamicUpdate
public class Account {
	
	@Id
	@SequenceGenerator(name ="account_sequence",
						sequenceName = "account_Sequence",
						initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_sequence")
	@Column(name = "ID_ACCOUNT", nullable = false)
	private Integer id;
	
	@Column(name = "NUM_ACCOUNT", nullable = false, unique = true)
	private Integer numAccount;
	
	@Column(name = "BALANCE", nullable = false)
	private Double balance;
	
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = User.class)
	@JoinColumn(name = "ID_USER", nullable = false, referencedColumnName = "ID_USER")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Bank.class)
	@JoinColumn(name = "ID_BANK", nullable = false, referencedColumnName = "ID_BANK")
	private Bank bank;
	
	public Account() {
	}

	public Account(Integer numConta, Double saldo, User user, String senha, Bank bank) {
		this.numAccount = numConta;
		this.balance = saldo;
		this.user = user;
		this.password = senha;
		this.bank = bank;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getNumAccount() {
		return numAccount;
	}
	
	public void setNumConta(Integer numConta) {
		this.numAccount = numConta;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public void setBalance(Double saldo) {
		this.balance = saldo;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String senha) {
		this.password = senha;
	}
	
	public Bank getBank() {
		return bank;
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
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
		Account other = (Account) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", numAccount=" + numAccount + ", balance=" + balance + ", user=" + user + ", password="
				+ password + ", bank=" + bank + "]";
	}
}
