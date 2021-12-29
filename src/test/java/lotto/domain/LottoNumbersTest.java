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

	@Test
	@DisplayName("로또 수동 구매 테스트")
	void manual_lotto_Test() {
		LottoNumbers lottoNumbers = LottoNumbers.createManualLottoNumber(Arrays.asList(8, 21, 23, 41, 42, 43));

		assertThat(lottoNumbers.lottoNumbers())
			.extracting("lottoNumber", Integer.class)
			.contains(8, 21, 23, 41, 42, 43);
	}
}