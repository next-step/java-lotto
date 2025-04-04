package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketNumberSet {

  private static final int REQUIRED_COUNT = 6; // 항상 6개로 고정

  private final List<LottoTicketNumber> numbers;

  public LottoTicketNumberSet() {
    this(generateRandomLottoNumbers());
  }

  public LottoTicketNumberSet(List<LottoTicketNumber> numbers) {
    validateLottoNumbers(numbers);
    this.numbers = Collections.unmodifiableList(
        numbers.stream()
            .sorted()
            .collect(Collectors.toList())
    );
  }

  private static List<LottoTicketNumber> generateRandomLottoNumbers() {
    List<LottoTicketNumber> allLottoNumbers = new ArrayList<>(
        LottoTicketNumber.generateAllPossibleNumbers()
    );
    Collections.shuffle(allLottoNumbers); // 무작위 섞기
    return allLottoNumbers.subList(0, 6); // 6개 선택
  }

  private void validateLottoNumbers(List<LottoTicketNumber> numbers) {
    if (numbers.size() != REQUIRED_COUNT) {
      throw new IllegalArgumentException("로또 번호는 " + REQUIRED_COUNT + "개여야 합니다.");
    }
    if (numbers.stream().distinct().count() != REQUIRED_COUNT) {
      throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
    }
  }

  @Override
  public String toString() {
    return numbers.toString();
  }

  public List<LottoTicketNumber> getNumbers() {
    return numbers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    LottoTicketNumberSet that = (LottoTicketNumberSet) o;

    for (int i = 0; i < this.numbers.size(); i++) {
      if (!this.numbers.get(i).equals(that.numbers.get(i))) {
        return false;
      }
    }

    return true;
  }

  @Override
  public int hashCode() {
    return numbers.hashCode();
  }
}
