package com.tpam.service.template.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tpam.service.template.messaging.model.TestMessage;
import com.tpam.service.template.messaging.source.TradeSource;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.test.context.junit4.SpringRunner;

@SuppressWarnings("ALL")
@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeEventPublisherTest {

    @Autowired
    private TradeEventPublisher eventPublisher;

    @Autowired
    private TradeSource tradeSource;

    @Autowired
    private MessageCollector messageCollector;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testWiring() throws JsonProcessingException {
        final TestMessage testMessage = new TestMessage("field1", "field2");
        final String jsonMessage = objectMapper.writeValueAsString(testMessage);
        eventPublisher.sendTradeUpdate(testMessage);
        Message<String> received = (Message<String>) messageCollector.forChannel(tradeSource.tradeUpdatedOutput()).poll();
        Assertions.assertThat(received.getPayload()).isEqualTo(jsonMessage);
    }
}