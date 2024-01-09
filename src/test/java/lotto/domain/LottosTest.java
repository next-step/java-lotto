package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class LottosTest {
	List<Lotto> lottoList;
	Lottos lottos;

	@BeforeEach
	void create() {
		lottoList = new ArrayList<>();
		Lotto lotto1 = Lotto.of("1, 2, 3, 4, 5, 6");
		Lotto lotto2 = Lotto.of("7, 8, 9, 10, 11, 12");
		lottoList.add(lotto1);
		lottoList.add(lotto2);
		lottos = new Lottos();
		lottos.addAll(lottoList);
	}

	@Test
	@DisplayName("수동으로 로또를 추가하는 경우")
	void 수동으로_로또를_추가하는_메서드() {
		List<String> stringLottos = new ArrayList<>();
		stringLottos.add("21, 22, 23, 24, 25, 26");
		lottos.addManualLotto(stringLottos);
		Lotto expectingResult = Lotto.of("21, 22, 23, 24, 25, 26");

		assertThat(lottos.lottos()).contains(expectingResult);
	}

	@Test
	@DisplayName("자동으로 로또를 추가하는 경우")
	void 자동으로_로또를_추가하는_메서드() {
		int numberOfLotto = 3;
		lottos.addAutoLotto(numberOfLotto);

		assertThat(lottos.lottos().size() == 5).isTrue();
	}

	@Test
	@DisplayName("전체 로또 리스트와 당첨 번호를 비교하여 랭크 개수를 센다")
	void 랭크_개수_세기() {
		WinningLotto winningLotto = new WinningLotto(Lotto.of("1, 2, 3, 4, 5, 6"), LottoNumber.of(7));
		LottoResult lottoResult = lottos.updateRankCount(winningLotto);
		int expectingResult = 1;

		assertThat(lottoResult.lottoResultMap().get(Rank.RANK1)).isEqualTo(expectingResult);
	}
}
