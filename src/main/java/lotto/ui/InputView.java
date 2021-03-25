package lotto.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Number;

public class InputView {

  private final BufferedReader reader;

  public InputView(BufferedReader reader) {
    this.reader = reader;
  }

  public Money howManyBuyLottoCoupon() throws IOException {
    System.out.println("구입금액을 입력해 주세요.");
    return new Money(Integer.parseInt(reader.readLine()));
  }

  public Lotto enterWinnerNumbers() throws IOException {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return stringToLotto(reader.readLine());
  }

  private Lotto stringToLotto(String enteredWinnerNumbers) {
    List<Number> numbers = new ArrayList<>();
    String[] list = enteredWinnerNumbers.split("[, ]");

    for(String str : list) {
      numbers.add(new Number(Integer.parseInt(str)));
    }

    return new Lotto(numbers);
  }

}
