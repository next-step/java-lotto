package camp.nextcamp.edu.lotto.entity;

import static camp.nextcamp.edu.lotto.exception.UserExceptionMesssage.*;
import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextcamp.edu.lotto.entity.Lotto;
import camp.nextcamp.edu.lotto.entity.LottoNumber;

public class LottoTest {

	private static Set<LottoNumber> getMocking(String input) {
		return Arrays.stream(input.split(","))
			.map(Integer::parseInt)
			.map(LottoNumber::valueOf)
			.collect(Collectors.toSet());
	}

	@ParameterizedTest
	@DisplayName("6개의 숫자로 Lotto 생성")
	@ValueSource(strings = {"1,2,3,4,5,6", "2,3,4,5,6,7"})
	void Lotto_생성(String input) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		// given
		Set<LottoNumber> mock = getMocking(input);

		// when
		Lotto lotto = new Lotto(mock);

		Method method = lotto.getClass()
			.getDeclaredMethod("checkSize", Set.class);
		method.setAccessible(true);

		// then
		assertThat(method.invoke(lotto, mock))
			.isEqualTo(true);
	}

	@ParameterizedTest
	@DisplayName("Lotto 갯수가 6개가 아닌경우")
	@ValueSource(strings = {"1,2,3,4,5", "1,3,4,5"})
	void Lotto_갯수_6개_아닌경우(String input) {
		// given
		Set<LottoNumber> mock = getMocking(input);

		// then
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> new Lotto(mock))
			.withMessageMatching(MAXIUMUM_SIZE.getMessage());
	}

	@ParameterizedTest
	@DisplayName("range에 포함이 안되는경우")
	@ValueSource(strings = {"1,3,4,5,6,100", "1,2,3,90,5,6"})
	void range_error(String input) {
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> new Lotto(getMocking(input)))
			.withMessageMatching("Lotto 는 1~46까지만 입력이 가능합니다.");
	}
}
