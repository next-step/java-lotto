package nextstep.step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoStaticsticTest {
	private LottoPurchase lottoPurchase;
	private String winnerNumbers;
	private LottoStaticstic lottoStaticstic;

	@BeforeEach
	public void before() {
		lottoPurchase = new LottoPurchase(10_000);
		winnerNumbers = "1,2,3,4,5,6";
		lottoStaticstic = new LottoStaticstic(winnerNumbers, lottoPurchase);
	}

	@Test
	@DisplayName("구매한 로또들의 리워드와 로또를 그룹핑한다.")
	public void getLottoRewardMapTest() {
		List<Lotto> mockLottos = mockLottoList(lottoPurchase.getLottoCount(), new HashSet<>(Arrays.asList(1,2,3,7,8,9)));
		Map<LottoReward, List<WinningLotto>> lottoRewardListMap = lottoStaticstic.getLottoRewardMap(mockLottos);
		assertTrue(lottoRewardListMap.containsKey(LottoReward.FOURTH));
	}

	@Test
	@DisplayName("구매금액과 로또당첨금액으로 확률을 구한다.")
	public void calculateWinningProbabilityTest() {
		List<Lotto> mockLottos = mockLottoList(lottoPurchase.getLottoCount(), new HashSet<>(Arrays.asList(1,2,7,8,9,10)));
		Map<LottoReward, List<WinningLotto>> lottoRewardListMap = lottoStaticstic.getLottoRewardMap(mockLottos);
		float stat = lottoStaticstic.calculateWinningProbability(lottoRewardListMap);
		assertThat(stat).isEqualTo(0.0f);
	}


	private List<Lotto> mockLottoList(int lottoCount, Set<Integer> numbers) {
		List<Lotto> lottos = new ArrayList<>();
		IntStream.range(0, lottoCount)
				.forEach(i -> lottos.add(new Lotto(numbers)));
		return lottos;
	}
}
