package camp.nextcamp.edu.lotto;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextcamp.edu.lotto.entity.Lotto;

public class LottoTest {

	private static List<Integer> getMocking(String input) {
		return Arrays.stream(input.split(","))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	@ParameterizedTest
	@DisplayName("6개의 숫자로 Lotto 생성")
	@ValueSource(strings = {"1,2,3,4,5,6", "2,3,4,5,6,7"})
	void Lotto_생성(String input) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		// given
		List<Integer> mock = getMocking(input);

		// when
		Lotto lotto = new Lotto(mock);

		Method method = lotto.getClass()
			.getDeclaredMethod("checkSize", List.class);
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
		List<Integer> mock = getMocking(input);

		// then
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> new Lotto(mock))
			.withMessageMatching("Lotto 갯수는 6개 여야됩니다.");
	}
}
