package lotto;

import lotto.controller.LotteryController;

public class Main {
  public static void main(String[] args) {
    LotteryController lotteryController = LotteryController.getInstance();
    lotteryController.play();
  }
}
