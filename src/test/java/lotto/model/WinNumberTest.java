package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinNumberTest {

	@DisplayName("보너스볼 번호는 1등 당첨번호에 없는 번호여야한다.")
	@Test
	void bonusNumberNotInOriginWinNumber() {

		LottoNumberSet winNumber = LottoNumberSet.of(new int[]{1, 2, 3, 4, 5, 6});
		LottoNumber bonusNumber = new LottoNumber(6);

		assertThatIllegalArgumentException().isThrownBy(() -> {
			new WinNumber(winNumber, bonusNumber);
		});

	}



}