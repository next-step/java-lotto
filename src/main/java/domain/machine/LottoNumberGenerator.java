package domain.machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;

  private final List<Integer> possibleNumbers  = new ArrayList<>();

  public LottoNumberGenerator() {
    IntStream.range(MIN_NUMBER, MAX_NUMBER + 1).forEach(possibleNumbers::add);
  }

  public  List<Integer> generate(){
    Collections.shuffle(possibleNumbers);
    List<Integer> numbers = new ArrayList<>(possibleNumbers.subList(0, 6));
    numbers.sort(Integer::compareTo);
    return numbers;
  }

}
