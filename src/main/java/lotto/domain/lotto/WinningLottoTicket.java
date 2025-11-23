package lotto.domain.lotto;

import java.util.Arrays;
import java.util.List;
import lotto.domain.game.Rank;

public class WinningLottoTicket {

  private final List<LottoNumber> numbers;

  public WinningLottoTicket(String numbers) {
    this.numbers = parse(numbers);
  }

  private List<LottoNumber> parse(String numbers) {
    return Arrays.stream(numbers.split(", "))
        .map(Integer::parseInt)
        .map(LottoNumber::of).toList();
  }

  public Rank compare(LottoTicket ticket) {
    return Rank.valueOf(ticket.countMatchingNumbers(numbers));
  }

}