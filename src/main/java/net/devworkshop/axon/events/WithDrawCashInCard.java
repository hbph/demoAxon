package net.devworkshop.axon.events;

public class WithDrawCashInCard extends BaseEvent<String> {

	public final double debitAmount;

	public final String currency;

	public WithDrawCashInCard(String id, double debitAmount, String currency) {
		super(id);
		this.debitAmount = debitAmount;
		this.currency = currency;
	}
}