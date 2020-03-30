package lotto.domain;

import lotto.domain.dto.LottoRank;
import lotto.domain.dto.LottoResult;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCheckerTest {

	@Test
	void getWinningResultTest() {
		List<Integer> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());
		LottoChecker lottoChecker = new LottoChecker(new LottoWinningNumber(lottoNumbers, 7), 1000);

		assertThat(
				lottoChecker.getWinningResult(
						new LottoNumber(lottoNumbers),
						new LottoNumber(lottoNumbers)))
				.isEqualTo(new LottoResult(Collections.singletonMap(LottoRank.FIRST, 2L), 1000));
	}
}