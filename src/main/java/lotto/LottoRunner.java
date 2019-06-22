package lotto;

import java.util.List;

public class LottoRunner {

  public static void main(String[] args) {

    int paid = LottoInputView.askPurchaseAmount();
    System.out.println(paid > 0);

    LottoGenerator lottoGenerator = new LottoGenerator(new RandomNumberGenerator());

    List<Lotto> lottos = lottoGenerator.generate(paid);
    int amount = lottos.size();

    LottoOutputView.print(amount);
  }
}
