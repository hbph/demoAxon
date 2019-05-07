package net.devworkshop.axon.config;

import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.devworkshop.axon.aggregates.AccountAggregate;

@Configuration
public class AxonConfig {

	@Bean
	EventSourcingRepository<AccountAggregate> accountAggregateEventSourcingRepository(EventStore eventStore) {
		EventSourcingRepository<AccountAggregate> repository = EventSourcingRepository.builder(AccountAggregate.class)
				.eventStore(eventStore).build();
		return repository;
	}
}
