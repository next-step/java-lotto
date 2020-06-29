package study2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study2.domain.Lotto;
import study2.domain.Lottos;
import study2.domain.Ranking;
import study2.domain.Ranking.Rank;

class RankingTest {

	Ranking ranking = new Ranking();
	List<Integer> lottolist = Arrays.asList(25, 1, 2, 3, 7, 6);
	int count = 0;
	
	@Test
	@DisplayName("3등이 1개 일치하는지 테스트")
	void 삼등이_한개_일치하는지_테스트() {

		Ranking rank = new Ranking();
		List<Lotto> lottos = new ArrayList<>();
		List<Integer> lottonum = Arrays.asList(1, 2, 3, 9, 10);

		Lotto lotto = new Lotto(lottonum);
		lottos.add(lotto);

		// TODO : int[] nums = Arrays.stream(winNumber).mapToInt(Integer::parseInt).toArray();
		
		Map<Rank, Integer> matchNumber = ranking.matchNumber(lottos, lottolist, 0);
	
		assertThat(matchNumber.get(Rank.THREEMATCH)).isEqualTo(1);
	}

	@Test
	@DisplayName("5개를 구입하고 1등당첨되면 수익률은 사십만입니다.")
	void 다섯개_로또사고_일등당첨되면_개이득() {
		int 전체상금의가격 = 2000000000;
		int 구입한_로또개수 = 5;
		int 로또_한장의_가격 = 1000;
		assertThat(전체상금의가격/ (구입한_로또개수 * 로또_한장의_가격)).isEqualTo(400000);
		
	}

}
