package lotto.domain.place;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static lotto.constants.BaseConstants.LOTTO_FIRST_PLACE_INDEX;
import static lotto.constants.BaseConstants.LOTTO_FOURTH_PLACE_INDEX;
import static lotto.constants.BaseConstants.LOTTO_SECOND_PLACE_INDEX;
import static lotto.constants.BaseConstants.LOTTO_THIRD_PLACE_INDEX;

public class LottoPlaces {
  private final List<LottoPlace> lottoPlaces;

  private LottoPlaces(List<LottoPlace> lottoPlaces) {
    this.lottoPlaces = Collections.unmodifiableList(lottoPlaces);
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
    for (LottoPlace lottoPlace : lottoPlaces) {
      if (lottoPlace.matchedLottoNumberCount(matchedLottoNumberCount)) {
        lottoPlace = lottoPlace.win();
      }
      result.add(lottoPlace);
    }
    return new LottoPlaces(result);
  }

  public LottoPlace firstPlace() {
    return lottoPlaces.get(LOTTO_FIRST_PLACE_INDEX);
  }

  public LottoPlace secondPlace() {
    return lottoPlaces.get(LOTTO_SECOND_PLACE_INDEX);
  }

  public LottoPlace thirdPlace() {
    return lottoPlaces.get(LOTTO_THIRD_PLACE_INDEX);
  }

  public LottoPlace fourthPlace() {
    return lottoPlaces.get(LOTTO_FOURTH_PLACE_INDEX);
  }

  public List<LottoPlace> getLottoPlaces() {
    return lottoPlaces;
  }

  public long totalWinMoney() {
    return lottoPlaces.stream()
            .map(LottoPlace::getTotalMoney)
            .reduce(Long::sum)
            .orElse(0L);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoPlaces that = (LottoPlaces) o;
    return Objects.equals(lottoPlaces, that.lottoPlaces);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoPlaces);
  }

  @Override
  public String toString() {
    return "LottoPlaces{" +
            "lottoPlaces=" + lottoPlaces +
            '}';
  }
}
