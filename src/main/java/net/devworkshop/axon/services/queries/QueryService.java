package net.devworkshop.axon.services.queries;

import java.util.List;

import net.devworkshop.axon.entities.CardQueryEntity;

public interface QueryService {
	public List<Object> listEventsForCashCard(String cardNumber);

	public CardQueryEntity getMoneyCardDetails(String cardNumber);
}
