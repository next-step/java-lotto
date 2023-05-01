package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import stringCalculator.Number;

public class InputView {

  public Money buy() {
    Printer.print("구입금액을 입력해 주세요.");
    return Money.from(Reader.read());
  }

  public List<LottoNumber> lastWeekNumbers() {
    Printer.print("지난 주 당첨 번호를 입력해 주세요.");
    return Arrays.stream(
            Reader.read().split(", "))
        .map(LottoNumber::from)
        .collect(Collectors.toList());
  }
}
