package lotto.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionShuffleLottoNumGenerator implements LottoNumGenerator {

  @Override
  public List<Integer> shuffle(List<Integer> candidates) {
    List<Integer> res = new ArrayList<>(candidates);
    Collections.shuffle(res);
    Collections.sort(res);
    return res;
  }
}
