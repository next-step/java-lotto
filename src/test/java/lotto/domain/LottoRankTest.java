package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class LottoRankTest {

	@DisplayName("로또 등수 경우의 수 테스트")
	@ParameterizedTest
	@MethodSource("argumentProvider")
	void rank(int matchCount, boolean bonus, LottoPoint lottoPoint, LottoRank expectedLottoRank) {
		assertThat(LottoRank.rank(matchCount, bonus)).isEqualTo(expectedLottoRank);
	}

	static Stream<Arguments> argumentProvider() {
		return Stream.of(
			arguments(6, false, new LottoPoint(6), LottoRank.FIRST),
			arguments(5, true, new LottoPoint(5, true), LottoRank.SECOND),
			arguments(5, false, new LottoPoint(5), LottoRank.THIRD),
			arguments(4, false, new LottoPoint(4), LottoRank.FOURTH),
			arguments(3, false, new LottoPoint(3), LottoRank.FIFTH),
			arguments(0, false, new LottoPoint(0), LottoRank.OUT_OF_RANK),
			arguments(100, false, new LottoPoint(100), LottoRank.OUT_OF_RANK)
		);
	}

}
