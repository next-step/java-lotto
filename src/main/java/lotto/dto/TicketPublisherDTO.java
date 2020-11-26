package lotto.dto;

import java.util.Map;

public class TicketPublisherDTO {

  public final Map<Integer, Integer> publishingHistory;

  public TicketPublisherDTO(Map<Integer, Integer> publishingHistory) {
    this.publishingHistory = publishingHistory;
  }

  public Map<Integer, Integer> getPublishingHistory() {
    return publishingHistory;
  }
}
