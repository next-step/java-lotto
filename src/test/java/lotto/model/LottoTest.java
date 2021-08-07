package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

	@Test
	@DisplayName("숫자로 이루어진 컬렉션을 입력하면 반환한다.")
	public void createLottoGame() {
		Lotto lotto = new Lotto(getLottoNumber(1, 14, 26, 32, 34, 44));

		assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
		assertThat(lotto.getLottoNumbers()).containsExactly(new LottoNumber(1), new LottoNumber(14),
			new LottoNumber(26), new LottoNumber(32), new LottoNumber(34), new LottoNumber(44));
	}

	@Test
	@DisplayName("로또가 빈값이면 예외가 발생한다.")
	public void checkLottoEmpty() {
		assertThrows(IllegalArgumentException.class, () ->
			new Lotto(getLottoNumber())
		);
	}

	@Test
	@DisplayName("로또가 6자리가 이닐시 예외가 발생한다.")
	public void checkLottoSize() {
		assertThrows(IllegalArgumentException.class, () ->
			new Lotto(getLottoNumber(1, 14, 26, 32))
		);
	}

	@Test
	@DisplayName("로또는 같은 숫자가 존재하면 예외가 발생한다.")
	public void checkDuplicateNumber() {
		assertThrows(IllegalArgumentException.class, () ->
			new Lotto(getLottoNumber(1, 14, 26, 32, 1, 14))
		);
	}

	@Test
	@DisplayName("로또는 숫자가 아니면 예외가 발생한다.")
	public void checkNumberType() {
		assertThrows(IllegalArgumentException.class, () ->
			new Lotto("1,!,2,3,4,5")
		);
	}

	private List<LottoNumber> getLottoNumber(Integer... values) {
		List<LottoNumber> lottoNumbers = new ArrayList<>();
		for (Integer value : values) {
			lottoNumbers.add(new LottoNumber(value));
		}
		return lottoNumbers;
	}

}