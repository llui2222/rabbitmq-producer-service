package com.tpam.service.template.controller;

import com.tpam.service.template.messaging.model.TestMessage;
import com.tpam.service.template.messaging.TradeEventPublisher;
import com.tpam.service.template.model.TestEntity;
import com.tpam.service.template.repository.TestEntityRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class RabbitMQPublishController {
    private final TradeEventPublisher tradeEventPublisher;
    private final TestEntityRepository repository;

    public RabbitMQPublishController(final TradeEventPublisher tradeEventPublisher, final TestEntityRepository repository) {
        this.tradeEventPublisher = tradeEventPublisher;
        this.repository = repository;
    }

    @Transactional
    @PostMapping("publish-update")
    public void publishUpdate() {
        final TestMessage testMessage = new TestMessage("1", "2");
        final TestEntity testEntity = new TestEntity();
        testEntity.setField("field1");
        tradeEventPublisher.sendTradeUpdate(testMessage);
        repository.save(testEntity);
    }

    @Transactional
    @PostMapping("publish-create")
    public void publishCreate() {
        final TestMessage testMessage = new TestMessage("1", "2");
        final TestEntity testEntity = new TestEntity();
        testEntity.setField("field1");
        tradeEventPublisher.sendTradeCreated(testMessage);
        repository.save(testEntity);
    }

    @Transactional
    @PutMapping("update")
    public void update(final @RequestBody TestEntity testEntity) {

        final TestMessage testMessage = new TestMessage("1", "2");
        tradeEventPublisher.sendTradeUpdate(testMessage);
        repository.save(testEntity);
    }

    @Transactional
    @PostMapping("publish-error")
    public void publishWithError() {
        final TestMessage testMessage = new TestMessage("1", "2");
        final TestEntity testEntity = new TestEntity();
        testEntity.setField("field1");
        tradeEventPublisher.sendTradeUpdate(testMessage);
        repository.save(testEntity);
        throw new RuntimeException("Error");
    }
}
