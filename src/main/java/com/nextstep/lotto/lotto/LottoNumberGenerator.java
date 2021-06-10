package com.nextstep.lotto.lotto;

import java.util.Set;

public interface LottoNumberGenerator {
	Set<LottoNumber> makeNumbers();

	LottoNumber makeNumber();
}
