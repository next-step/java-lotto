package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Number;

public class ManualLottoNumberGenerateStrategy implements LottoNumberGenerateStrategy {

  private static final int LOTTO_SIZE = 6;

  private final List<Number> numbers;

  public ManualLottoNumberGenerateStrategy(List<Integer> numbers) {
    this.numbers = createManualNumbers(numbers);
  }

  @Override
  public List<Number> generate() {
    if(numbers.isEmpty())
      throw new IllegalArgumentException("빈 값일 수가 없습니다.");
    return numbers;
  }

  public List<Number> createManualNumbers(List<Integer> userInput) {
    List<Number> numbers = new ArrayList<>();
    for(int i = 0; i < LOTTO_SIZE; i++) {
      numbers.add(Number.generateNumber(userInput.get(i)));
    }
    return numbers;
  }
}
