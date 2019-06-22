package lotto;

import java.util.List;

public class LottoRunner {

  public static void main(String[] args) {

    int paid = LottoInputView.askPurchaseAmount();
    System.out.println(paid > 0);

    List<Lotto> lottos = LottoGenerator.generate(paid);
    int amount = lottos.size();

    LottoOutputView.print(amount);
  }
}
