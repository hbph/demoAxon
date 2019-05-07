package net.devworkshop.axon.services.commands;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import net.devworkshop.axon.commands.IssueNewCardCommand;
import net.devworkshop.axon.model.AddCash;
import net.devworkshop.axon.model.DeductCash;
import net.devworkshop.axon.model.IssueNewCard;
import net.devworkshop.axon.commands.AddCashCommand;
import net.devworkshop.axon.commands.DeductCashCommand;

@Service
public class CommandServiceImpl implements CommandService {

	private final CommandGateway commandGateway;

	public CommandServiceImpl(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}

	@Override
	public CompletableFuture<String> createAccount(IssueNewCard accountCreateDTO) {
		return commandGateway.send(new IssueNewCardCommand(UUID.randomUUID().toString(),
				accountCreateDTO.getStartingBalance(), accountCreateDTO.getCurrency()));
	}

	@Override
	public CompletableFuture<String> creditMoneyToAccount(String accountNumber, AddCash moneyCreditDTO) {
		return commandGateway.send(
				new AddCashCommand(accountNumber, moneyCreditDTO.getCreditAmount(), moneyCreditDTO.getCurrency()));
	}

	@Override
	public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, DeductCash moneyDebitDTO) {
		return commandGateway.send(
				new DeductCashCommand(accountNumber, moneyDebitDTO.getDebitAmount(), moneyDebitDTO.getCurrency()));
	}
}
