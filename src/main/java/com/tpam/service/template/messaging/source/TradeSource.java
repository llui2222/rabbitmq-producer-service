package com.tpam.service.template.messaging.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TradeSource
{
  String TRADE_UPDATED_OUTPUT = "tradeUpdatedOutput";
  String TRADE_CREATED_OUTPUT = "tradeCreatedOutput";


  @Output(TradeSource.TRADE_UPDATED_OUTPUT)
  MessageChannel tradeUpdatedOutput();

  @Output(TradeSource.TRADE_CREATED_OUTPUT)
  MessageChannel tradeCreatedOutput();

}
