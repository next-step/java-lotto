package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottosTest {

	@ParameterizedTest
	@CsvSource(value = {"0=false", "1=false", "2=true"}, delimiter = '=')
	@DisplayName("수동 구매 + 자동 구매 Lottos 클래스에 등록 후 사이즈 비교")
	void addLottoSuccess(int size, boolean expected) {
		Lottos lottos = Lottos.generateLottos(new LottoCount(5000));

		lottos.addManualLotto(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
		lottos.addAutoLotto();

		assertThat((lottos.getLottos().size() == size)).isEqualTo(expected);
	}
}