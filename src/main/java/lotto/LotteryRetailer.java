package lotto;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

public class LotteryRetailer {

  public static final int PRICE_PER_PLAY_FOR_LOTTO = 1000;
  public static final String PRICE_EXCEPTION_MESSAGE = "로또 1장의 가격은 1000원 입니다";

  public List<LottoTicket> sell(Integer receivedMoney, LottoNumberGenerator lottoNumberGenerator) {
    checkGreaterThanMinimumPrice(receivedMoney);

    return IntStream.range(0, getLottoCount(receivedMoney))
        .mapToObj(i -> createLottoTicket(lottoNumberGenerator))
        .collect(toList());
  }

  private int getLottoCount(Integer receivedMoney) {
    return receivedMoney / PRICE_PER_PLAY_FOR_LOTTO;
  }

  private void checkGreaterThanMinimumPrice(Integer receivedMoney) {
    if (receivedMoney < PRICE_PER_PLAY_FOR_LOTTO) {
      throw new IllegalArgumentException(PRICE_EXCEPTION_MESSAGE);
    }
  }

  private LottoTicket createLottoTicket(LottoNumberGenerator lottoNumberGenerator) {
    return new LottoTicket(createLottoNumbers(lottoNumberGenerator));
  }

  private List<Integer> createLottoNumbers(LottoNumberGenerator lottoNumberGenerator) {
    return lottoNumberGenerator.generate();
  }

  public long exchange(LottoTicket lottoTicket, LottoTicket winLottoTicket) {
    if (winLottoTicket == null) {
      throw new IllegalArgumentException("지난 주 당첨 번호를 입력해 주세요.");
    }
    int count = lottoTicket.countMatched(winLottoTicket);
    return Prizes.of(count);
  }
}
