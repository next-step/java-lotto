package lotto.domain.lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

  private static final int LOTTO_CNT = 6;

  private final List<LottoNumber> numbers;

  public LottoTicket(List<LottoNumber> numbers) {
    validate(numbers);
    this.numbers = List.copyOf(numbers);
  }

  public LottoTicket(String numbers) {
    this(convert(parse(numbers)));
  }

  public LottoTicket (Integer... numbers) {
    this(convert(List.of(numbers)));
  }

  private static List<Integer> parse(String numbers) {
    return Arrays.stream(numbers.split(", "))
        .map(Integer::parseInt).toList();
  }


  private static List<LottoNumber> convert(List<Integer> numbers) {
    return numbers.stream()
        .map(LottoNumber::of)
        .collect(Collectors.toList());
  }

  private void validate(List<LottoNumber> numbers) {
    if (numbers.size() != LOTTO_CNT || new HashSet<>(numbers).size() != LOTTO_CNT) {
      throw new IllegalArgumentException("로또 티켓은 중복되지 않은 6개의 숫자로 이루어져있습니다.");
    }
  }

  public int matchCount(LottoTicket ticket) {
    return (int) this.numbers.stream()
        .filter(ticket::contains)
        .count();
  }

  public boolean contains(LottoNumber number) {
    return this.numbers.contains(number);
  }

  @Override
  public String toString() {
    return numbers.toString();
  }

}