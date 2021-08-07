package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

	@Test
	@DisplayName("숫자로 이루어진 컬렉션을 입력하면 반환한다.")
	public void createLottoGame() {
		List<LottoNumber> lottoNumbers = new ArrayList<>();
		lottoNumbers.add(new LottoNumber(1));
		lottoNumbers.add(new LottoNumber(13));
		lottoNumbers.add(new LottoNumber(26));
		lottoNumbers.add(new LottoNumber(32));

		Lotto lotto = new Lotto(lottoNumbers);

		assertThat(lotto.getLottoNumbers().size()).isEqualTo(4);
		assertThat(lotto.getLottoNumbers()).containsExactly(new LottoNumber(1), new LottoNumber(13), new LottoNumber(26), new LottoNumber(32));
	}

}