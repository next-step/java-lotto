package lotto;

import static lotto.LottoPrize.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottosTest {
	@DisplayName("로또 목록 중 당첨번호와 매칭 되는 개수에 맞는 로또 상금 타입들이 반환된다.")
	@ParameterizedTest
	@CsvSource(value = {"6,1", "5,3", "4,2", "3,1", "0,2"})
	void comparePrize(int matchedNumberCount, int lottoCount) {
		Lottos lottos = new Lottos(Arrays.asList(
			new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Arrays.asList(1, 2, 3, 4, 6, 7).stream().map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Arrays.asList(1, 22, 33, 4, 6, 7).stream().map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Arrays.asList(10, 20, 30, 40, 16, 17).stream().map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Arrays.asList(1, 2, 3, 4, 6, 7).stream().map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Arrays.asList(1, 2, 23, 22, 26, 7).stream().map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Arrays.asList(1, 2, 3, 4, 36, 37).stream().map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Arrays.asList(1, 2, 3, 4, 26, 27).stream().map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Arrays.asList(1, 2, 3, 4, 6, 7).stream().map(LottoNumber::new).collect(Collectors.toList()))));

		List<LottoNumber> winningNumbers = Arrays.asList(1,2,3,4,5,6).stream().map(LottoNumber::new).collect(Collectors.toList());
		Lotto winningLotto = new Lotto(winningNumbers);

		List<LottoPrize> result = lottos.comparePrize(winningLotto);
		assertThat(result.stream()
			.filter(lottoPrize -> lottoPrize.equals(getLottoPrizeFromMatchCount(matchedNumberCount)))
			.count()).isEqualTo(lottoCount);
	}
}
