package wootecam.lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoResultTest {
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2})
	@DisplayName("로또넘버 매칭 갯수에 따라 result반환 테스트 - 당첨아닌경우")
	void test매칭갯수에따라Result테스트(int input) {
		assertThat(LottoResult.findByMatchedCount(input)).isEqualTo(LottoResult.DEFEAT);
	}

	@Test
	@DisplayName("로또넘버 매칭 갯수에 따라 result반환 테스트 - 당첨케이스")
	void test매칭갯수에따른ResultTest당첨() {
		assertThat(LottoResult.findByMatchedCount(5)).isEqualTo(LottoResult.FIVE_MATCHING);
		assertThat(LottoResult.findByMatchedCount(6)).isEqualTo(LottoResult.SIX_MATCHING);
		assertThat(LottoResult.findByMatchedCount(3)).isEqualTo(LottoResult.THREE_MATCHING);
		assertThat(LottoResult.findByMatchedCount(4)).isEqualTo(LottoResult.FOUR_MATCHING);
	}
}
