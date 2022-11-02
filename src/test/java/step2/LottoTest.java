package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.model.Lotto.randomLotto;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.model.Lotto;

public class LottoTest {

	@Test
	@DisplayName("로또 한세트(숫자 6개)를 만든다")
	void 로또_한세트_테스트() {
		Lotto.handLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		assertThat(randomLotto()
			.getLotto()
			.size())
			.isEqualTo(6);
	}

}