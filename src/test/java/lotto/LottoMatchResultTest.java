package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMatchResultTest {

	@DisplayName("수익률을 반환한다.")
	@Test
	void getProfit() {
		Lottos lottos = new Lottos(Arrays.asList(
			new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9).stream().map(LottoNumber::new).collect(Collectors.toList())),
			new Lotto(Arrays.asList(4, 5, 6, 10, 11, 12).stream().map(LottoNumber::new).collect(Collectors.toList()))));

		List<LottoNumber> winningNumbers = Arrays.asList(1,2,3,4,5,6).stream().map(LottoNumber::new).collect(Collectors.toList());
		Lotto winningLotto = new Lotto(winningNumbers);

		assertThat(new LottoMatchResult(lottos, winningLotto).getProfit()).isEqualTo(5.00f);
	}
}
