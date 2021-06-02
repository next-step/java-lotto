package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

	@DisplayName("로또 생성시 중복된 숫자가 전달된 경우, exception이 발생한다.")
	@Test
	void LottoHasSixNumber() {
		List<LottoNumber> numbers = Stream.of(1,2,3,1,2,3).map(LottoNumber::new).collect(Collectors.toList());

		assertThatThrownBy(() -> new Lotto(numbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("중복된 숫자가 포함되어 있습니다.");
	}

	@DisplayName("로또 생성시 6개 숫자가 전달되지 않는 경우, exception이 발생한다.")
	@Test
	void LottoOverSixNumber() {
		List<LottoNumber> numbers = Stream.of(1,2,3,1,2,3,4,5,6).map(LottoNumber::new).collect(Collectors.toList());

		assertThatThrownBy(() -> new Lotto(numbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("로또 숫자가 6개가 아닙니다.");
	}

	@DisplayName("당첨번호와 매칭되는 번호의 갯수에 따라 상금 타입이 반환된다.")
	@ParameterizedTest
	@MethodSource("generateData")
	void matchLotto(List<Integer> lottoNumber, int expected) {
		List<LottoNumber> lottoNumbers = lottoNumber.stream().map(LottoNumber::new).collect(Collectors.toList());
		List<LottoNumber> winningNumbers = Stream.of(1,2,3,4,5,6).map(LottoNumber::new).collect(Collectors.toList());

		WinningLotto winningLotto = new WinningLotto(winningNumbers, new LottoNumber(45));
		LottoPrize lottoPrize = new Lotto(lottoNumbers).compare(winningLotto);
		assertThat(lottoPrize.getMatchCount()).isEqualTo(expected);
	}

	@DisplayName("당첨번호가 5개 매칭 되고, 보너스 번호까지 일치하는 경우, SECOND 상금 타입이 반환된다.")
	@Test
	void matchLottoSecond() {
		List<LottoNumber> lottoNumbers = Stream.of(1,2,3,4,5,7).map(LottoNumber::new).collect(Collectors.toList());
		List<LottoNumber> winningNumbers = Stream.of(1,2,3,4,5,6).map(LottoNumber::new).collect(Collectors.toList());
		LottoNumber bonusNumber = new LottoNumber(7);

		WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
		LottoPrize lottoPrize = new Lotto(lottoNumbers).compare(winningLotto);
		assertThat(lottoPrize).isEqualTo(LottoPrize.SECOND);
	}

	@DisplayName("당첨번호가 5개 매칭 되고, 보너스 번호가 일치하지 않는 경우, THIRD 상금 타입이 반환된다.")
	@Test
	void matchLottoThird() {
		List<LottoNumber> lottoNumbers = Stream.of(1,2,3,4,5,7).map(LottoNumber::new).collect(Collectors.toList());
		List<LottoNumber> winningNumbers = Stream.of(1,2,3,4,5,6).map(LottoNumber::new).collect(Collectors.toList());
		LottoNumber bonusNumber = new LottoNumber(8);

		WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
		LottoPrize lottoPrize = new Lotto(lottoNumbers).compare(winningLotto);
		assertThat(lottoPrize).isEqualTo(LottoPrize.THIRD);
	}

	static Stream<Arguments> generateData() {
		return Stream.of(
			Arguments.of(Arrays.asList(1,2,3,4,5,6), 6),
			Arguments.of(Arrays.asList(1,2,3,4,5,7), 5),
			Arguments.of(Arrays.asList(1,2,3,4,8,9), 4),
			Arguments.of(Arrays.asList(1,2,3,10,8,9), 3),
			Arguments.of(Arrays.asList(1,2,3,10,8,45), 3)
		);
	}
}
