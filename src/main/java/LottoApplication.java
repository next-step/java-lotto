import lotto.LottoController;

public class LottoApplication {

  public static void main(String[] args) {
    try{
    LottoController.init()
        .purchaseByInput()
        .insertWinningNumber()
        .printRevenue();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
