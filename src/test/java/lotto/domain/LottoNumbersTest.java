package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

	@Test
	@DisplayName("create test.")
	void create() {
		//given

		//when
		LottoNumbers lottoNumbers = LottoNumbers.createAutoLottoNumber();

		//then
		assertThat(lottoNumbers.lottoNumbers().size()).isEqualTo(6);

	}

	@Test
	@DisplayName("lottoNumber sort test")
	void sortTest() {
		//given
		LottoNumbers lottoNumbers = LottoNumbers.createManualLottoNumber(Arrays.asList(3, 4, 5, 1, 10, 6));

		//then
		assertThat(lottoNumbers.lottoNumbers()).isEqualTo(LottoNumbers.createManualLottoNumber(Arrays.asList(1, 3, 4, 5, 6, 10)).lottoNumbers());
	}
}