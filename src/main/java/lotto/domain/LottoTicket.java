package lotto.domain;

import lotto.domain.place.Places;
import lotto.function.GenerateNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
  private static final String ERROR_LIMIT_BOUGHT_LOTTO_OVER_FORMAT = "구입 금액에 맞는 구매할 로또 총 수는 %d 입니다.";
  private static final int PRICE = 1_000;

  private final List<Lottery> values;

  private LottoTicket(List<Lottery> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static LottoTicket toBuy(final int myMoney,
                                  final GenerateNumbers generateNumbers,
                                  final List<String> manualLottoStrings) {
    final int countOfManualLotto = manualLottoStrings.size();

    List<Lottery> values = new ArrayList<>(countOfTotalLottery(myMoney));
    values.addAll(getManualLotteries(myMoney, manualLottoStrings, countOfManualLotto));
    values.addAll(getAutoLotteries(myMoney, generateNumbers, countOfManualLotto));
    return new LottoTicket(values);
  }

  private static List<Lottery> getAutoLotteries(int myMoney, GenerateNumbers generateNumbers, int countOfManualLotto) {
    final int availableMoney = myMoney - ( countOfManualLotto * PRICE );
    final int countOfAutoLottery = countOfTotalLottery(availableMoney);
    checkExceedMaximumBuyToLottery(availableMoney, countOfAutoLottery);
    return IntStream.range(0, countOfAutoLottery)
            .mapToObj(i -> Lottery.generateSixNumbers(generateNumbers))
            .collect(Collectors.toList());
  }

  private static List<Lottery> getManualLotteries(int myMoney, List<String> manualLottoStrings, int countOfManualLottery) {
    checkExceedMaximumBuyToLottery(myMoney, countOfManualLottery);
    return manualLottoStrings.stream()
            .map(Lottery::generateSixNumbersFromStringNumbers)
            .collect(Collectors.toList());
  }

  private static void checkExceedMaximumBuyToLottery(int myMoney, int countOfBoughtLottery) {
    if (countOfTotalLottery(myMoney) - countOfBoughtLottery < 0) {
      throw new IllegalArgumentException(String.format(ERROR_LIMIT_BOUGHT_LOTTO_OVER_FORMAT, countOfTotalLottery(myMoney)));
    }
  }

  private static int countOfTotalLottery(int money) {
    return money / PRICE;
  }

  public Places getMatchedPlaces(WiningLottery winingLottery,
                                 BonusBall bonusBall) {
    Places places = Places.create();
    for (Lottery lottery : values) {
      int countOfMatch = winingLottery.countOfMatch(lottery);
      boolean matchBonus = bonusBall.isMatch(lottery);
      places = places.record(countOfMatch, matchBonus);
    }
    return places;
  }

  public int totalSpentMoney() {
    return PRICE * ticketCount();
  }

  public List<Lottery> getValues() {
    return values;
  }

  public int ticketCount() {
    return values.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoTicket that = (LottoTicket) o;
    return Objects.equals(values, that.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    return "LottoTicket=" + values;
  }
}
