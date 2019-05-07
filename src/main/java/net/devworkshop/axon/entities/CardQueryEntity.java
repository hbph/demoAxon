package net.devworkshop.axon.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CardQueryEntity {

	@Id
	private String id;

	private double cashBalance;

	private String currency;

	private String status;

	public CardQueryEntity() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getAccountBalance() {
		return cashBalance;
	}

	public void setAccountBalance(double cashBalance) {
		this.cashBalance = cashBalance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CardQueryEntity{" + "id='" + id + '\'' + ", cashBalance=" + cashBalance + ", currency='"
				+ currency + '\'' + ", status='" + status + '\'' + '}';
	}

}
