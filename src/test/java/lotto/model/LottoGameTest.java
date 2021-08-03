package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

	@Test
	@DisplayName("숫자로 이루어진 컬렉션을 입력하면 반환한다.")
	public void createLottoGame(){
		List<Integer> lottoNumbers = new ArrayList<>();
		lottoNumbers.add(1);
		lottoNumbers.add(13);
		lottoNumbers.add(26);
		lottoNumbers.add(32);

		LottoGame lottoGame = new LottoGame(lottoNumbers);

		assertThat(lottoGame.getLottoGame().size()).isEqualTo(4);
		assertThat(lottoGame.getLottoGame()).containsExactly(1,13,26,32);
	}

}