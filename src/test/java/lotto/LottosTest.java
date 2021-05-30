package lotto;

import static lotto.LottoPrize.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottosTest {
	@DisplayName("로또 목록 중 당첨번호와 매칭 되는 개수에 맞는 로또 상금 타입들이 반환된다.")
	@ParameterizedTest
	@CsvSource(value = { "6,1", "5,3", "4,2", "3,1" })
	void comparePrize(int matchedNumberCount, int lottoCount) {
		Lottos lottos = lottosData();
		List<LottoNumber> winningNumbers = Stream.of(1,2,3,4,5,6).map(LottoNumber::new).collect(Collectors.toList());
		WinningLotto winningLotto = new WinningLotto(winningNumbers, new LottoNumber(45));

		List<LottoPrize> result = lottos.comparePrize(winningLotto);
		assertThat(result.stream()
			.filter(lottoPrize -> lottoPrize.equals(getLottoPrizeFromMatchCount(matchedNumberCount, false)))
			.count()).isEqualTo(lottoCount);
	}

	static Lottos lottosData() {
		return new Lottos(Arrays.asList(
			new Lotto(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Stream.of(1, 2, 3, 4, 6, 7).map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Stream.of(1, 22, 33, 4, 6, 7).map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Stream.of(10, 20, 30, 40, 16, 17).map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Stream.of(1, 2, 3, 4, 6, 7).map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Stream.of(1, 2, 23, 22, 26, 7).map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Stream.of(1, 2, 3, 4, 36, 37).map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Stream.of(1, 2, 3, 4, 26, 27).map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Stream.of(1, 2, 3, 4, 6, 7).map(LottoNumber::new).collect(Collectors.toList()))));
	}
}
