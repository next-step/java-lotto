package lotto.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.domain.Lotto;

public class LottoUtilsTest {

	@ParameterizedTest
	@CsvSource(value = {"1, 2, 3, 4, 5, 6", "4, 10, 25, 40, 45, 1", "23, 4 ,2, 30, 1, 5"})
	@DisplayName("문자열 로또를 로또로 변환시키는 테스트")
	public void getStringToLotto(String lottoString) {
		Lotto lotto = LottoUtils.getStringToLotto(lottoString);
		assertThat(lotto).isNotNull();
		assertThat(lotto.toString()).isEqualTo("["+ lottoString +"]");
	}
}
