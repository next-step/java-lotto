package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.jws.Oneway;

public class LottoGenerator {
  public static final int ONE_PRICE = 1000;
  private static final List<Integer> NUMBER_POOL =
      Stream.iterate(1, n -> ++n).limit(45).collect(Collectors.toList());

  public static Lotto generate() {
    Collections.shuffle(NUMBER_POOL);
    return new Lotto(new ArrayList<>(NUMBER_POOL.subList(0, Lotto.FIXED_COUNT)));
  }

  public static List<Lotto> generate(int payment) {
    validatePayment(payment);

    List<Lotto> lottos = new ArrayList<>();
    int canBuyCount = payment / ONE_PRICE;
    for (int i = 0; i < canBuyCount; i++) {
      lottos.add(generate());
    }

    return lottos;
  }

  private static void validatePayment(int payment) {
    if (payment < ONE_PRICE) {
      throw new IllegalArgumentException("1000원 이상입력하세요.");
    }
  }
}
