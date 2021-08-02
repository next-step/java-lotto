package lottoautomatic.domain;

import lottoautomatic.domain.LottoNumberShuffle;
import lottoautomatic.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

	@ParameterizedTest
	@CsvSource(value = {
			"14000,14",
			"1000,1"
	})
	@DisplayName("금액별 로또 수량")
	void lotto_by_amount(int amount, int lottoCount) throws Exception {
		//given
		Lottos lottos = new Lottos();

		//when
		lottos.buy(amount, new LottoNumberShuffle());
		int size = lottos.size();

		//then
		assertThat(size).isEqualTo(lottoCount);

	}

	@ParameterizedTest
	@MethodSource
	@DisplayName("당첨 등수별 수량")
	void match(List<Integer> lottoNumbers, int matchCount, int count) throws Exception {
		//given
		Lottos lottos = new Lottos();

		//when
		lottos.buy(1000, () -> lottoNumbers);
		Map<Integer, Integer> result = lottos.match(Arrays.asList(1,2,3,4,5,6));

		//then
		assertThat(result).containsEntry(matchCount, count);

	}

	private static Stream<Arguments> match() {
		return Stream.of(
				Arguments.of(Arrays.asList(1,2,3,11,12,13), 3, 1),
				Arguments.of(Arrays.asList(1,2,3,4,11,12), 4, 1),
				Arguments.of(Arrays.asList(1,2,3,4,5,11), 5, 1),
				Arguments.of(Arrays.asList(1,2,3,4,5,6), 6, 1)
		);
	}

}
