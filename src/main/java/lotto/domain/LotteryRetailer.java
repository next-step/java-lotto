package lotto.domain;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

public class LotteryRetailer {

  public static final Money PRICE_PER_PLAY_FOR_LOTTO = Money.of(1000);
  public static final String PRICE_EXCEPTION_MESSAGE = "로또 1장의 가격은 1000원 입니다";

  public LottoTickets sell(Money purchaseAmount, LottoNumberGenerator lottoNumberGenerator) {
    checkGreaterThanMinimumPrice(purchaseAmount);

    List<LottoTicket> lottoTickets = IntStream.range(0,
            getAvailableLottoTicketCount(purchaseAmount))
        .mapToObj(i -> createLottoTicket(lottoNumberGenerator))
        .collect(toList());
    return new LottoTickets(lottoTickets);
  }

  private int getAvailableLottoTicketCount(Money receivedMoney) {
    return receivedMoney.divide(PRICE_PER_PLAY_FOR_LOTTO).value();
  }

  private void checkGreaterThanMinimumPrice(Money purchaseMoney) {
    if (purchaseMoney.lessThan(PRICE_PER_PLAY_FOR_LOTTO)) {
      throw new IllegalArgumentException(PRICE_EXCEPTION_MESSAGE);
    }
  }

  private LottoTicket createLottoTicket(LottoNumberGenerator lottoNumberGenerator) {
    return new LottoTicket(createLottoNumbers(lottoNumberGenerator));
  }

  private List<Integer> createLottoNumbers(LottoNumberGenerator lottoNumberGenerator) {
    return lottoNumberGenerator.generate();
  }
}
