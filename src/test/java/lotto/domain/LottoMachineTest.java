package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoMachineTest {

	@DisplayName("구매한 만큼의 로또를 생성한다.")
	@Test
	void test1() {
		assertThat(new LottoMachine(14000).purchasedCount()).isEqualTo(14);
	}

	@DisplayName("구매한 만큼의 로또를 생성한다. - 예외 케이스")
	@ValueSource(longs = {800, 1400})
	@ParameterizedTest
	void test2(long purchaseAmount) {
		assertThatIllegalArgumentException().isThrownBy(() -> new LottoMachine(purchaseAmount));
	}

	@DisplayName("상금 현황 목록을 작성한다.")
	@Test
	void test8() {
		List<Lotto> lottos = Arrays.asList(
			new Lotto(0), new Lotto(0),
			new Lotto(3), new Lotto(3),
			new Lotto(6)
		);
		LottoMachine lottoMachine = new LottoMachine(lottos);
		List<PrizeSituation> prizeSituations = lottoMachine.makePrizeSituations();

		assertThat(prizeSituations).containsExactlyInAnyOrder(
			new PrizeSituation(PrizeType.THREE, 2), new PrizeSituation(PrizeType.FOUR, 0),
			new PrizeSituation(PrizeType.FIVE, 0), new PrizeSituation(PrizeType.FIVE_BONUS, 0),
			new PrizeSituation(PrizeType.SIX, 1)
		);
	}

	@DisplayName("상금 현황 목록을 점수순으로 오름차순 정렬한다.")
	@Test
	void test9() {
		List<PrizeSituation> prizeSituations = Arrays.asList(
			new PrizeSituation(PrizeType.FOUR, 0), new PrizeSituation(PrizeType.SIX, 1),
			new PrizeSituation(PrizeType.FIVE, 0), new PrizeSituation(PrizeType.THREE, 2)
		);
		LottoMachine lottoMachine = new LottoMachine(1000);
		List<PrizeSituation> sortedPrizeSituations = lottoMachine.sortInOrderScore(prizeSituations);
		assertThat(sortedPrizeSituations).containsExactly(
			new PrizeSituation(PrizeType.THREE, 2), new PrizeSituation(PrizeType.FOUR, 0),
			new PrizeSituation(PrizeType.FIVE, 0), new PrizeSituation(PrizeType.SIX, 1)
		);
	}

	@DisplayName("당첨 번호 목록에 보너스 번호가 포함되는 경우 - 예외 케이스")
	@Test
	void test10() {
		LottoMachine lottoMachine = new LottoMachine(1000);
		assertThatIllegalArgumentException().isThrownBy(() -> lottoMachine.calculateScore(new WinNumbers("1, 2, 3, 4, 5, 6"), new LottoNumber(1)));
	}
}
