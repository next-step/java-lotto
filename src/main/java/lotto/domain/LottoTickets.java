package lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {

  private final List<LottoTicket> randomTickets;
  private final List<LottoTicket> manualTickets;
  private final List<LottoTicket> lottoTickets;

  public static LottoTickets of(List<LottoTicket> manualTickets, List<LottoTicket> randomTickets) {
    return new LottoTickets(manualTickets, randomTickets);
  }

  public LottoTickets(List<LottoTicket> lottoTickets) {
    this(lottoTickets, Collections.emptyList());
  }

  public LottoTickets(List<LottoTicket> randomTickets, List<LottoTicket> manualTickets) {
    validate(manualTickets, randomTickets);
    this.manualTickets = manualTickets;
    this.randomTickets = randomTickets;
    lottoTickets = Stream.of(manualTickets, randomTickets)
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
  }

  private static void validate(List<LottoTicket> manualTickets, List<LottoTicket> randomTickets) {
    if (randomTickets == null || randomTickets.isEmpty()) {
      throw new IllegalArgumentException("로또 그룹은 빈 값일 수 없습니다.");
    }
    if (manualTickets == null) {
      throw new IllegalArgumentException("로또 그룹은 null 일 수 없습니다.");
    }
  }

  public int randomLottoCount() {
    return randomTickets.size();
  }

  public int manualLottoCount() {
    return manualTickets.size();
  }

  public List<LottoTicket> tickets() {
    return Collections.unmodifiableList(lottoTickets);
  }

  public int totalTicketCount() {
    return lottoTickets.size();
  }

  public int getMatchedCountPerPrize(Prize prize, WinningLottoTicket winningLottoTicket) {
    return (int) lottoTickets.stream()
        .map(lottoTicket -> Prize.of(lottoTicket.countMatched(winningLottoTicket),
            winningLottoTicket.matchBonusBall(lottoTicket)))
        .filter(prize::equals)
        .count();
  }
}
