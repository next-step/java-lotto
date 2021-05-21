package wootecam.lotto.core;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoCount;

public class LottoGameTest {

	@ParameterizedTest
	@ValueSource(strings = {"5000", "2000", "15000"})
	@DisplayName("입력된 금액에 맞는 로또 수를 생성하는지 테스트")
	void test_로또구매수만큼_로또생성확인(String input) {
		LottoGame lottoGame = new LottoGame(new AutomaticLottoGenerator());
		LottoCount lottoCount = new LottoCount(input);
		List<Lotto> lottos = lottoGame.getLottos(lottoCount);
		assertThat(lottos.size()).isEqualTo(lottoCount.getCount());
	}
}
