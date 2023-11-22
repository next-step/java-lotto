package lotto.domain.strategy;

import java.util.Set;

import lotto.domain.LottoNumber;

public interface GenerateStrategy {
	Set<LottoNumber> generate();
}
