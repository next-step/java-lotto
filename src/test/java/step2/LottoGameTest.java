package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.model.AutoLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoGameTest {
	@ParameterizedTest
	@CsvSource(value = {"1000|1", "1900|1", "2000|2", "2100|2"}, delimiter = '|')
	void 로또_구입(int money, int amount) {
		assertThat(new LottoGame(money).getLottos().size()).isEqualTo(amount);
	}

	@Test
	void 로또_최저금액() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new LottoGame(999);
		});
	}

	@Test
	void 당첨금_비교() {
		List<AutoLotto> lottos = new ArrayList<AutoLotto>() {
			{
				add(new AutoLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
				add(new AutoLotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
			}
		};
		LottoGame lottoGame = new LottoGame(lottos);
		assertThat(lottoGame.getPrizeSum("1,2,3,4,5,6")).isEqualTo(2001500000);
	}
}
