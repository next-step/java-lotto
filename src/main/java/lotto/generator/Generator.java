package lotto.generator;

import java.util.List;

import lotto.domain.LottoNumber;

@FunctionalInterface
public interface Generator {
	List<LottoNumber> generate();
}
