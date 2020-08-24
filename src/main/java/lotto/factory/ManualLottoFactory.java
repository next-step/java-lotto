package lotto.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import lotto.Lotto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ManualLottoFactory {

	public static Lotto create(String manualLottoNumbersString) {
		return LottoFactory.create(manualLottoNumbersString);
	}


}
