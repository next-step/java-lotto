package nextstep;

import nextstep.step2.LottoController;
import nextstep.step2.domain.LottoNumber;
import nextstep.step2.domain.Lotto;
import nextstep.step2.domain.LottoPurchase;
import nextstep.step2.view.LottoResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoControllerTest {
	private LottoController underTest = new LottoController();

	@Test
	@DisplayName("로또를 사고 지난주 당첨번호로 당첨통계를 구한다.")
	public void startLottoGameTest() {
		LottoPurchase lottoPurchase = new LottoPurchase(1_000);
		LottoResultView resultView = new LottoResultView();
		LottoNumber bonusNumber = new LottoNumber(7);
		List<Lotto> autoLottos = underTest.startLottoGameGetLottos(lottoPurchase, resultView);
		underTest.printLottoStaticsic("1,2,3,4,5,6", bonusNumber, lottoPurchase, autoLottos, resultView);
	}
}
