package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

	@Test
	@DisplayName("로또 객체 생성시 정렬 테스트")
	void makeLottoTest() {
		List<Integer> lottoNumbers = List.of(20, 32, 44, 30, 1, 2);
		LottoNumbers lotto = new LottoNumbers(lottoNumbers);
		assertThat(lotto.getLottoNumbers().get(0).getLottoNumber()).isEqualTo(1);
	}

	@Test
	@DisplayName("당첨번호와 갖고있는 로또번호가 일치 테스트")
	void lottoNumberMatchTest() {
		List<Integer> lottoNumbers = List.of(20, 32, 44, 30, 1, 2);
		List<Integer> winningNumber = List.of(20, 3, 44, 45, 1, 2);
		LottoNumbers lotto = new LottoNumbers(lottoNumbers);
		int count = lotto.getCountOfMatchLottoNumber(new LottoNumbers(winningNumber));
		assertThat(count).isEqualTo(4);
	}

	@Test
	@DisplayName("로또 당첨 개수가 5개일 때, 보너스 볼까지 일치하면 2등 테스트")
	void lottoNumberAndBonusNumberMatchTest() {
		LottoRank lottoRank = LottoRank.findLottoRankByLottoCount(5, true);
		assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
	}

}
