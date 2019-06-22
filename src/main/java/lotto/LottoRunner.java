package lotto;

public class LottoRunner {

  public static void main(String[] args) {

    int amount = LottoInputView.askPurchaseAmount();
    System.out.println(amount > 0);
  }
}
