package lotto.model;

import java.util.List;

public interface NumberGenerator {
  List<Integer> generate(int limit);
}
