package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoBallTest {

	@DisplayName("로또 범위 내의 숫자가 입력된 경우 단일 로또볼 생성")
	@ParameterizedTest
	@ValueSource(ints =  { 1, 3, 4, 20, 44, 45})
	void testValidateBall(int ball) {
		LottoBall singleLotto = new LottoBall(ball);
		assertThat(singleLotto.getBall()).isEqualTo(ball);
	}

	@DisplayName("로또 범위 밖의 숫자가 입력된 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(ints =  { -1, 0, 46})
	void testInvalidateBall(int ball) {
		assertThrows(IllegalArgumentException.class, () -> {
			LottoBall singleLotto = new LottoBall(ball);
		});
	}
}
