package lotto.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCoupon;
import lotto.domain.Money;
import lotto.domain.Number;

public class InputView {

  private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public Money howManyBuyLottoCoupon() throws IOException {
    System.out.println("구입금액을 입력해 주세요.");
    return new Money(Integer.parseInt(reader.readLine()));
  }

  public Lotto enterWinnerNumbers() throws IOException {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return stringToLotto(reader.readLine());
  }

  public Number enterBonusBall() throws IOException {
    System.out.println("보너스 볼을 입력해주세요.");
    return stringToNumber(reader.readLine());
  }

  public Number enterManualLottoQuantity() throws IOException {
    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    return stringToNumber(reader.readLine());
  }

  public LottoCoupon enterManualLottoNumbers(Number number) throws IOException {
    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    List<Lotto> lottos = new ArrayList<>();
    for(int i = 0; i < number.getNumber(); i++) {
      lottos.add(stringToLotto(reader.readLine()));
    }
    return LottoCoupon.asLottoCoupon(lottos);
  }

  private Lotto stringToLotto(String enteredWinnerNumbers) {
    List<Number> numbers = new ArrayList<>();
    String[] list = enteredWinnerNumbers.split("[, ]");

    for(String str : list) {
      numbers.add(new Number(Integer.parseInt(str)));
    }
    return new Lotto(numbers);
  }

  private Number stringToNumber(String enteredBonusBall) {
    return new Number(Integer.parseInt(enteredBonusBall));
  }
}
