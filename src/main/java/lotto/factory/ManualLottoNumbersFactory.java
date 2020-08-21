package lotto.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import lotto.LottoNumbers;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ManualLottoNumbersFactory {

	public static LottoNumbers create(String manualLottoNumbersString) {
		return LottoNumbersFactory.create(manualLottoNumbersString);
	}


}
