package camp.nextcamp.edu.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextcamp.edu.lotto.entity.Lotto;
import camp.nextcamp.edu.lotto.entity.LottoTicket;
import camp.nextcamp.edu.lotto.module.LottoModule;

public class LottoModuleTest {

	@Test
	@DisplayName("lotto list 만들기 갯수만큼")
	void LottoList_만들기() {
		// given
		LottoTicket ticket = new LottoTicket("14000");

		// then
		List<Lotto> list = LottoModule.getInstance().getLottos(ticket);

		// then
		assertThat(list.size())
			.isEqualTo(14);
	}

	@ParameterizedTest
	@DisplayName("makeWinningLotto test")
	@ValueSource(strings = {"1, 3, 4, 5, 6, 7", "2, 3, 4, 5, 6, 7"})
	void makeWinningLotto_test(String input) {
		assertThat(LottoModule.getInstance().makeWinningLotto(input))
			.isInstanceOf(Lotto.class);
	}


}
