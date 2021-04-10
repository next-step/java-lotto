package lotto.domain.place;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static lotto.constants.BaseConstants.LOTTO_FIRST_PLACE_INDEX;

public class LottoPlaces {
  private final List<LottoPlace> values;

  private LottoPlaces(List<LottoPlace> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static LottoPlaces create() {
    List<LottoPlace> list = Arrays.asList(
              LottoFourthPlace.create()
            , LottoThirdPlace.create()
            , LottoSecondPlace.create()
            , LottoFirstPlace.create()
    );
    return new LottoPlaces(list);
  }

  public LottoPlaces record(int matchedLottoNumberCount) {
    List<LottoPlace> result = new ArrayList<>();
    for (LottoPlace lottoPlace : values) {
      if (lottoPlace.matchedLottoNumberCount(matchedLottoNumberCount)) {
        lottoPlace = lottoPlace.win();
      }
      result.add(lottoPlace);
    }
    return new LottoPlaces(result);
  }

  public LottoPlace firstPlace() {
    return values.get(LOTTO_FIRST_PLACE_INDEX);
  }

  public List<LottoPlace> getValues() {
    return values;
  }

  public long totalWinMoney() {
    return values.stream()
            .map(LottoPlace::getTotalMoney)
            .reduce(Long::sum)
            .orElse(0L);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoPlaces that = (LottoPlaces) o;
    return Objects.equals(values, that.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    return "LottoPlaces{" +
            "lottoPlaces=" + values +
            '}';
  }
}
