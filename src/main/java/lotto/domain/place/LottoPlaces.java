package lotto.domain.place;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoPlaces {
  private final List<LottoPlace> lottoPlaces;

  private LottoPlaces(List<LottoPlace> lottoPlaces) {
    this.lottoPlaces = Collections.unmodifiableList(lottoPlaces);
  }

  public static LottoPlaces create() {
    List<LottoPlace> list = Arrays.asList(
              LottoFirstPlace.create()
            , LottoSecondPlace.create()
            , LottoThirdPlace.create()
            , LottoFourthPlace.create());
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

  public List<LottoPlace> getLottoPlaces() {
    return lottoPlaces;
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
