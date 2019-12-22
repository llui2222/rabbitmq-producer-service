package com.tpam.service.template.messaging;

import com.tpam.service.template.messaging.model.TestMessage;
import com.tpam.service.template.messaging.source.TradeSource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(TradeSource.class)
public class TradeEventPublisher {

    private final TradeSource tradeSource;

    public TradeEventPublisher(final TradeSource tradeSource) {
        this.tradeSource = tradeSource;
    }

    public void sendTradeUpdate(TestMessage message) {
        tradeSource.tradeUpdatedOutput().send(MessageBuilder.withPayload(message).build());
    }

    public void sendTradeCreated(TestMessage message) {
        tradeSource.tradeCreatedOutput().send(MessageBuilder.withPayload(message).build());
    }

}
