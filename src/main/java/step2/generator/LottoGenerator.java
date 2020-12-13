package step2.generator;

import step2.domain.Number;
import step2.domain.UserLotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

  public static final int LOTTO_MIN_NUMBER = 1;
  public static final int LOTTO_MAX_NUMBER = 45;
  public static final int ZERO = 0;
  public static final int LOTTO_NUMBER_LIMIT_SIZE = 6;

  public static List<UserLotto> generateList(int size) {
    List<UserLotto> userLottoList = new ArrayList<>();
    for (int i = 0; i < size; i ++) {
      userLottoList.add(generate());
    }
    return userLottoList;
  }

  private static UserLotto generate() {
    List<Integer> lottoNumberList = IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
        .boxed()
        .collect(Collectors.toList());
    Collections.shuffle(lottoNumberList);
    List<Number> numbers = lottoNumberList.subList(ZERO, LOTTO_NUMBER_LIMIT_SIZE).stream()
        .map(Number::new)
        .sorted(Comparator.comparing(Number::get))
        .collect(Collectors.toList());
    return new UserLotto(numbers);
  }
}
