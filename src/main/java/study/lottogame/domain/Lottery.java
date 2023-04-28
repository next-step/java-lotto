package study.lottogame.domain;

import java.util.List;

public class Lottery {

  public static final int LotteryPrice = 1000;

  private List<Integer> lottoNumber;

  public Lottery(List<Integer> lottoNumber) {
    this.lottoNumber = lottoNumber;
  }
}
