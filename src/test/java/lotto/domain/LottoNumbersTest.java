package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

	@Test
	@DisplayName("자동으로 생성된 로또가 중복없이 6자리인지 확인")
	void createAutoLotto() {
		LottoNumbers lottoNumbers = LottoNumbers.createAutoLottoNumber();
		List<LottoNumber> collect = lottoNumbers.lottoNumbers().stream().distinct().collect(Collectors.toList());
		assertThat(collect.size()).isEqualTo(6);
	}
}