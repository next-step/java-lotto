package lotto.domain;

import lotto.dto.LottoNumberDto;
import lotto.dto.LottoRank;
import lotto.dto.LottoStatisticsDto;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCheckerTest {

	@Test
	void getWinningResultTest() {
		LottoNumberDto lottoNumberDto = new LottoNumberDto(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()));
		LottoChecker lottoChecker = new LottoChecker(lottoNumberDto, 7, 1000);

		assertThat(
				lottoChecker.getWinningResult(
						lottoNumberDto,
						lottoNumberDto).getWinningMap())
				.isEqualTo(new LottoStatisticsDto(Collections.singletonMap(LottoRank.FIRST, 2L), 1000).getWinningMap());
	}


}