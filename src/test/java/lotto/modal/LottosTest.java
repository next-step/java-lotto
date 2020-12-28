package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {

	@Test
	@DisplayName("로또s 메뉴얼: 랜덤 로또 생성")
	void initRandomManualLotto() {
		Lottos randomLotto = new Lottos();
		randomLotto.addRandomLotto(10);
		assertThat(randomLotto.getLottos().size()).isEqualTo(10);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,6", "1,3,23,34,35,36", "1,3,21,32,33,34", "1,3,23,34,35,36"})
	@DisplayName("로또s 메뉴얼: 유저 입력 로또 생성")
	void initUserManualLotto(String inputLotto) {
		Lottos userLotto = new Lottos();
		userLotto.addManualLottos(inputLotto);

		List<Lotto> lottoPackage = new ArrayList<>();
		lottoPackage.add(Lotto.generateManualLotto(inputLotto));
		assertThat(userLotto.getLottos()).isSameAs(lottoPackage);
	}

	@Test
	@DisplayName("로또s 메뉴얼: 종합 로또 테스트(메뉴얼 로또 + 랜덤 로또)")
	void initAllLottos() {
		Lottos lottos = new Lottos();
		lottos.addManualLottos("1,2,3,4,5,6");
		lottos.addManualLottos("1,3,21,32,33,34");
		lottos.addManualLottos("1,3,23,34,35,36");

		lottos.addRandomLotto(10);

		assertThat(lottos.getLottos().size()).isEqualTo(13);
	}
}
