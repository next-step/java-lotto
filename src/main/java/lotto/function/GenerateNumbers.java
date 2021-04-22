package lotto.function;

import lotto.domain.LottoNumber;

import java.util.List;

@FunctionalInterface
public interface GenerateNumbers {
  List<LottoNumber> get();
}
