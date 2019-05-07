package net.devworkshop.axon.services.queries;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import net.devworkshop.axon.entities.CardQueryEntity;
import net.devworkshop.axon.entities.repositories.CardRepository;

@Service
public class QueryServiceImpl implements QueryService {

	private final EventStore eventStore;

	private final CardRepository accountRepository;

	public QueryServiceImpl(EventStore eventStore, CardRepository accountRepository) {
		this.eventStore = eventStore;
		this.accountRepository = accountRepository;
	}

	@Override
	public List<Object> listEventsForCashCard(String accountNumber) {
		return eventStore.readEvents(accountNumber).asStream().map(s -> s.getPayload()).collect(Collectors.toList());
	}

	@Override
	public CardQueryEntity getMoneyCardDetails(String accountNumber) {
		return accountRepository.findById(accountNumber).get();
	}

}
