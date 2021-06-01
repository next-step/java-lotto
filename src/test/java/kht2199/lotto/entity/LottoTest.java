package kht2199.lotto.entity;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import kht2199.lotto.exception.number.LottoNumberException;

class LottoTest {

	@ParameterizedTest
	@DisplayName("당첨번호와 단일 로또의 일치 갯수")
	@MethodSource("calculateRankSource")
	void calculateRankTest(Lotto lotto, Rank rank) throws
		LottoNumberException {
		Lotto winningResult = LottoNumber.valuesOf(1, 2, 3, 4, 5, 6);
		assertThat(lotto.calculateRank(winningResult, LottoNumber.valueOf(7)))
			.isEqualTo(rank);
	}

	static Stream<Arguments> calculateRankSource() throws LottoNumberException {
		return Stream.of(
			Arguments.of(LottoNumber.valuesOf(1, 2, 3, 4, 5, 6), Rank.FIRST),
			Arguments.of(LottoNumber.valuesOf(1, 2, 3, 4, 5, 7), Rank.SECOND),
			Arguments.of(LottoNumber.valuesOf(1, 2, 3, 4, 5, 8), Rank.THIRD),
			Arguments.of(LottoNumber.valuesOf(1, 2, 3, 4, 8, 9), Rank.FOURTH),
			Arguments.of(LottoNumber.valuesOf(1, 2, 3, 8, 9, 10), Rank.FIFTH),
			Arguments.of(LottoNumber.valuesOf(7, 8, 9, 10, 11, 12), Rank.MISS)
		);
	}
}