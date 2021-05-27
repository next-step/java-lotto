package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoStore.*;

public class LottoBuyingRequest {

	private static final String INVALID_MANUAL_LOTTO_COUNT_MESSAGE = "로또를 구매할 수 있는 돈이 부족합니다.";

	private final Money money;
	private final ManualLottoNumbers manualLottoNumbers;
	private final int autoLottoCount;

	public LottoBuyingRequest(Money money, ManualLottoNumbers manualLottoNumbers) {
		this.money = money;
		this.manualLottoNumbers = manualLottoNumbers;
		autoLottoCount = validate(totalLottoCount(), manualLottoCount());
	}

	private int totalLottoCount() {
		return money.divide(PRICE);
	}

	private int validate(int total, int manual) {
		int auto = total - manual;

		if (auto < 0) {
			throw new IllegalArgumentException(INVALID_MANUAL_LOTTO_COUNT_MESSAGE);
		}

		return auto;
	}

	public boolean hasAutoLottoRequest() {
		return autoLottoCount > 0;
	}

	public int autoLottoCount() {
		return autoLottoCount;
	}

	public int manualLottoCount() {
		return manualLottoNumbers.count();
	}

	public List<String> manualLottoNumberStrings() {
		List<LottoNumberText> lottoNumberTextList = manualLottoNumbers.toList();
		List<String> lottoNumberStrings = new ArrayList<>();

		for (LottoNumberText lottoNumberText : lottoNumberTextList) {
			lottoNumberStrings.add(lottoNumberText.text());
		}

		return lottoNumberStrings;
	}
}
