package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.OutOfLottoCountException;

class LottosTest {

	@ParameterizedTest
	@CsvSource(value = {"0=false", "1=false", "2=true"}, delimiter = '=')
	@DisplayName("수동 구매 + 자동 구매 Lottos 클래스에 등록 후 사이즈 비교")
	void addLottoSuccess(int size, boolean expected) {
		Lottos lottos = Lottos.generateLottos(new LottoCount(5000, 2));

		lottos.addLotto(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
		lottos.addLotto(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));

		assertThat((lottos.getLottos().size() == size)).isEqualTo(expected);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6})
	@DisplayName("구매 카운트 보다 로또 리스트 사이즈가 커지면 예외 발생")
	void lottosSizeThrowException(int count) {
		Lottos lottos = Lottos.generateLottos(new LottoCount(count * 1000, count));

		assertThatExceptionOfType(OutOfLottoCountException.class)
			.isThrownBy(() -> {
				for (int i = 0; i <= count; i++) {
					lottos.addLotto(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
				}
			}).withMessage("로또는 최대 " + count + "장 구매 가능합니다.");
	}
}