package step02.code.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Lottos {
  private static final int LOTTO_PRICE = 1000;
  private static final int INIT_NUM = 0;
  
  private final List<Lotto> lottos;

  public Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  private static void check(int money) {
    if(money < LOTTO_PRICE) {
      throw new IllegalArgumentException("lotto 구입의 최소 금액보다 작습니다");
    }
    if(money % LOTTO_PRICE != 0) {
      throw new IllegalArgumentException("잔돈이 안남는 금액이 필요합니다");
    }
  }

  public static Lottos buy(int money) {
    check(money);
    List<Lotto> lottos = IntStream.range(INIT_NUM, money / LOTTO_PRICE)
      .boxed()
      .map((i) -> new Lotto(new RandomNumber()))
      .collect(Collectors.toList());
    return new Lottos(lottos);
  }

  private static void checkPassive(int money, List<Lotto> lottos) {
    check(money);
    if(money - (LOTTO_PRICE * lottos.size()) < 0) {
      throw new IllegalArgumentException("lotto 구입 금액을 초과할수 없습니다.");
    }
  }

  // 수동 구매가 포함된 경우
  public static Lottos buy(int money, List<Lotto> lottos) {
    checkPassive(money, lottos);
    int change = money - (LOTTO_PRICE * lottos.size());

    List<Lotto> autoLottos = IntStream.range(INIT_NUM, change / LOTTO_PRICE)
      .boxed()
      .map((i) -> new Lotto(new RandomNumber()))
      .collect(Collectors.toList());

    List<Lotto> list = new ArrayList<>();
    list.addAll(lottos);
    list.addAll(autoLottos);
      
    return new Lottos(list);
  }

  public List<Lotto> lottos() {
    return Collections.unmodifiableList(lottos);
  }

  public List<GradeEnum> match(Lotto winningNumber, Number bonus) {
    return lottos.stream()
      .map(lotto -> GradeEnum.fromGrade(lotto.match(winningNumber), lotto.isMatchBonus(bonus)))
      .collect(Collectors.toList());
  }

}