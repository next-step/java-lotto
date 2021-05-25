package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("로또결과 테스트")
public class LottoResultsTest {

	@Test
	@DisplayName("구매한 로또의 당첨 결과를 구하는 테스트")
	void match() {
		Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);

		List<Lotto> lottoList = new ArrayList<>();
		lottoList.add(new Lotto(1, 2, 3, 4, 5, 6)); //6개
		lottoList.add(new Lotto(1, 2, 3, 4, 5, 10)); //5개
		lottoList.add(new Lotto(1, 2, 3, 4, 9, 10)); //4개
		lottoList.add(new Lotto(1, 2, 3, 8, 9, 10)); //3개
		lottoList.add(new Lotto(1, 2, 7, 8, 9, 10)); //2개

		Lottos lottos = new Lottos(lottoList);
		LottoResults lottoResults = lottos.match(winningLotto);
		Assertions.assertThat(lottoResults.findRankCount(Rank.FIRST)).isEqualTo(1);
	}

}
