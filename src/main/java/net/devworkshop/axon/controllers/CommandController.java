package net.devworkshop.axon.controllers;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import net.devworkshop.axon.model.AddCash;
import net.devworkshop.axon.model.DeductCash;
import net.devworkshop.axon.model.IssueNewCard;
import net.devworkshop.axon.services.commands.CommandService;

@RestController
@RequestMapping(value = "/moneycard")
@Api(value = "Cash card commands",tags = "Cash card command")
/**
 * 
 * @author bthiru005c
 *
 */
public class CommandController {

	private final CommandService commandService;

	public CommandController(CommandService commandService) {
		this.commandService = commandService;
	}

	@PostMapping
	public CompletableFuture<String> issueNewCard(@RequestBody IssueNewCard issueNewCard) {
		return commandService.createAccount(issueNewCard);
	}

	@PutMapping(value = "/addCash/{cardNumber}")
	public CompletableFuture<String> addCash(@PathVariable(value = "cardNumber") String cardNumber,
			@RequestBody AddCash moneyCreditDTO) {
		return commandService.creditMoneyToAccount(cardNumber, moneyCreditDTO);
	}

	@PutMapping(value = "/withDraw/{cardNumber}")
	public CompletableFuture<String> withDrawCash(@PathVariable(value = "cardNumber") String cardNumber,
			@RequestBody DeductCash moneyDebitDTO) {
		return commandService.debitMoneyFromAccount(cardNumber, moneyDebitDTO);
	}
}
