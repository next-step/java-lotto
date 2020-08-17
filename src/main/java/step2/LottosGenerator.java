package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottosGenerator {
  public static final int ONE_PRICE = 1000;
  private static final List<Integer> NUMBER_POOL =
      IntStream.rangeClosed(1, 45)
          .boxed()
          .collect(Collectors.toList());

  public static Lottos manualLottos(int payment, String[] lottoNumbers) {
    validatePayment(payment);
    validateCanBuyLottoCount(payment, lottoNumbers);

    return new Lottos(
        Arrays.stream(lottoNumbers)
            .map(LottosGenerator::list)
            .map(Lotto::new)
            .collect(Collectors.toList()));
  }

  public static List<Integer> list(String lottoNumbers) {
    return Arrays.stream(lottoNumbers.split(","))
        .map(value -> Integer.parseInt(value.trim()))
        .collect(Collectors.toList());
  }

  private static void validateCanBuyLottoCount(int payment, String[] lottoNumbers) {
    int canBuyCount = payment / ONE_PRICE;

    if (lottoNumbers.length > canBuyCount) {
      throw new IllegalArgumentException("구매가능 로또보다 더 많은 개수를 입력 했습니다.");
    }
  }

  public static Lottos autoLottos(int payment, int manualLottoCount) {
    validatePayment(payment);

    List<Lotto> lottos = new ArrayList<>();
    int canBuyCount = payment / ONE_PRICE - manualLottoCount;
    for (int i = 0; i < canBuyCount; i++) {
      lottos.add(generate());
    }

    return new Lottos(lottos);
  }

  public static Lotto generate() {
    Collections.shuffle(NUMBER_POOL);
    return new Lotto(new ArrayList<>(NUMBER_POOL.subList(0, Lotto.FIXED_COUNT)));
  }

  private static void validatePayment(int payment) {
    if (payment < ONE_PRICE) {
      throw new IllegalArgumentException("1000원 이상입력하세요.");
    }
  }
}
