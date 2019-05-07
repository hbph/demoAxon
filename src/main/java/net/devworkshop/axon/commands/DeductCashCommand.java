package net.devworkshop.axon.commands;

public class DeductCashCommand extends BaseCommand<String> {

	public final double debitAmount;

	public final String currency;

	public DeductCashCommand(String id, double debitAmount, String currency) {
		super(id);
		this.debitAmount = debitAmount;
		this.currency = currency;
	}
}
