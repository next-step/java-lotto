package lotto.domain.place;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Places {
  private final List<Place> values;

  private Places(List<Place> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static Places create() {
    List<Place> list = Arrays.asList(
            FifthPlace.create(),
            FourthPlace.create(),
            ThirdPlace.create(),
            SecondPlace.create(),
            FirstPlace.create()
    );
    return new Places(list);
  }

  public Places record(int countOfMatch, boolean matchBonus) {
    List<Place> result = new ArrayList<>();
    for (Place lottoPlace : values) {
      if (lottoPlace.isMatch(countOfMatch, matchBonus)) {
        lottoPlace = lottoPlace.win();
      }
      result.add(lottoPlace);
    }
    return new Places(result);
  }

  public List<Place> getValues() {
    return values;
  }

  public long totalWinningMoney() {
    return values.stream()
            .map(Place::getTotalWinningMoney)
            .reduce(Long::sum)
            .orElse(0L);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Places that = (Places) o;
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
