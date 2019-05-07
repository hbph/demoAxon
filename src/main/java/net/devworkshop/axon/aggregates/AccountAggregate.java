package net.devworkshop.axon.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import net.devworkshop.axon.commands.IssueNewCardCommand;
import net.devworkshop.axon.commands.AddCashCommand;
import net.devworkshop.axon.commands.DeductCashCommand;
import net.devworkshop.axon.events.ActivateCard;
import net.devworkshop.axon.events.IssueNewCard;
import net.devworkshop.axon.events.SuspendCard;
import net.devworkshop.axon.events.AddCashInCard;
import net.devworkshop.axon.events.WithDrawCashInCard;

@Aggregate
public class AccountAggregate {
	
	@AggregateIdentifier
	private String id;

	private double accountBalance;

	private String currency;

	private String status;

	public AccountAggregate() {
	}

	@CommandHandler
	public AccountAggregate(IssueNewCardCommand createAccountCommand) {
		AggregateLifecycle.apply(new IssueNewCard(createAccountCommand.id, createAccountCommand.accountBalance,
				createAccountCommand.currency));
	}

	@EventSourcingHandler
	protected void on(IssueNewCard accountCreatedEvent) {
		this.id = accountCreatedEvent.id;
		this.accountBalance = accountCreatedEvent.accountBalance;
		this.currency = accountCreatedEvent.currency;
		this.status = String.valueOf(CardStatus.CREATED);

		AggregateLifecycle.apply(new ActivateCard(this.id, CardStatus.ACTIVATED));
	}

	@EventSourcingHandler
	protected void on(ActivateCard accountActivatedEvent) {
		this.status = String.valueOf(accountActivatedEvent.status);
	}

	@CommandHandler
	protected void on(AddCashCommand creditMoneyCommand) {
		AggregateLifecycle.apply(new AddCashInCard(creditMoneyCommand.id, creditMoneyCommand.creditAmount,
				creditMoneyCommand.currency));
	}

	@EventSourcingHandler
	protected void on(AddCashInCard moneyCreditedEvent) {

		if (this.accountBalance < 0 & (this.accountBalance + moneyCreditedEvent.creditAmount) >= 0) {
			AggregateLifecycle.apply(new ActivateCard(this.id, CardStatus.ACTIVATED));
		}

		this.accountBalance += moneyCreditedEvent.creditAmount;
	}

	@CommandHandler
	protected void on(DeductCashCommand debitMoneyCommand) {
		AggregateLifecycle.apply(
				new WithDrawCashInCard(debitMoneyCommand.id, debitMoneyCommand.debitAmount, debitMoneyCommand.currency));
	}

	@EventSourcingHandler
	protected void on(WithDrawCashInCard moneyDebitedEvent) {

		if (this.accountBalance >= 0 & (this.accountBalance - moneyDebitedEvent.debitAmount) < 0) {
			AggregateLifecycle.apply(new SuspendCard(this.id, CardStatus.HOLD));
		}

		this.accountBalance -= moneyDebitedEvent.debitAmount;

	}

	@EventSourcingHandler
	protected void on(SuspendCard accountHeldEvent) {
		this.status = String.valueOf(accountHeldEvent.status);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
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
}
