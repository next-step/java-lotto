package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

	private List<Lotto> lottoPackage;

	@BeforeEach
	void init() {
		lottoPackage = new ArrayList<>();
		lottoPackage.add(Lotto.generateLotto("1,2,3,4,5,6"));
		lottoPackage.add(Lotto.generateLotto("1,3,23,34,35,36"));
		lottoPackage.add(Lotto.generateLotto("1,3,21,32,33,34"));
		lottoPackage.add(Lotto.generateLotto("1,3,23,34,35,36"));
	}

	@Test
	@DisplayName("로또 메뉴얼: 랜덤 로또 생성")
	void initRandomManualLotto() {
		Lottos randomLotto = new Lottos(10);
		assertThat(randomLotto.getLottos().size()).isEqualTo(10);
	}

	@Test
	@DisplayName("로또 메뉴얼: 유저 로또 생성")
	void initUserManualLotto() {
		Lottos userLotto = new Lottos(lottoPackage);
		assertThat(userLotto.getLottos()).isSameAs(lottoPackage);
	}
}
