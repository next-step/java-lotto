package lotto.domain;

import static lotto.config.LottoGameConfig.NUMBER_COUNT_PER_GAME;
import static lotto.constants.Message.NUMBER_COUNT_SHOULD_N;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.model.LottoNumber;
import lotto.exception.LottoGameException;

public class Lotto {
  private final Set<LottoNumber> lottoNumbers;

  private static final String OPEN_PARENTHESIS = "[";
  private static final String CLOSE_PARENTHESIS = "]";
  private static final String DELIMITER = ", ";

  public Lotto(List<LottoNumber> lottoNumberPool) {
    this.lottoNumbers = lottoNumberPool.stream()
        .limit(NUMBER_COUNT_PER_GAME)
        .collect(Collectors.toSet());
  }

  public Lotto(String[] numbers) {
    this.lottoNumbers = createLottoNumbers(numbers);
  }

  public Set<LottoNumber> getLottoNumbers() {
    return lottoNumbers;
  }

  private Set<LottoNumber> createLottoNumbers(String[] numbers) {

    Set<LottoNumber> lottoNumbers = Arrays.stream(numbers)
        .map(LottoNumber::new)
        .collect(Collectors.toSet());

    if (!isValidNumberCount(lottoNumbers)) {
      throw new LottoGameException(String.format(NUMBER_COUNT_SHOULD_N, NUMBER_COUNT_PER_GAME));
    }
    return lottoNumbers;
  }

  private boolean isValidNumberCount(Set<LottoNumber> lottoNumbers) {
    return lottoNumbers.size() == NUMBER_COUNT_PER_GAME;
  }

  protected boolean contains(LottoNumber lottoNumber) {
    return this.lottoNumbers.contains(lottoNumber);
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    String collect = lottoNumbers.stream()
        .sorted()
        .map(LottoNumber::toString)
        .collect(Collectors.joining(DELIMITER));

    stringBuilder.append(OPEN_PARENTHESIS)
        .append(collect)
        .append(CLOSE_PARENTHESIS);

    return stringBuilder.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Lotto lotto = (Lotto) o;
    return lottoNumbers.equals(lotto.lottoNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumbers);
  }
}
