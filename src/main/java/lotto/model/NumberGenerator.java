package lotto.model;

import java.util.List;

public interface NumberGenerator {
  List<LottoNumber> generate(int limit);
}
