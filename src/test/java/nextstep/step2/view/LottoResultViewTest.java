package nextstep.step2.view;

import nextstep.step2.domain.Lotto;
import nextstep.step2.domain.LottoReward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultViewTest {
	private LottoResultView underTest = new LottoResultView();

	@Test
	@DisplayName("4등 이상을 그룹핑하여 로또개수를 출력한다.")
	public void printLottoStaticsicTest() {
		Map<LottoReward, List<Lotto>> lottoRewardListMap = new HashMap<>();
		lottoRewardListMap.put(LottoReward.FOURTH, Arrays.asList(new Lotto(Arrays.asList(1,2,3,4,5,6))));
		underTest.printLottoStaticsic(lottoRewardListMap);
	}

	@Test
	@DisplayName("지난주 로또번호기반으로 로또 확률값을 소수점2자리까지 출력한다.")
	public void printWinningProbabilityTest() {
		underTest.printWinningProbability(0.12345678f);
		underTest.printWinningProbability(0.23456f);
		underTest.printWinningProbability(0.01111111f);
		underTest.printWinningProbability(0.523456f);
	}
}
