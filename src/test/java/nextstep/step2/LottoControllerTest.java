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
		assertTrue(manualLottoList.get(0).getNumbers().contains(LottoNumber.of(1)));
		assertTrue(manualLottoList.get(0).getNumbers().contains(LottoNumber.of(2)));
		assertTrue(manualLottoList.get(0).getNumbers().contains(LottoNumber.of(3)));
		assertTrue(manualLottoList.get(0).getNumbers().contains(LottoNumber.of(13)));
		assertTrue(manualLottoList.get(0).getNumbers().contains(LottoNumber.of(14)));
		assertTrue(manualLottoList.get(0).getNumbers().contains(LottoNumber.of(15)));

		assertTrue(manualLottoList.get(1).getNumbers().contains(LottoNumber.of(20)));
		assertTrue(manualLottoList.get(1).getNumbers().contains(LottoNumber.of(21)));
		assertTrue(manualLottoList.get(1).getNumbers().contains(LottoNumber.of(22)));
		assertTrue(manualLottoList.get(1).getNumbers().contains(LottoNumber.of(23)));
		assertTrue(manualLottoList.get(1).getNumbers().contains(LottoNumber.of(24)));
		assertTrue(manualLottoList.get(1).getNumbers().contains(LottoNumber.of(25)));

		assertTrue(manualLottoList.get(2).getNumbers().contains(LottoNumber.of(30)));
		assertTrue(manualLottoList.get(2).getNumbers().contains(LottoNumber.of(31)));
		assertTrue(manualLottoList.get(2).getNumbers().contains(LottoNumber.of(32)));
		assertTrue(manualLottoList.get(2).getNumbers().contains(LottoNumber.of(33)));
		assertTrue(manualLottoList.get(2).getNumbers().contains(LottoNumber.of(34)));
		assertTrue(manualLottoList.get(2).getNumbers().contains(LottoNumber.of(35)));
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
		Lottos lottos = Lottos.mergeLottos(manualLottos, 3);
		assertThat(lottos.getLottos()).hasSize(6);
		assertThat(lottos.getLottos().get(0).getNumbers()).isEqualTo(Lotto.of("1,2,3,13,14,15").getNumbers());

	}
}
