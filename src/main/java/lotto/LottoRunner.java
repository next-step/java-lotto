package lotto;

public class LottoRunner {

  public static void main(String[] args) {

    int paid = LottoInputView.askPurchaseAmount();
    System.out.println(paid > 0);

  }
}
