package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMatchTest {
	@ParameterizedTest
	@ValueSource(ints = {3, 4, 5, 6})
	@DisplayName("fromInt 는 존재하는 숫자가 주어지면 해당 값이 key인 enum 을 반환한다")
	void fromInt_validInteger_validLEnum(int key) {
		LottoMatch lottoMatch = LottoMatch.fromInt(key, false);

		assertThat(lottoMatch.matchCount()).isEqualTo(key);
	}

	@ParameterizedTest
	@ValueSource(ints = {7, 8, 9})
	@DisplayName("fromInt 는 존재하지 않은 숫자가 주어지면 0을 반환한다")
	void fromInt_invalidInteger_ZERO(int key) {
		LottoMatch lottoMatch = LottoMatch.fromInt(key, false);

		assertThat(lottoMatch).isEqualTo(LottoMatch.ZERO);
	}
}
