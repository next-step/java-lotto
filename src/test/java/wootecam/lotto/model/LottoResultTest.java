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
		assertThat(LottoResult.findByMatchedCount(input, false)).isEqualTo(LottoResult.MISS);
	}

	@Test
	@DisplayName("로또넘버 매칭 갯수에 따라 result반환 테스트 - 당첨케이스")
	void test매칭갯수에따른ResultTest당첨() {
		assertThat(LottoResult.findByMatchedCount(5, false)).isEqualTo(LottoResult.THIRD);
		assertThat(LottoResult.findByMatchedCount(6, false)).isEqualTo(LottoResult.FIRST);
		assertThat(LottoResult.findByMatchedCount(3, false)).isEqualTo(LottoResult.FIFTH);
		assertThat(LottoResult.findByMatchedCount(4, false)).isEqualTo(LottoResult.FOURTH);
	}

	@Test
	@DisplayName("로또 번호 매칭이 5개이고 보너스가포함되면 2등 , 보너스포함 안되면 3등 반환")
	void test2등() {
		assertThat(LottoResult.findByMatchedCount(5, true)).isEqualTo(LottoResult.SECOND);
		assertThat(LottoResult.findByMatchedCount(5, false)).isEqualTo(LottoResult.THIRD);
	}
}
