package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

	@Test
	@DisplayName("로또 자동으로 5개 생성시 예외 발생 없음")
	void generateAutoLottos() {
		assertDoesNotThrow(() -> {
			Lottos.generateAutoLottos(5);
		});
	}
}