package lotto;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;

import lotto.input.InputValidator;

@Getter
public class ManualLottoCount {
	private final int manualLottoCount;

	private ManualLottoCount(int manualLottoCount) {
		this.manualLottoCount = manualLottoCount;
	}

	public static ManualLottoCount of(LottoPayAmounts lottoPayAmounts, String manualLottoCount) {
		validateManualLottoCount(lottoPayAmounts, manualLottoCount);

		return new ManualLottoCount(Integer.parseInt(manualLottoCount));
	}

	public static void validateManualLottoCount(LottoPayAmounts lottoPayAmounts, String manualLottoCountString) {
		if (lottoPayAmounts == null) {
			throw new IllegalArgumentException("로또 구매량이 없습니다.");
		}
		if (StringUtils.isBlank(manualLottoCountString)) {
			throw new IllegalArgumentException("수동으로 구매할 수를 입력하셔야 합니다.");
		}
		if (!InputValidator.isNumber(manualLottoCountString)) {
			throw new IllegalArgumentException("수동으로 구매할 수를 숫자로 입력하셔야 합니다.");
		}
		if (lottoPayAmounts.getCountOfLotto(LottoKiosk.LOTTO_PRICE) < Integer.parseInt(manualLottoCountString)) {
			throw new IllegalArgumentException("수동으로 구매할 수는 로또 구매한 전체 양보다 적어야 합니다.");
		}
	}
}
