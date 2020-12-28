package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {

	private List<Lotto> lottoPackage;
	private Lottos randomLotto;

	@BeforeEach
	void init() {
		randomLotto = Lottos.generateLottos();

		lottoPackage = new ArrayList<>();
	}

	@Test
	@DisplayName("로또s 메뉴얼: 랜덤 로또 생성")
	void initRandomManualLotto() {
		Lottos randomLotto = Lottos.generateLottos();
		randomLotto.addRandomLotto(10);
		assertThat(randomLotto.getLottos().size()).isEqualTo(10);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,6", "1,3,23,34,35,36", "1,3,21,32,33,34", "1,3,23,34,35,36"})
	@DisplayName("로또s 메뉴얼: 유저 입력 로또 생성")
	void initUserManualLotto(String inputLotto) {
		Lottos userLotto = Lottos.generateLottos();
		userLotto.addManualLottos(inputLotto);

		lottoPackage.add(Lotto.generateManualLotto(inputLotto));
		assertThat(userLotto.getLottos()).isSameAs(lottoPackage);
	}
}
