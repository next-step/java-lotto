package nextstep.step2.view;

import nextstep.step2.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultViewTest {
	private LottoResultView underTest = new LottoResultView();

	@Test
	@DisplayName("4등 이상을 그룹핑하여 로또개수를 출력한다.")
	public void printLottoStaticsicTest() {
		Lotto lastWeekLotto = Lotto.of("1,2,3,4,5,6");
		Map<LottoReward, List<Lotto>> lottoRewardListMap = new HashMap<>();
		WinningLotto winningLotto = new WinningLotto(lastWeekLotto, LottoNumber.of(7));
		List<Lotto> lottos = Arrays.asList(Lotto.of("1,2,3,14,15,16"),
				Lotto.of("1,2,3,4,15,16"),
				Lotto.of("1,2,3,4,5,16"),
				Lotto.of("1,2,3,4,5,7"),
				Lotto.of("1,2,3,4,5,6"));
		lottos.forEach(lotto -> lotto.setLottoReward(winningLotto.getLottoReward(lotto)));
		lottoRewardListMap.put(LottoReward.FIFTH, Arrays.asList(lottos.get(0)));
		lottoRewardListMap.put(LottoReward.FOURTH, Arrays.asList(lottos.get(1)));
		lottoRewardListMap.put(LottoReward.THIRD, Arrays.asList(lottos.get(2)));
		lottoRewardListMap.put(LottoReward.SECOND, Arrays.asList(lottos.get(3)));
		lottoRewardListMap.put(LottoReward.FIRST, Arrays.asList(lottos.get(4)));
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

	@Test
	@DisplayName("로또 2등은 메시지가 다르다.")
	public void getPrintLottoStatisticsMessageTest() {
		assertThat(underTest.getPrintLottoStatisticsMessage(LottoReward.FIRST)).isEqualTo("%d개 일치 (%d원)- %d개");
		assertThat(underTest.getPrintLottoStatisticsMessage(LottoReward.SECOND)).isEqualTo("%d개 일치, 보너스 볼 일치(%d원)- %d개");
		assertThat(underTest.getPrintLottoStatisticsMessage(LottoReward.THIRD)).isEqualTo("%d개 일치 (%d원)- %d개");
	}
}
