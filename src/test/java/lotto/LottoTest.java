package lotto;

import static lotto.Winner.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LottoTest {

	@Test
	void lotto_생성_성공() {
		assertDoesNotThrow(() -> new Lotto("1,2,3,4,5,6"));
	}

	@Test
	void lotto_생성_실패() {
		assertThrows(RuntimeException.class, () -> new Lotto("1,2,3,4,5")); // 숫자가 5개
		assertThrows(RuntimeException.class, () -> new Lotto("1,2,3,4,5,1")); // 기존과 동일한 숫자 추가
		assertThrows(RuntimeException.class, () -> new Lotto("1,2,3,4,5,6,6")); // distinct 숫자 갯수는 6이나, 숫자는 7
	}

	@Test
	void lotto_등수_판별() {
		Lotto lotto1 = new Lotto("1,2,3,4,5,6");

		Lotto winningLotto1 = new Lotto("1,2,3,4,5,6");
		Lotto winningLotto2 = new Lotto("5,6,7,8,9,10");

		assertThat(lotto1.winningCheck(winningLotto1)).isEqualTo(FIRST_PRIZE);
		assertThat(lotto1.winningCheck(winningLotto2)).isEqualTo(NONE);
	}
}
