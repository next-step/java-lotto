package lotto;

import static lotto.Winner.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

	@Test
	@DisplayName("로또 생성 성공")
	void lotto_생성_성공() {
		assertDoesNotThrow(() -> new Lotto("1,2,3,4,5,6"));
	}

	@Test
	@DisplayName("로또 생성 실패")
	void lotto_생성_실패() {
		assertThrows(InvalidNumberSetException.class, () -> new Lotto("1,2,3,4,5")); // 숫자가 5개
		assertThrows(InvalidNumberSetException.class, () -> new Lotto("1,2,3,4,5,1")); // 기존과 동일한 숫자 추가
		assertThrows(InvalidNumberSetException.class, () -> new Lotto("1,2,3,4,5,6,7")); // 숫자가 7개
	}

	@Test
	@DisplayName("특정 로또번호가 존재하는지 체크")
	void checkContainsLottoNumber() {
		Lotto lotto = new Lotto("1,2,3,4,5,6");
		LottoNumber exist = LottoNumber.valueOf("1");
		LottoNumber notExist = LottoNumber.valueOf("7");
		assertThat(lotto.contains(exist)).isTrue();
		assertThat(lotto.contains(notExist)).isFalse();
	}

	@Test
	@DisplayName("로또 등수 판별")
	void lotto_등수_판별() {
		Lotto lotto1 = new Lotto("1,2,3,4,5,6");

		Lotto winningLotto1 = new Lotto("1,2,3,4,5,6");
		Lotto winningLotto2 = new Lotto("5,6,7,8,9,10");

		assertThat(lotto1.winningCheck(winningLotto1)).isEqualTo(FIRST_PRIZE);
		assertThat(lotto1.winningCheck(winningLotto2)).isEqualTo(NONE);
	}
}
