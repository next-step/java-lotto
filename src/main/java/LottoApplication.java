import lotto.LottoController;

public class LottoApplication {

  public static void main(String[] args) {
    LottoController.init()
        .insertAmount()
        .insertWinningNumbers();
  }

}
