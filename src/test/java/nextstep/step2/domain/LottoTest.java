package nextstep.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LottoTest {
	@Test
	@DisplayName("로또 번호는 1~45 사이의 수이다.")
	public void getLottoNumbersTest() {
		Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
		assertThat(lotto.getNumbers()).hasSize(6);
		assertAll(() -> assertFalse(lotto.getNumbers().contains(0)),
				() -> assertFalse(lotto.getNumbers().contains(46)));
	}
}
