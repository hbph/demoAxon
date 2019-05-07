package net.devworkshop.axon.events;

public class AddCashInCard extends BaseEvent<String> {

	public final double creditAmount;

	public final String currency;

	public AddCashInCard(String id, double creditAmount, String currency) {
		super(id);
		this.creditAmount = creditAmount;
		this.currency = currency;
	}
}
