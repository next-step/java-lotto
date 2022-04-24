package lotto;

public class LottoController {

  private static final int LOTTERY_PRICE = 1000;



  public int getLotteryAmount(int money) {
    return money / LOTTERY_PRICE;
  }

}
