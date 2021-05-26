package wootecam.lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import wootecam.lotto.exception.LottoException;

public class LottoCountTest {
	@Test
	@DisplayName("동일한 금액으로 카운트가 정상적으로 생성되는지 확인")
	void test_동일한구매금액으로_로또카운트_생성확인() {
		LottoCount lottoCount = new LottoCount("14000", "0");
		assertThat(lottoCount).isEqualTo(new LottoCount("14000", "0"));
	}

	@ParameterizedTest
	@ValueSource(strings = {"-200", "test", "1500o"})
	@DisplayName("금액이 0이상이 아니면 오류발생")
	void test_금액입력이_0이상아닌경우(String input) {
		assertThatThrownBy(() -> {
			new LottoCount(input, "0");
		}).isInstanceOf(LottoException.class)
			.hasMessageContaining("0 이상의 금액을 입력해야합니다.");
	}

	@ParameterizedTest
	@CsvSource(value = {"14000:14", "14500:14", "12000:12", "0:0"}, delimiter = ':')
	@DisplayName("입력 금액에 맞는 Count 계산후 반환테스트")
	void test_금액입력에맞는_count반환(String input, int expected) {
		LottoCount lottoCount = new LottoCount(input, "0");
		assertThat(lottoCount.getTotalCount()).isEqualTo(expected);
	}

	@Test
	@DisplayName("구매금액 이상으로 수동로또를 생성한경우 오류발생")
	void test_수동로또생성갯수초과오류() {
		assertThatThrownBy(() -> {
			new LottoCount("5000", "6");
		}).isInstanceOf(LottoException.class)
			.hasMessageContaining("수동 갯수가 구매금액을 초과했습니다.");
	}

	@Test
	@DisplayName("수동, 자동 로또 갯수생성 확인")
	void test_로또갯수생성확인() {
		LottoCount lottoCount = new LottoCount("5000", "3");
		assertThat(lottoCount.getTotalCount()).isEqualTo(5);
		assertThat(lottoCount.getAutomaticCount()).isEqualTo(2);
		assertThat(lottoCount.getManualCount()).isEqualTo(3);

	}
}
