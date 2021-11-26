package lotto.domain.entity;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class LottoTicket {

  private static final String INVALID_SIZE_OF_NUMBER = "6개의 숫자 구성이 아닙니다.";
  private static final String DUPLICATED_NUMBER = "중복된 숫자가 있습니다.";
  private static final int LOTTO_SIZE = 6;
  private static final String LEFT_SQUARE_BRACKET = "[";
  private static final String RIGHT_SQUARE_BRACKET = "[";
  private static final String COMMA = ",";

  private final List<LottoNumber> numbers;

  public LottoTicket(List<LottoNumber> numbers) {
    validSize(numbers);
    validDuplicate(numbers);
    this.numbers = numbers;
  }

  private void validSize(List<LottoNumber> numbers) {
    if (numbers.size() > LOTTO_SIZE || numbers.size() < LOTTO_SIZE) {
      throw new IllegalArgumentException(INVALID_SIZE_OF_NUMBER);
    }
  }

  private void validDuplicate(List<LottoNumber> numbers) {
    long size = numbers.stream()
                       .distinct()
                       .count();
    if (size < LOTTO_SIZE) {
      throw new IllegalArgumentException(DUPLICATED_NUMBER);
    }

  }

  private boolean contains(int number) {
    return numbers.contains(new LottoNumber(number));
  }

  public int getMatchedCount(LottoTicket lotto) {
    return (int) this.numbers.stream()
            .filter(number -> lotto.contains(number.getNumber()))
            .count();
  }

  public int size() {
    return numbers.size();
  }

  public List<LottoNumber> getNumbers() {
    return numbers;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LEFT_SQUARE_BRACKET)
                 .append(getListToString())
                 .append(RIGHT_SQUARE_BRACKET);
    return stringBuilder.toString();
  }

  private String getListToString() {
    return numbers.stream()
                  .map(lottoNumber -> String.valueOf(lottoNumber.getNumber()))
                  .collect(joining(COMMA));
  }
}
