package step2.strategy;

import step2.domain.number.Number;

import java.util.List;

public interface LottoStrategy {
  List<Number> markingNumbers(List<Number> lottoNumbers);
}
