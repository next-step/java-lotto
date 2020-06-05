package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberPool {

  private final static int MIN = 1;
  private final static int MAX = 45;

  private final List<Integer> numbers;

  private LottoNumberPool() {
    numbers = new ArrayList<>();
    for (int i = MIN; i <= MAX; i++) {
      numbers.add(i);
    }
  }

  public static LottoNumberPool getInstance() {
    return LazyHolder.INSTANCE;
  }

  private static class LazyHolder {

    private static final LottoNumberPool INSTANCE = new LottoNumberPool();
  }

  public List<Integer> getNumbers() {
    return new ArrayList<>(numbers);
  }

  /**
   * 번호 풀에서 번호 자동 생성
   *
   * @return 1~45 사이 랜덤 수 6자리
   */
  public List<LottoNumber> quickPick() {
    Collections.shuffle(numbers);

    List<LottoNumber> result = numbers.stream().limit(Lotto.LOTTO_SIZE)
        .map(i -> new LottoNumber(i)).sorted(LottoNumber::compareTo)
        .collect(Collectors.toList());

    return result;
  }
}
