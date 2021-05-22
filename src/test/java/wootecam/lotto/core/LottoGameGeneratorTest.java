package wootecam.lotto.core;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoCount;

public class LottoGameGeneratorTest {

	@ParameterizedTest
	@ValueSource(strings = {"5000", "2000", "15000"})
	@DisplayName("입력된 금액에 맞는 로또 수를 생성하는지 테스트")
	void test_로또구매수만큼_로또생성확인(String input) {
		LottoGameGenerator lottoGame = new LottoGameGenerator(new AutomaticLottoGenerator());
		LottoCount lottoCount = new LottoCount(input);
		List<Lotto> lottos = lottoGame.getLottos(lottoCount);
		assertThat(lottos.size()).isEqualTo(lottoCount.getCount());
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,6"})
	@DisplayName("정상적인 입력에 대한 당첨번호테스트")
	void test_당첨번호테스트(String input) {
		LottoGameGenerator lottoGameGenerator = new LottoGameGenerator(new AutomaticLottoGenerator());
		Lotto winningLotto = lottoGameGenerator.getWinningLotto(input);

		assertThat(winningLotto.getLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
	}
}
