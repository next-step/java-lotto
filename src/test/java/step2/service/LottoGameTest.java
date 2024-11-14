package step2.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step2.domain.var.LottoConstant.*;
import static step2.service.LottoGame.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.domain.Money;
import step2.dto.LottoPlayResultDto;
import step2.dto.PlayLottoDto;
import step2.exception.MoneyOverLimitException;
import step2.exception.NotEnoughMoneyException;

class LottoGameTest {
	@Test
	@DisplayName("구입 금액 1000원당 1장의 로또를 발급하는지 확인하는 테스트")
	public void lottoBuyTest() {
		String money = Integer.toString(5 * LOTTO_PRICE);
		List<String> emptyList = new ArrayList<>();
		PlayLottoDto playLottoDto = new PlayLottoDto(money, emptyList);

		LottoPlayResultDto dto = LottoGame.playLotto(playLottoDto);

		assertThat(dto.getLottos().size()).isEqualTo(5);
	}

	@Test
	@DisplayName("구입 금액만큼 로또를 발급하는지 이력을 확인하는 테스트")
	public void playLottoTest() {
		final int MANUAL_LOTTO_COUNT = 3;
		final int TOTAL_LOTTO_COUNT = 5;

		String moneyString = Integer.toString(TOTAL_LOTTO_COUNT * LOTTO_PRICE);
		List<String> manualLottoNumber = new ArrayList<>();
		for (int i = 0; i < MANUAL_LOTTO_COUNT; i++) {
			manualLottoNumber.add("1,2,3,4,5,6");
		}
		PlayLottoDto playLottoDto = new PlayLottoDto(moneyString, manualLottoNumber);
		
		LottoPlayResultDto dto = LottoGame.playLotto(playLottoDto);

		assertThat(dto.getLottos().size()).isEqualTo(5);
	}

	@Test
	@DisplayName("구입금액이 1000원으로 떨어지지 않을경우 돈을 거슬러주는 테스트")
	public void getLottoChangeTest() {
		String money = Integer.toString(LOTTO_PRICE + 123);
		List<String> emptyList = new ArrayList<>();
		PlayLottoDto playLottoDto = new PlayLottoDto(money, emptyList);

		LottoPlayResultDto dto = LottoGame.playLotto(playLottoDto);

		assertThat(dto.getChange()).isEqualTo(new Money(123));
	}

	@Test
	@DisplayName("구입 금액이 1000원보다 낮을경우 익셉션을 던지는 테스트")
	public void minMoneyCheckTest() {
		assertThatThrownBy(() -> {
			String money = Integer.toString(LOTTO_PRICE - 1);
			List<String> emptyList = new ArrayList<>();
			PlayLottoDto playLottoDto = new PlayLottoDto(money, emptyList);

			LottoGame.playLotto(playLottoDto);
		}).isInstanceOf(NotEnoughMoneyException.class);
	}

	@Test
	@DisplayName("최대 10만원을 초과할 경우 익셉션을 던지는 테스트")
	public void maxMoneyCheckTest() {
		assertThatThrownBy(() -> {
			String money = Integer.toString(MAX_LOTTO_PURCHASE_AMOUNT + 1000);
			List<String> emptyList = new ArrayList<>();
			PlayLottoDto playLottoDto = new PlayLottoDto(money, emptyList);

			playLotto(playLottoDto);
		}).isInstanceOf(MoneyOverLimitException.class);
	}

	@Test
	@DisplayName("수동 로또번호를 받을경우 수동 로또가 잘 생성되는지 테스트")
	public void manualTest() {
		final int MANUAL_LOTTO_COUNT = 3;
		final int TOTAL_LOTTO_COUNT = 10;

		String moneyString = Integer.toString(TOTAL_LOTTO_COUNT * LOTTO_PRICE);
		List<String> manualLottoNumber = new ArrayList<>();
		for (int i = 0; i < MANUAL_LOTTO_COUNT; i++) {
			manualLottoNumber.add("1,2,3,4,5,6");
		}
		PlayLottoDto playLottoDto = new PlayLottoDto(moneyString, manualLottoNumber);

		LottoPlayResultDto resultDto = playLotto(playLottoDto);

		assertThat(resultDto.getManualLottos().size()).isEqualTo(MANUAL_LOTTO_COUNT);
	}

	@Test
	@DisplayName("돈과 수동 로또번호를 받을경우 나머지 금액이 자동 로또로 잘 생성되는지 테스트")
	public void manualAndAutoTest() {
		final int MANUAL_LOTTO_COUNT = 3;
		final int TOTAL_LOTTO_COUNT = 10;

		String moneyString = Integer.toString(TOTAL_LOTTO_COUNT * LOTTO_PRICE);
		List<String> manualLottoNumber = new ArrayList<>();
		for (int i = 0; i < MANUAL_LOTTO_COUNT; i++) {
			manualLottoNumber.add("1,2,3,4,5,6");
		}
		PlayLottoDto playLottoDto = new PlayLottoDto(moneyString, manualLottoNumber);

		LottoPlayResultDto resultDto = playLotto(playLottoDto);

		assertThat(resultDto.getAutoLottos().size()).isEqualTo(10 - MANUAL_LOTTO_COUNT);
	}
}