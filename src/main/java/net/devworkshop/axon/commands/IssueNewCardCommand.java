package net.devworkshop.axon.commands;

public class IssueNewCardCommand extends BaseCommand<String> {

	public final double accountBalance;

	public final String currency;

	public IssueNewCardCommand(String id, double accountBalance, String currency) {
		super(id);
		this.accountBalance = accountBalance;
		this.currency = currency;
	}
}