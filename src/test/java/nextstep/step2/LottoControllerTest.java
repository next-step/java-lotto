package nextstep.step2;

import nextstep.step2.domain.*;
import nextstep.step2.view.LottoResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoControllerTest {
	private LottoController underTest = new LottoController();

	@Test
	@DisplayName("로또를 사고 지난주 당첨번호로 당첨통계를 구한다.")
	public void startLottoGameTest() {
		LottoPurchase lottoPurchase = new LottoPurchase(10_000);
		LottoResultView resultView = new LottoResultView();
		LottoNumber bonusNumber = LottoNumber.of(7);
		LottoCount lottoCount = new LottoCount(1, lottoPurchase.getLottoCount());
		String manualLottos = "1,2,3,13,14,15:20,21,22,23,24,25";
		Lottos autoLottos = underTest.startLottoGameGetLottos(lottoCount, manualLottos);
		LottoStaticstic lottoStaticstic = new LottoStaticstic("1,2,3,4,5,6", lottoPurchase, bonusNumber);
		underTest.printLottoStaticsic(lottoStaticstic, autoLottos);
	}

	@Test
	@DisplayName("수동로또를 구한다")
	public void purchaseManualLottosTest() {
		String manualLottos = "1,2,3,13,14,15:20,21,22,23,24,25:30,31,32,33,34,35";
		List<Lotto> manualLottoList = Lottos.purchaseManualLottos(manualLottos);
		assertTrue(manualLottoList.get(0).getNumbers().contains(new LottoNumber(1)));
		assertTrue(manualLottoList.get(1).getNumbers().contains(new LottoNumber(20)));
		assertTrue(manualLottoList.get(2).getNumbers().contains(new LottoNumber(30)));
	}

	@Test
	@DisplayName("자동로또를 구한다.")
	public void purchaseAutoLottosTest() {
		List<Lotto> autoLottoList = Lottos.purchaseAutoLottos(2);
		assertThat(autoLottoList).hasSize(2);
	}

	@Test
	@DisplayName("수동과 자동으로 구입한 로또를 합친다.")
	public void mergeLottosTest() {
		String manualLottos = "1,2,3,13,14,15:20,21,22,23,24,25:30,31,32,33,34,35";
//		List<Lotto> manualLottoList = Lottos.purchaseManualLottos(manualLottos);
//		List<Lotto> autoLottoList = Lottos.purchaseAutoLottos(3);
		Lottos lottos = Lottos.mergeLottos(manualLottos, 3);
		assertThat(lottos.getLottos()).hasSize(6);
		assertThat(lottos.getLottos().get(0).getNumbers()).isEqualTo(Lotto.of("1,2,3,13,14,15").getNumbers());

	}
}
