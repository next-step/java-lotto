package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
  private final List<LottoNumber> numbers;

  public static final int SIZE = 6;
  public static final int PRICE = 1000;

  public Lotto(List<LottoNumber> numbers) {
    if (numbers.size() != SIZE) {
      throw new IllegalArgumentException("로또 번호는 " + SIZE + "개여야 합니다.");
    }

    this.numbers = numbers.stream()
        .sorted((n1, n2) -> Integer.compare(n1.getNumber(), n2.getNumber()))
        .collect(Collectors.toList());
  }

  public static Lotto of(String input) {
    List<LottoNumber> numbers = Arrays.stream(input.split(","))
        .map(String::trim)
        .map(Integer::parseInt)
        .map(LottoNumber::new)
        .collect(Collectors.toList());
    return new Lotto(numbers);
  }

  public static Lotto generateRandomLotto(RandomLottoGenerator lottoGenerator) {
    return lottoGenerator.generate();
  }

  public int size() {
    return numbers.size();
  }

  public List<LottoNumber> getNumbers() {
    return numbers;
  }

  public String getFormattedNumbers() {
    return numbers.stream()
        .map(LottoNumber::getNumber)
        .map(String::valueOf)
        .collect(Collectors.joining(", "));
  }
}
