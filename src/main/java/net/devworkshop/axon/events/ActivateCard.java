package net.devworkshop.axon.events;

import net.devworkshop.axon.aggregates.CardStatus;

public class ActivateCard extends BaseEvent<String> {

	public final CardStatus status;

	public ActivateCard(String id, CardStatus status) {
		super(id);
		this.status = status;
	}
}
