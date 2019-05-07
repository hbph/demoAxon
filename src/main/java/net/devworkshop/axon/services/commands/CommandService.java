package net.devworkshop.axon.services.commands;

import java.util.concurrent.CompletableFuture;

import net.devworkshop.axon.model.AddCash;
import net.devworkshop.axon.model.DeductCash;
import net.devworkshop.axon.model.IssueNewCard;

public interface CommandService {
	public CompletableFuture<String> createAccount(IssueNewCard accountCreateDTO);

	public CompletableFuture<String> creditMoneyToAccount(String accountNumber, AddCash moneyCreditDTO);

	public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, DeductCash moneyDebitDTO);
}
