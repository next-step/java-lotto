package step02.code.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomNumber implements MakeNumber {
  private static final int MAX_NUM = 45;

  @Override
  public List<Integer> make() {
    Set<Integer> set = new HashSet<>();
    while(set.size() < 6) {
      set.add((new Random().nextInt(MAX_NUM)) + 1);
    }
    return new ArrayList<>(set);
  }
  
}
