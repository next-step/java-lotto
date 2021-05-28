package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.utils.LottoGenerator;

public class LottosTest {

	@Test
	@DisplayName("복수의 로또 생성 테스트")
	public void createLottos() {
		Lottos lottos = new Lottos();
		assertThat(lottos).isNotNull();
	}

	@Test
	@DisplayName("복수의 로또에 추가 테스트")
	public void addLottos() {
		Lottos lottos = new Lottos();
		lottos.addLotto(LottoGenerator.generate());
		lottos.addLotto(LottoGenerator.generate());
		lottos.addLotto(LottoGenerator.generate());
		assertThat(lottos.getSize()).isEqualTo(3);
	}

	@Test
	@DisplayName("복수의 로또들의 복수 로또를 추가 테스트")
	public void addAllLottos() {
		Lottos lottos = new Lottos();
		lottos.addLotto(LottoGenerator.generate());
		lottos.addLotto(LottoGenerator.generate());
		lottos.addLotto(LottoGenerator.generate());
		Lottos addForLottos = new Lottos();
		addForLottos.addLotto(LottoGenerator.generate());
		addForLottos.addLotto(LottoGenerator.generate());
		addForLottos.addLotto(LottoGenerator.generate());
		lottos.addAllLottos(addForLottos);
		assertThat(lottos.getSize()).isEqualTo(6);
	}

}
