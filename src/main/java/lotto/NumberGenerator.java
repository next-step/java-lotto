package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.view.ResultView;

class NumberGenerator {

  private static final int START_NUMBER = 1;
  private static final int END_NUMBER = 45;

  List<Number> generate() {

    List<Number> numbers = IntStream.range(START_NUMBER, END_NUMBER)
        .mapToObj(Number::new)
        .collect(Collectors.toList());
    Collections.shuffle(numbers);

    List<Number> lotteNumbers = numbers.subList(0, 6);
    ResultView.printIssueLottoNumbers(lotteNumbers);
    return lotteNumbers;
  }
}
