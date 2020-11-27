package lotto.dto;

import java.util.Map;
import lotto.TicketPublishType;

public class TicketPublisherDTO {

  public final Map<TicketPublishType, Integer> publishingHistory;

  public TicketPublisherDTO(Map<TicketPublishType, Integer> publishingHistory) {
    this.publishingHistory = publishingHistory;
  }

  public Map<TicketPublishType, Integer> getPublishingHistory() {
    return publishingHistory;
  }
}
