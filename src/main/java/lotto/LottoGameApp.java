package lotto;

import lotto.view.LottoGameInputView;

public class LottoGameApp {

  public static void main(String[] args) {
    LottoGameInputView lottoGameInputView = new LottoGameInputView();
    lottoGameInputView.setPurchaseAmount();
    System.out.println(lottoGameInputView.getPurchaseAmount());

    lottoGameInputView.setWinNumbers();
    System.out.println(lottoGameInputView.getWinNumbers());
  }
}
