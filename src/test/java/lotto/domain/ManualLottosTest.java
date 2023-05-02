package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ManualLottosTest {

	@DisplayName("수동 로또를 만든다.")
	@Test
	void test1() {
		List<String> inputs = Arrays.asList(
			"1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12"
		);
		ManualLottos manualLottos = new ManualLottos(inputs);
		assertThat(manualLottos.getManualLottos()).hasSize(2);
		assertThat(manualLottos.getManualLottos()).containsExactly(
			new Lotto(1, 2, 3, 4, 5, 6),
			new Lotto(7, 8, 9, 10, 11, 12)
		);
	}
}
