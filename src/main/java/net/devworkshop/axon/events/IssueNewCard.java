package net.devworkshop.axon.events;

public class IssueNewCard extends BaseEvent<String> {

    public final double accountBalance;

    public final String currency;

    public IssueNewCard(String id, double accountBalance, String currency) {
        super(id);
        this.accountBalance = accountBalance;
        this.currency = currency;
    }


}
