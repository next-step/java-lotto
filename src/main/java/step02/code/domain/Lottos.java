package step02.code.domain;

import java.util.List;

public class Lottos {
  private static final int LOTTO_PRICE = 1000;
  
  private final List<Lotto> lottos;

  // public Lottos(List<Lotto> lottos) {
  //   this.lottos = lottos;
  // }
  public Lottos(int money) { 
    check(money);
    this.lottos = null;
  }

  public static void check(int money) {
    if(money <= LOTTO_PRICE) {
      throw new IllegalArgumentException("lotto 구입의 최소 금액보다 작습니다");
    }
    if(money % LOTTO_PRICE != 0) {
      throw new IllegalArgumentException("잔돈이 안남는 금액이 필요합니다");
    }
  }


}

// 1049913