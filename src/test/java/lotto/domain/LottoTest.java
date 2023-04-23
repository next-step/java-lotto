package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {

	private static Stream<Arguments> lottoNumberNoDuplicateProvider() {
		return Stream.of(
			arguments(Arrays.asList(1, 2, 3, 4, 5, 6))
		);
	}

	@DisplayName("숫자를 중복없이 6개 선택한다.")
	@MethodSource("lottoNumberNoDuplicateProvider")
	@ParameterizedTest
	void test1(List<Integer> inputs) {
		Lotto lotto = new Lotto();
		for (Integer number : inputs) {
			lotto.selectLottoNumbers(number);
		}
		assertThat(lotto.selectedNumbersSize()).isEqualTo(6);
	}

	private static Stream<Arguments> lottoNumberDuplicateProvider() {
		return Stream.of(
			arguments(Arrays.asList(1, 2, 2, 4, 5, 6))
		);
	}

	@DisplayName("숫자를 중복있게 6개 선택한다.")
	@MethodSource("lottoNumberDuplicateProvider")
	@ParameterizedTest
	void test2(List<Integer> inputs) {
		Lotto lotto = new Lotto();
		for (Integer number : inputs) {
			lotto.selectLottoNumbers(number);
		}
		assertThat(lotto.selectedNumbersSize()).isEqualTo(5);
	}

	@DisplayName("당첨넘버와 선택한 로또 넘버 간 일치하는 넘버가 몇개인지 계산한다.")
	@Test
	void test3() {
		Lotto lotto = new Lotto();
		for (Integer number : Arrays.asList(1, 3, 5, 14, 22, 45)) {
			lotto.selectLottoNumbers(number);
		}

		assertThat(lotto.winCount(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(3);
	}
}

