package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

	@DisplayName("로또는 6개의 번호를 가진다.")
	@Test
	void LottoHasSixNumber() {
		List<LottoNumber> numbers = IntStream.range(1,5)
			.mapToObj(LottoNumber::new).collect(Collectors.toList());

		assertThatThrownBy(() -> new Lotto(numbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("중복된 숫자가 포함되어 있습니다.");
	}

	@DisplayName("당첨번호와 매칭되는 번호의 갯수에 따라 상금 타입이 반환된다.")
	@ParameterizedTest
	@MethodSource("generateData")
	void matchLotto(List<Integer> lottoNumber, int expected) {
		List<LottoNumber> lottoNumbers = lottoNumber.stream().map(LottoNumber::new).collect(Collectors.toList());
		List<LottoNumber> winningNumbers = Arrays.asList(1,2,3,4,5,6).stream().map(LottoNumber::new).collect(Collectors.toList());

		Lotto winningLotto = new Lotto(winningNumbers);
		LottoPrize lottoPrize = new Lotto(lottoNumbers).compare(winningLotto);
		assertThat(lottoPrize.getMatchCount()).isEqualTo(expected);
	}

	@DisplayName("당첨번호와 동일한 번호의 갯수가 3개 미만인 경우, 상금타입이 0개인 타입을 반환한다.")
	@ParameterizedTest
	@MethodSource("generateDataMatchUnderThree")
	void matchLottoUnderThree(List<Integer> lottoNumber, int expected) {
		List<LottoNumber> lottoNumbers = lottoNumber.stream().map(LottoNumber::new).collect(Collectors.toList());
		List<LottoNumber> winningNumbers = Arrays.asList(1,2,3,4,5,6).stream().map(LottoNumber::new).collect(Collectors.toList());

		Lotto winningLotto = new Lotto(winningNumbers);
		LottoPrize lottoPrize = new Lotto(lottoNumbers).compare(winningLotto);
		assertThat(lottoPrize.getMatchCount()).isEqualTo(expected);
	}

	static Stream<Arguments> generateData() {
		return Stream.of(
			Arguments.of(Arrays.asList(1,2,3,4,5,6), 6),
			Arguments.of(Arrays.asList(1,2,3,4,5,7), 5),
			Arguments.of(Arrays.asList(1,2,3,4,8,9), 4),
			Arguments.of(Arrays.asList(1,2,3,10,8,9), 3)
		);
	}

	static Stream<Arguments> generateDataMatchUnderThree() {
		return Stream.of(
			Arguments.of(Arrays.asList(1,2,11,10,8,9), 0),
			Arguments.of(Arrays.asList(1,12,11,10,8,9), 0),
			Arguments.of(Arrays.asList(13,12,11,10,8,9), 0)
		);
	}
}
