package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.utils.LottoGenerator;

public class LottoPurchaseHistoryTest {

	@Test
	@DisplayName("구매 이력 생성 테스트")
	public void createLottoPurchaseHistory() {
		Lottos autoLottos = new Lottos();
		autoLottos.addLotto(LottoGenerator.generate());
		autoLottos.addLotto(LottoGenerator.generate());
		autoLottos.addLotto(LottoGenerator.generate());
		autoLottos.addLotto(LottoGenerator.generate());
		autoLottos.addLotto(LottoGenerator.generate());
		Lottos manualLottos = new Lottos();
		manualLottos.addLotto(LottoGenerator.generate());
		manualLottos.addLotto(LottoGenerator.generate());
		manualLottos.addLotto(LottoGenerator.generate());
		LottoPurchaseHistory lottoPurchaseHistory = new LottoPurchaseHistory();
		lottoPurchaseHistory.setAutoLottos(autoLottos);
		lottoPurchaseHistory.setManualLottos(manualLottos);
		assertThat(lottoPurchaseHistory.getManualLottoCount()).isEqualTo(3);
		assertThat(lottoPurchaseHistory.getAutoLottoCount()).isEqualTo(5);
	}
}
