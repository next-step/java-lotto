package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

	@DisplayName("기준 범위는 1~45까지 테스트")
	@ParameterizedTest
	@ValueSource(ints = {555, -55, -12345})
	void 로또_숫자_그룹_기준_범위_초과_테스트(int input) {
		assertThatThrownBy(() -> new LottoNumber(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("기준 범위를 초과하였습니다.");
	}

	@DisplayName("옳바른 로또 번호 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"a", "-", "4$%"})
	void name(String input) {
		assertThatThrownBy(() -> new LottoNumber(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("For input string: ");
	}
}
