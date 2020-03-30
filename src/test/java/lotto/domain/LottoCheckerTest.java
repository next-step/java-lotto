package lotto.domain;

import lotto.dto.LottoNumbers;
import lotto.dto.LottoRank;
import lotto.dto.LottoResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCheckerTest {

	@Test
	void getWinningResultTest() {
		LottoNumbers lottoNumbers = new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));
		LottoChecker lottoChecker = new LottoChecker(lottoNumbers, 7, 1000);

		assertThat(
				lottoChecker.getWinningResult(
						lottoNumbers,
						lottoNumbers).getWinningMap())
				.isEqualTo(new LottoResult(Collections.singletonMap(LottoRank.FIRST, 2L), 1000).getWinningMap());
	}


}