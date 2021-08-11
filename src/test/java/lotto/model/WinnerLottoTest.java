package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerLottoTest {

	@Test
	@DisplayName("당첨로또는 추가 번호를 가지고 있다.")
	public void createBonusNumber(){
		Lotto lotto = new Lotto(getLotto());
		WinnerLotto winnerLotto = new WinnerLotto(lotto,7);
		LottoNumber lottoBonusNumber = winnerLotto.getBonusNumber();

		assertThat(lottoBonusNumber).isEqualTo(new LottoNumber(7));
	}

	@Test
	@DisplayName("당첨로또는 추가 번호와 중복되면 예외가 발생된다..")
	public void checkDuplicationNumber(){
		Lotto lotto = new Lotto(getLotto());
		assertThrows(IllegalArgumentException.class, () ->
			new WinnerLotto(lotto,1)
		);
	}

	private List<LottoNumber> getLotto() {
		List<LottoNumber> lottoNumbers = new ArrayList<>();
		lottoNumbers.add(new LottoNumber(1));
		lottoNumbers.add(new LottoNumber(2));
		lottoNumbers.add(new LottoNumber(3));
		lottoNumbers.add(new LottoNumber(4));
		lottoNumbers.add(new LottoNumber(5));
		lottoNumbers.add(new LottoNumber(6));
		return lottoNumbers;
	}

}