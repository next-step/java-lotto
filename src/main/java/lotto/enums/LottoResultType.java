package lotto.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

public enum LottoResultType {

  THREE(3, 5_000), FOUR(4, 50_000), FIVE(5, 1_500_000), BONUS(5, 30_000_000), ALL(6,
      2_000_000_000), NO_MATCH(0, 0);
  private final int number;
  private final double price;

  LottoResultType(int number, double price) {
    this.number = number;
    this.price = price;
  }

  public double calculatePrice(double count) {
    return price * count;
  }

  public static LottoResultType valueOf(int number) {
    return Arrays.stream(values())
        .filter(it -> it.number == number)
        .findFirst()
        .orElseGet(() -> LottoResultType.NO_MATCH);
  }

  public static int findMaxNumber() {
    return Arrays.stream(values()).mapToInt(it -> it.number)
        .max()
        .getAsInt();
  }

  public static int findMinimumNumber() {
    return Arrays.stream(values())
        .filter(it -> !it.equals(LottoResultType.NO_MATCH))
        .mapToInt(it -> it.number)
        .min()
        .getAsInt();
  }

  public List<Lotto> result(List<Lotto> lottos, Lotto resultLotto) {
    return lottos.stream()
        .filter(each -> resultLotto.sameNumberCount(each) == this.number)
        .collect(Collectors.toList());
  }

  public Lottos resultBonusNumber(List<Lotto> lottos, Lotto resultLotto, LottoNumber bonusNumber) {
    List<Lotto> list = lottos.stream()
        .filter(lotto -> resultLotto.sameNumberCount(lotto) == this.number)
        .collect(Collectors.toList());

    if (this == BONUS) {
      list = list.stream()
          .filter(lotto -> lotto.has(bonusNumber))
          .collect(Collectors.toList());
    }

    if (this == FIVE) {
      list = list.stream()
          .filter(lotto -> !lotto.has(bonusNumber))
          .collect(Collectors.toList());
    }

    return Lottos.of(list);
  }

  public String resultMessage(int size) {
    if (this == LottoResultType.BONUS) {
      return String.format("%s개 일치, 보너스 볼 일치(%s원)- %s개", number, (int) price, size);
    }
    return String.format("%s개 일치 (%s원)- %s개", number, (int) price, size);
  }
}
