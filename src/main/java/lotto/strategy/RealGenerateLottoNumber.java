package lotto.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RealGenerateLottoNumber implements GenerateLottoNumber{

  private static final int START = 1;

  private static final int END = 46;

  public RealGenerateLottoNumber() {
  }

  @Override
  public List<Integer> createNumberPull() {
    List<Integer> numbers = new ArrayList<>();
    for(int i = START; i < END; i++){
      numbers.add(i);
    }
    Collections.shuffle(numbers);
    return numbers;
  }
}
