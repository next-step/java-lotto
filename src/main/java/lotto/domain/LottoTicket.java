package lotto.domain;

import lotto.domain.place.LottoPlaces;
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

  private final List<LottoNumbers> values;

  private LottoTicket(List<LottoNumbers> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static LottoTicket toBuy(final int myMoney,
                                  final GenerateNumbers generateNumbers,
                                  final List<String> manualLottoStrings) {
    final int countOfManualLotto = manualLottoStrings.size();

    List<LottoNumbers> values = new ArrayList<>(countOfTotalLottery(myMoney));
    values.addAll(getManualLottoNumbers(myMoney, manualLottoStrings, countOfManualLotto));
    values.addAll(getAutoLottoNumbers(myMoney, generateNumbers, countOfManualLotto));
    return new LottoTicket(values);
  }

  private static List<LottoNumbers> getAutoLottoNumbers(int myMoney, GenerateNumbers generateNumbers, int countOfManualLotto) {
    final int availableMoney = myMoney - ( countOfManualLotto * PRICE );
    final int countOfAutoLotto = countOfTotalLottery(availableMoney);
    checkExceedMaximumBuyToLotto(availableMoney, countOfAutoLotto);
    return IntStream.range(0, countOfAutoLotto)
            .mapToObj(i -> LottoNumbers.generateSixNumbers(generateNumbers))
            .collect(Collectors.toList());
  }

  private static List<LottoNumbers> getManualLottoNumbers(int myMoney, List<String> manualLottoStrings, int countOfManualLotto) {
    checkExceedMaximumBuyToLotto(myMoney, countOfManualLotto);
    return manualLottoStrings.stream()
            .map(LottoNumbers::generateSixNumbersFromStringNumbers)
            .collect(Collectors.toList());
  }

  private static void checkExceedMaximumBuyToLotto(int myMoney, int countOfBoughtLotto) {
    if (countOfTotalLottery(myMoney) - countOfBoughtLotto < 0) {
      throw new IllegalArgumentException(String.format(ERROR_LIMIT_BOUGHT_LOTTO_OVER_FORMAT, countOfTotalLottery(myMoney)));
    }
  }

  private static int countOfTotalLottery(int money) {
    return money / PRICE;
  }

  public LottoPlaces getMatchedLottoPlaces(LottoWiningNumbers lottoWiningNumbers,
                                           LottoBonusBall lottoBonusBall) {
    LottoPlaces lottoPlaces = LottoPlaces.create();
    for (LottoNumbers lottoNumbers : values) {
      int countOfMatch = lottoWiningNumbers.countOfMatch(lottoNumbers);
      boolean matchBonus = lottoBonusBall.isMatch(lottoNumbers);
      System.out.println(countOfMatch);
      lottoPlaces = lottoPlaces.record(countOfMatch, matchBonus);
    }
    return lottoPlaces;
  }

  public int totalSpentMoney() {
    return PRICE * ticketCount();
  }

  public List<LottoNumbers> getValues() {
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
