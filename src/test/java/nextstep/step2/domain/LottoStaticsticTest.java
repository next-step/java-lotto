package nextstep.step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoStaticsticTest {
	private LottoPurchase lottoPurchase;
	private String winnerNumbers;
	private LottoStaticstic lottoStaticstic;
	private LottoNumber bonusNumber;

	@BeforeEach
	public void before() {
		lottoPurchase = new LottoPurchase(10_000);
		winnerNumbers = "1,2,3,4,5,6";
		bonusNumber = LottoNumber.of(7);
		lottoStaticstic = new LottoStaticstic(winnerNumbers, lottoPurchase, bonusNumber);
	}

	@Test
	@DisplayName("구매한 로또들의 리워드와 로또를 그룹핑한다.")
	public void getLottoRewardMapTest() {
		List<Lotto> mockLottos = mockLottoList(lottoPurchase.getLottoCount(), MockLotto.mockLotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
		Map<LottoReward, List<Lotto>> lottoRewardListMap = lottoStaticstic.getLottoRewardMap(mockLottos);
		assertTrue(lottoRewardListMap.containsKey(LottoReward.FOURTH));
	}

	@Test
	@DisplayName("구매금액과 로또당첨금액으로 확률을 구한다.")
	public void calculateWinningProbabilityTest() {
		List<Lotto> mockLottos = mockLottoList(lottoPurchase.getLottoCount(), MockLotto.mockLotto(Arrays.asList(1,2,7,8,9,10)));
		Map<LottoReward, List<Lotto>> lottoRewardListMap = lottoStaticstic.getLottoRewardMap(mockLottos);
		float stat = lottoStaticstic.calculateWinningProbability(lottoRewardListMap);
		assertThat(stat).isEqualTo(0.0f);
	}

	@Test
	@DisplayName("구입한 로또 중에 1등이 없어도 결과맵에 추가한다.")
	public void addLottoEmptyRewardTest() {
		Map<LottoReward, List<Lotto>> lottoRewardListMap = new HashMap<>();
		lottoRewardListMap.put(LottoReward.FOURTH, Arrays.asList(MockLotto.mockLotto(Arrays.asList(1,2,3,4,15,16))));
		//이미 리워드맵에 있던 로또
		assertThat(lottoRewardListMap.containsKey(LottoReward.FOURTH));
		assertThat(lottoRewardListMap.get(LottoReward.FOURTH)).hasSize(1);
		//당첨통계에 없지만 출력하기 위해 추가해줌
		lottoStaticstic.addLottoEmptyReward(lottoRewardListMap);
		assertThat(lottoRewardListMap.containsKey(LottoReward.FIRST));
		assertThat(lottoRewardListMap.get(LottoReward.FIRST)).hasSize(0);
	}

	private List<Lotto> mockLottoList(int lottoCount, Lotto lotto) {
		List<Lotto> lottos = new ArrayList<>();
		IntStream.range(0, lottoCount)
				.forEach(i -> lottos.add(lotto));
		return lottos;
	}
}
