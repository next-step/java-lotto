package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMatchResultTest {

	@DisplayName("수익률을 반환한다.")
	@Test
	void getProfit() {
		Lottos lottos = new Lottos(Arrays.asList(
			new Lotto(Stream.of(1, 2, 3, 7, 8, 9).map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Stream.of(4, 5, 6, 10, 11, 12).map(LottoNumber::new).collect(Collectors.toList()))));

		List<LottoNumber> winningNumbers = Stream.of(1,2,3,4,5,6).map(LottoNumber::new).collect(Collectors.toList());
		WinningLotto winningLotto = new WinningLotto(winningNumbers, new LottoNumber(45));

		assertThat(new LottoMatchResult(lottos, winningLotto).getProfit()).isEqualTo(5.00f);
	}
}
