package lottomanual.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

	@Test
	@DisplayName("로또는 6개의 번호를 가진다.")
	void lotto_has_6_numbers() throws Exception {
		//given
		Set<LottoNumber> defaultNumbers = new TreeSet<LottoNumber>(
				Arrays.asList(
						LottoNumber.valueOf(1),
						LottoNumber.valueOf(2),
						LottoNumber.valueOf(3),
						LottoNumber.valueOf(4),
						LottoNumber.valueOf(5),
						LottoNumber.valueOf(6))
		);
		Lotto lotto = new Lotto(defaultNumbers);


		//when
		Set<LottoNumber> numbers = lotto.numbers();

		//then
		assertThat(numbers).hasSize(defaultNumbers.size());
	}


	@Test
	@DisplayName("로또의 번호가 6개가 아닌 경우 예외")
	void lotto_number_size_exception() throws Exception {
		//given
		Set<LottoNumber> defaultNumbers = new TreeSet<LottoNumber>(
				Arrays.asList(
						LottoNumber.valueOf(1),
						LottoNumber.valueOf(2),
						LottoNumber.valueOf(3),
						LottoNumber.valueOf(4),
						LottoNumber.valueOf(5))
		);

		//when

		//then
		assertThatThrownBy(() -> new Lotto(defaultNumbers)).isInstanceOf(LottoNumbersSizeException.class);
	}



	@ParameterizedTest(name = "지난주 당첨 번호와 비교 {index} [{arguments}]")
	@MethodSource("matchNumbers")
	@DisplayName("지난주 당첨 번호와 비교")
	void match_numbers(Set<LottoNumber> lottoNumbers, int matchedCount) throws Exception {
		//given
		Lotto lotto = new Lotto(lottoNumbers);
		Lotto lastWeekNumbers = new Lotto(Arrays.asList(1,2,3,4,5,6));

		//when
		int matchesNumber = lotto.matchingQuantityFrom(lastWeekNumbers);

		//then
		assertThat(matchesNumber).isEqualTo(matchedCount);
	}

	private static Stream<Arguments> matchNumbers() {
		return Stream.of(
			Arguments.of(toSet(Arrays.asList(1,2,3,4,5,6)), 6),
			Arguments.of(toSet(Arrays.asList(1,2,3,4,5,11)), 5),
			Arguments.of(toSet(Arrays.asList(1,2,3,4,11,12)), 4),
			Arguments.of(toSet(Arrays.asList(1,2,3,11,12,13)), 3)
		);
	}



	@ParameterizedTest(name = "보너스 번호 포함여부 {index} [{arguments}]")
	@MethodSource("matchBonusNumber")
	@DisplayName("보너스 번호 포함여부")
	void match_bonus(Set<LottoNumber> lottoNumbers, int bonusNumber, boolean expected) throws Exception {
		//given
		Lotto lotto = new Lotto(lottoNumbers);

		//when
		boolean actual = lotto.contains(LottoNumber.valueOf(bonusNumber));

		//then
		assertThat(actual).isEqualTo(expected);
	}

	private static Stream<Arguments> matchBonusNumber() {
		return Stream.of(
				Arguments.of(toSet(Arrays.asList(1,2,3,4,5,6)), 6, true),
				Arguments.of(toSet(Arrays.asList(1,2,3,4,5,6)), 7, false)
		);
	}

	private static Set<LottoNumber> toSet(List<Integer> list) {
		return list.stream().map(LottoNumber::valueOf).collect(Collectors.toCollection(TreeSet::new));
	}
}
