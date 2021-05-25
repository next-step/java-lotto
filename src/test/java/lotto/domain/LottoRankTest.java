package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankTest {

	@DisplayName("로또 등수 경우의 수 테스트")
	@ParameterizedTest
	@MethodSource("argumentProvider")
	void rank(LottoPoint lottoPoint, LottoRank expectedLottoRank) {
		assertThat(LottoRank.rank(lottoPoint)).isEqualTo(expectedLottoRank);
	}

	static Stream<Arguments> argumentProvider() {
		return Stream.of(
			arguments(new LottoPoint(6), LottoRank.FIRST),
			arguments(new LottoPoint(5, true), LottoRank.SECOND),
			arguments(new LottoPoint(5), LottoRank.THIRD),
			arguments(new LottoPoint(4), LottoRank.FOURTH),
			arguments(new LottoPoint(3), LottoRank.FIFTH),
			arguments(new LottoPoint(0), LottoRank.OUT_OF_RANK),
			arguments(new LottoPoint(100), LottoRank.OUT_OF_RANK)
		);
	}

}
