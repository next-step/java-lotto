package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
  public static final List<Integer> NUMBER_POOL =
      Stream.iterate(1, n -> ++n).limit(45).collect(Collectors.toList());

  public static Lotto generate() {
    Collections.shuffle(NUMBER_POOL);
    return new Lotto(new ArrayList<>(NUMBER_POOL.subList(0, Lotto.FIXED_COUNT)));
  }

  public static List<Lotto> generate(int money) {
    validateMoney(money);
    List<Lotto> lottos = new ArrayList<>();
    do {
      lottos.add(generate());
    } while (money - 1000 >= 1000);

    return lottos;
  }

  private static void validateMoney(int money) {
    if (money < 1000) {
      throw new IllegalArgumentException("1000원 이상입력하세요.");
    }
  }
}
