package lotto.domain;

import lotto.domain.place.LottoPlaces;
import lotto.function.GenerateNumbers;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
  private static final String ERROR_BOUGHT_LIMIT_FOR_LOTTO_OVER_FORMAT = "구입 금액에 맞는 구매할 로또 총 수는 %d 입니다.";
  private static final int LOTTO_PRICE = 1_000;

  private final List<LottoNumbers> values;
  private final List<LottoNumbers> valuesOfManual;

  private LottoTicket(List<LottoNumbers> autoValues, List<LottoNumbers> valuesOfManual) {
    this.values = Collections.unmodifiableList(autoValues);
    this.valuesOfManual = Collections.unmodifiableList(valuesOfManual);
  }

  public static LottoTicket toBuy(final int money,
                                  final GenerateNumbers generateNumbers,
                                  final List<String> manualLottoStrings) {
    int countOfManualLotto = manualLottoStrings.size();
    checkBoughtManualLottoExceedMoney(money, countOfManualLotto);

    int availableMoney = money - ( countOfManualLotto * LOTTO_PRICE );
    int countOfMakeAutoLottoNumbers = countOfTotalLottoNumbers(availableMoney);
    
    List<LottoNumbers> lottoNumbers = IntStream.range(0, countOfMakeAutoLottoNumbers)
            .mapToObj(i -> LottoNumbers.generateSixNumbers(generateNumbers))
            .collect(Collectors.toList());
    
    return new LottoTicket(lottoNumbers, manualLottoStrings.stream()
            .map(LottoNumbers::generateSixNumbersFromStringNumbers)
            .collect(Collectors.toList()));
  }

  private static void checkBoughtManualLottoExceedMoney(int money, int countOfManualLotto) {
    if (countOfTotalLottoNumbers(money) - countOfManualLotto < 0) {
      throw new IllegalArgumentException(String.format(ERROR_BOUGHT_LIMIT_FOR_LOTTO_OVER_FORMAT, countOfTotalLottoNumbers(money)));
    }
  }

  private static int countOfTotalLottoNumbers(int money) {
    return money / LOTTO_PRICE;
  }

  public LottoPlaces getMatchedLottoPlaces(LottoWiningNumbers lottoWiningNumbers,
                                           LottoBonusBall lottoBonusBall) {
    LottoPlaces lottoPlaces = LottoPlaces.create();
    for (LottoNumbers lottoNumbers : values) {
      int countOfMatch = lottoWiningNumbers.countOfMatch(lottoNumbers);
      boolean matchBonus = lottoBonusBall.isMatch(lottoNumbers);
      lottoPlaces = lottoPlaces.record(countOfMatch, matchBonus);
    }
    return lottoPlaces;
  }

  public int totalSpentMoney() {
    return LOTTO_PRICE * ticketCount();
  }

  public List<LottoNumbers> getValues() {
    return values;
  }

  public int ticketCount() {
    return values.size();
  }

  public int ticketManualCount() {
    return valuesOfManual.size();
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
