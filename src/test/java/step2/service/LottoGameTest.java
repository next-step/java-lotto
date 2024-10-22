package step2.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step2.domain.var.LottoConstant.*;
import static step2.service.LottoGame.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.domain.Lotto;
import step2.domain.LottoStast;
import step2.domain.Money;
import step2.domain.var.LottoPrize;
import step2.dto.LottoPlayResultDto;
import step2.exception.MoneyOverLimitException;
import step2.exception.NotEnoughMoneyException;

class LottoGameTest {
	@Test
	@DisplayName("구입 금액 1000원당 1장의 로또를 발급하는지 확인하는 테스트")
	public void lottoBuyTest() {
		Money money = new Money(5 * LOTTO_PRICE);
		LottoPlayResultDto dto = LottoGame.playLotto(money);
		assertThat(dto.getLottos().size()).isEqualTo(5);
	}

	@Test
	@DisplayName("구입 금액만큼 자동으로 발급하는지 이력을 확인하는 테스트")
	public void playLottoTest() {
		Money money = new Money(5 * LOTTO_PRICE);
		LottoPlayResultDto dto = LottoGame.playLotto(money);
		assertThat(dto.getLottos().size()).isEqualTo(5);
	}

	@Test
	@DisplayName("로또 번호를 입력받아서 1등 당첨됐을 때 당첨 통계 정보를 체크하는 테스트")
	public void getLottoStastTest() {
		Money money = new Money(LOTTO_PRICE);
		LottoPlayResultDto dto = LottoGame.playLotto(money);
		List<Lotto> lottos = dto.getLottos();
		LottoStast result = new LottoStast(lottos, lottos.get(0).getLottoNumbers());
		assertThat(result.getFirstWinnerCount()).isEqualTo(1);
	}

	@Test
	@DisplayName("1등 당첨됐을 때 수익률을 체크하는 테스트")
	public void getLottoProfitRatio() {
		Money money = new Money(LOTTO_PRICE);
		LottoPlayResultDto dto = LottoGame.playLotto(money);
		List<Lotto> lottos = dto.getLottos();
		LottoStast result = new LottoStast(lottos, lottos.get(0).getLottoNumbers());
		Integer ratio = (LottoPrize.FIRST_WINNER.getPrize() - LOTTO_PRICE) / LOTTO_PRICE * 100;
		assertThat(result.getProfitRatio()).isEqualTo(ratio);
	}

	@Test
	@DisplayName("구입금액이 1000원으로 떨어지지 않을경우 돈을 거슬러주는 테스트")
	public void getLottoChangeTest() {
		Money money = new Money(LOTTO_PRICE + 500);
		LottoPlayResultDto dto = LottoGame.playLotto(money);
		assertThat(dto.getChange()).isEqualTo(new Money(500));
	}

	@Test
	@DisplayName("구입 금액이 1000원보다 낮을경우 익셉션을 던지는 테스트")
	public void minMoneyCheckTest() {
		assertThatThrownBy(() -> {
			Money money = new Money(LOTTO_PRICE - 100);
			playLotto(money);
		}).isInstanceOf(NotEnoughMoneyException.class);
	}

	@Test
	@DisplayName("최대 10만원을 초과할 경우 익셉션을 던지는 테스트")
	public void maxMoneyCheckTest() {
		assertThatThrownBy(() -> {
			Money money = new Money(MAX_LOTTO_PURCHASE_AMOUNT + 1000);
			playLotto(money);
		}).isInstanceOf(MoneyOverLimitException.class);
	}
}