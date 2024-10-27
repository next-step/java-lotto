package step2.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.domain.var.LottoPrize;

class LottoStastTest {
	private LottoStast ONE_BUY_FIRST_PRIZE;

	@BeforeEach
	void setUp() {
		// 1개 사서 1등 하나 당첨된 경우
		List<LottoNumber> winNumbers = LottoNumber.listFromString("1, 2, 3, 4, 5, 6");
		Lotto lotto = new Lotto(winNumbers);
		List<Lotto> lottos = new ArrayList<>();
		lottos.add(lotto);
		ONE_BUY_FIRST_PRIZE = new LottoStast(lottos, winNumbers);
	}

	@Test
	@DisplayName("당첨됐을 때 당첨 통계 정보를 체크하는 테스트")
	public void getLottoStastTest() {
		assertThat(ONE_BUY_FIRST_PRIZE.getWinnerCount(LottoPrize.FIRST_WINNER))
			.isEqualTo(1);
	}

	@Test
	@DisplayName("1등 당첨됐을 때 수익률을 체크하는 테스트")
	public void getLottoProfitRatio() {
		assertThat(ONE_BUY_FIRST_PRIZE.getProfitRatio())
			.isEqualTo(199999900);
	}
}