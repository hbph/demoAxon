package net.devworkshop.axon.commands;

public class AddCashCommand extends BaseCommand<String> {

	public final double creditAmount;

	public final String currency;

	public AddCashCommand(String id, double creditAmount, String currency) {
		super(id);
		this.creditAmount = creditAmount;
		this.currency = currency;
	}
}
