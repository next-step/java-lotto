package step02.code.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Lottos {
  private static final int LOTTO_PRICE = 1000;
  private static final int INIT_NUM = 0;
  
  private final List<Lotto> lottos;

  public Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public Lottos(int money) { 
    check(money);
    this.lottos = buy(money);
  }

  public static void check(int money) {
    if(money < LOTTO_PRICE) {
      throw new IllegalArgumentException("lotto 구입의 최소 금액보다 작습니다");
    }
    if(money % LOTTO_PRICE != 0) {
      throw new IllegalArgumentException("잔돈이 안남는 금액이 필요합니다");
    }
  }

  public static List<Integer> lottoNumbers(MakeNumber makeNumber) {
    return makeNumber.make();
  }

  public static List<Lotto> buy(int money) {
    return IntStream.range(INIT_NUM, money / LOTTO_PRICE)
      .boxed()
      .map((i) -> lottoNumbers(new RandomNumber()))
      .map(Lotto::new)
      .collect(Collectors.toList());
  }

  public List<Integer> match(List<Integer> winningNumber) {
    return lottos.stream()
      .map(lotto -> lotto.match(winningNumber))
      .collect(Collectors.toList());
  }

  public List<List<Integer>> lottos() {
    return lottos.stream()
      .map(Lotto::lotto)
      .collect(Collectors.toList());
  }
}