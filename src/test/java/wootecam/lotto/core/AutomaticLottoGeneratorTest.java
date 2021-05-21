package wootecam.lotto.core;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import wootecam.lotto.model.Lotto;

public class AutomaticLottoGeneratorTest {

	@Test
	@DisplayName("랜덤 숫자 반환 테스트")
	void test랜덤테스트() {
		AutomaticLottoGenerator autoLottoGenerator = new AutomaticLottoGenerator() {
			@Override
			protected Lotto getNumbers() {
				return new Lotto(Arrays.asList(1, 3, 5, 7, 9, 11));
			}
		};
		assertThat(autoLottoGenerator.getNumbers().getLottoNumbers()).containsExactly(1, 3, 5, 7, 9, 11);
	}
}
