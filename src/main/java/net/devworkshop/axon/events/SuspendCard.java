package net.devworkshop.axon.events;

import net.devworkshop.axon.aggregates.CardStatus;

public class SuspendCard extends BaseEvent<String> {

	public final CardStatus status;

	public SuspendCard(String id, CardStatus status) {
		super(id);
		this.status = status;
	}
}
