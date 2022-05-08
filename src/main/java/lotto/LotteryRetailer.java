package lotto;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

public class LotteryRetailer {

  public static final int PRICE_PER_PLAY_FOR_LOTTO = 1000;
  public static final String PRICE_EXCEPTION_MESSAGE = "로또 1장의 가격은 1000원 입니다";

  public List<LottoTicket> sell(Integer receivedMoney, LottoNumberGenerator lottoNumberGenerator) {
    if (receivedMoney < PRICE_PER_PLAY_FOR_LOTTO) {
      throw new IllegalArgumentException(PRICE_EXCEPTION_MESSAGE);
    }

    int lottoCount = receivedMoney / PRICE_PER_PLAY_FOR_LOTTO;
    return IntStream.range(0, lottoCount)
        .mapToObj(i -> createLottoTicket(lottoNumberGenerator))
        .collect(toList());
  }

  private LottoTicket createLottoTicket(LottoNumberGenerator lottoNumberGenerator) {
    return new LottoTicket(createLottoNumbers(lottoNumberGenerator));
  }

  private List<Integer> createLottoNumbers(LottoNumberGenerator lottoNumberGenerator) {
    return lottoNumberGenerator.generate();
  }
}
