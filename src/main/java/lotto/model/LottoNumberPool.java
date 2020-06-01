package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoNumberPool {
  INSTANCE;

  private final static int MIN = 1;
  private final static int MAX = 45;
  private final static int SIZE = 6;

  private final List<Integer> numbers;

  LottoNumberPool() {
    numbers = new ArrayList<>();
    for (int i = MIN; i <= MAX; i++) {
      numbers.add(i);
    }
  }

  public List<Integer> getNumbers(){
    return new ArrayList<>(numbers);
  }

  /**
   * 번호 풀에서 번호 자동 생성
   *
   * @return 1~45 사이 랜덤 수 6자리
   */
  public List<Integer> quickPick() {
    Collections.shuffle(numbers);

    return numbers.stream().limit(SIZE).sorted(Integer::compareTo)
        .collect(Collectors.toList());
  }
}
