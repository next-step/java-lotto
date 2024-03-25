package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;

  private final List<Integer> possibleNumbers;

  LottoNumberGenerator() {
    possibleNumbers = new ArrayList<>();
      for(int i = MIN_NUMBER; i <= MAX_NUMBER; i++){
          possibleNumbers.add(i);
      }
  }

  public  List<Integer> generate(){
    Collections.shuffle(possibleNumbers);
    List<Integer> numbers = new ArrayList<>(possibleNumbers.subList(0, 6));
    numbers.sort(Integer::compareTo);
    return numbers;
  }

}
