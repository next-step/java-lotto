package step2.service;

import static step2.domain.LottoShuffleManager.*;
import static step2.domain.var.LottoConstant.*;

import java.util.ArrayList;
import java.util.List;

import step2.domain.Lotto;
import step2.domain.LottoNumber;
import step2.domain.LottoStatistics;
import step2.domain.Money;
import step2.domain.WinningNumber;
import step2.dto.LottoPlayResultDto;
import step2.dto.PlayLottoDto;

public class LottoGame {

	public static LottoPlayResultDto playLotto(PlayLottoDto playLottoDto) {
		Money money = new Money(playLottoDto.getMoneyString());
		money.checkMaxMoney(MAX_LOTTO_PURCHASE_AMOUNT);

		List<Lotto> manualLottos = buyManualLotto(playLottoDto.getLottoStringList());
		Money change = money.pay(manualLottos.size() * LOTTO_PRICE);

		List<Lotto> autoLottos = buyAutoLotto(change);
		change = change.pay(autoLottos.size() * LOTTO_PRICE);

		return new LottoPlayResultDto(manualLottos, autoLottos, change);
	}

	public static LottoStatistics getLottoStast(List<Lotto> lastWeekLottos, String winningSixNumbers,
		String bonusNumber) {
		WinningNumber winningNumber = new WinningNumber(winningSixNumbers, bonusNumber);

		return new LottoStatistics(lastWeekLottos, winningNumber);
	}

	private static List<Lotto> buyAutoLotto(Money money) {
		int amount = money.getPurchasableCount(LOTTO_PRICE);
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			lottos.add(new Lotto(shuffleSixNumbers()));
		}
		return lottos;
	}

	private static List<Lotto> buyManualLotto(List<String> manualLottoStringList) {
		List<Lotto> manualLottos = new ArrayList<>();
		for (String lottoString : manualLottoStringList) {
			manualLottos.add(new Lotto(LottoNumber.asList(lottoString)));
		}
		return manualLottos;
	}
}
