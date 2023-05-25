package step2.lotto;

import java.util.List;

import step2.lotto.domain.LottoNumber;

public interface LottoNumberGenerator {
	List<LottoNumber> generate();
}
