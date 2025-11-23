package lotto.domain.lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

  public static LottoTicket of(List<LottoNumber> numbers) {
    return new LottoTicket(numbers);
  }

  public static LottoTicket of(Integer... numbers) {
    return new LottoTicket(convert(List.of(numbers)));
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

  public int countMatchingNumbers(LottoTicket winningNumbers) {
    Set<LottoNumber> winnings = new HashSet<>(winningNumbers.numbers);
    return (int) numbers.stream()
        .filter(winnings::contains)
        .count();
  }

  @Override
  public String toString() {
    return numbers.toString();
  }

  protected boolean contains(LottoNumber bonus) {
    for (LottoNumber number : this.numbers) {
      if (number == bonus) {
        return true;
      }
    }
    return false;
  }
}