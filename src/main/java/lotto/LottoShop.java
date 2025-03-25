package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {

  private final LottoGenerator lottoGenerator;

  public LottoShop(LottoGenerator lottoGenerator) {
    this.lottoGenerator = lottoGenerator;
  }

  public Lottos buyLottos(int money) {
    validateMoney(money);
    int lottoTicketCount = calculateLottoTicketCount(money);
    return generateLottos(lottoTicketCount);
  }

  private void validateMoney(int money) {
    if (money < 0) {
      throw new IllegalArgumentException("0 미만의 금액으로 로또를 구매할 수 없습니다.");
    }
    if (money < Lotto.PRICE) {
      throw new IllegalArgumentException("로또 한 장의 가격보다 적은 금액으로 로또를 구매할 수 없습니다.");
    }
  }

  private Lottos generateLottos(int lottoTicketCount) {
    return new Lottos(
            IntStream.range(0, lottoTicketCount)
                    .mapToObj(i -> lottoGenerator.generate())
                    .collect(Collectors.toList())
    );
  }

  private static int calculateLottoTicketCount(int money) {
    return money / Lotto.PRICE;
  }
}
