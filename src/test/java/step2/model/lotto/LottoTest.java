package step2.model.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import step2.exception.BadRequestException;

class LottoTest {

	@DisplayName("로또 초기화시에 사이즈는 6이다.")
	@Test
	void Given_Lotto_Then_InitToLottoSize() {
		Lotto lotto = new Lotto();

		assertThat(lotto.getNumbers()).hasSize(6);
	}

	@DisplayName("로또 사이즈는 6이다.")
	@Test
	void Given_List_Then_InitLotto() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		Lotto lotto = new Lotto(list);

		assertThat(lotto.getNumbers()).hasSize(6);
	}

	@DisplayName("배열의 요소와 일치하는 개수를 반환한다.")
	@Test
	void Given_List_Then_ReturnMatchCount() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		Lotto lotto = new Lotto(list);
		int matchCount = lotto.getMatchCount(list);

		assertThat(matchCount).isEqualTo(list.size());
	}

	@DisplayName("6이 아닌 개수를 입력하면 예외를 던진다.")
	@ParameterizedTest
	@MethodSource("generateWrongData")
	void Given_NotLottoSize_Then_ThrowException(List<Integer> list) {
		assertThatThrownBy(() -> new Lotto(list)).isInstanceOf(BadRequestException.class);
	}

	static Stream<List<Integer>> generateWrongData() {
		return Stream.of(
			Arrays.asList(1, 2, 3, 4, 5, 6, 7),
			Arrays.asList(1, 2, 3)
		);
	}
}