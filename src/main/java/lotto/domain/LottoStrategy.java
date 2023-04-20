package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface LottoStrategy {
  List<LottoNumber> buy();
}
