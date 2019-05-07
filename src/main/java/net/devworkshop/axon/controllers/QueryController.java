package net.devworkshop.axon.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import net.devworkshop.axon.entities.CardQueryEntity;
import net.devworkshop.axon.services.queries.QueryService;

@RestController
@RequestMapping(value = "/moneycard")
@Api(value = "Cash card queries", tags = "Cash card queries")
public class QueryController {

    private final QueryService queryService;

    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/{cardNumber}")
    public CardQueryEntity getCashBalance(@PathVariable(value = "cardNumber") String cardNumber){
        return queryService.getMoneyCardDetails(cardNumber);
    }

    @GetMapping("/{cardNumber}/events")
    public List<Object> listEventsForMoneyCard(@PathVariable(value = "cardNumber") String cardNumber){
        return queryService.listEventsForCashCard(cardNumber);
    }

}
