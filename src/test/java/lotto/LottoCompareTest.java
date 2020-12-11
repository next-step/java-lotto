package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCompareTest {

	@DisplayName("일치 수에 따라 등수를 가져온다")
	@Test
	void 로또_결과() {
		LottoResult lottoResult = new LottoResult(6);
		assertThat(lottoResult.getRank()).isEqualTo(Rank.WINNER);
	}

	@DisplayName("로또 번호가 일치하는 수에 따라서 등수를 나타내는 기능 테스트")
	@ParameterizedTest
	@MethodSource("sortNumbers")
	void 로또_등_TEST(LottoNumbers targetLotto, Rank rank) {
		LottoNumbers lastWeekLottoNumbers = GenerateLottoNumber.manual(Arrays.asList(8, 21, 23, 41, 42, 43));
		assertThat(new LottoResult(targetLotto.isContainsCount(lastWeekLottoNumbers)).getRank()).isEqualTo(rank);
	}

	public static Stream<Arguments> sortNumbers() {
		return Stream.of(
			Arguments.of(GenerateLottoNumber.manual(Arrays.asList(8, 21, 23, 41, 42, 43)), Rank.WINNER),
			Arguments.of(GenerateLottoNumber.manual(Arrays.asList(1, 2, 3, 41, 42, 43)), Rank.FOURTH),
			Arguments.of(GenerateLottoNumber.manual(Arrays.asList(1, 2, 3, 4, 5, 6)), Rank.FIVE),
			Arguments.of(GenerateLottoNumber.manual(Arrays.asList(6, 7, 8, 9, 10)), Rank.FIVE)
		);
	}
}
