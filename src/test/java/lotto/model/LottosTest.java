package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottosTest {

	@ParameterizedTest
	@DisplayName("로또게임들을 등록하면 게임에 관한 내용이 반환된다.")
	@CsvSource(value = {"1,2,3,4,5,6", "1,3,5,7,9,11", "2,4,8,16,32,45"})
	public void createLottoGames(int value1, int value2, int value3, int value4, int value5, int value6) {
		List<Lotto> lottos = new ArrayList<>();
		lottos.add(getLottoGame(value1, value2, value3, value4, value5, value6));
		Lottos result = new Lottos(lottos);

		assertThat(result.getLottos().size()).isEqualTo(1);
		List<LottoNumber> lottoNumbers = result.getLottos().get(0).getLottoNumbers();
		for (LottoNumber lottoNumber : lottoNumbers) {
			System.out.println(lottoNumber);
		}
		assertThat(result.getLottos().get(0).getLottoNumbers()).containsExactly(new LottoNumber(value1),
			new LottoNumber(value2), new LottoNumber(value3), new LottoNumber(value4), new LottoNumber(value5),
			new LottoNumber(value6));
	}

	private Lotto getLottoGame(Integer... values) {
		List<LottoNumber> lottoNumbers = new ArrayList<>();
		for (Integer value : values) {
			lottoNumbers.add(new LottoNumber(value));
		}
		return new Lotto(lottoNumbers);
	}
}