package edu.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Lotto: 로또 한 장에 해당하는 클래스. 내부적으로 LottoNumbers 필드가 있음.")
class LottoTest {
	@DisplayName("생성자: Lotto 객체를 정상적으로 생성하여 리턴함")
	@Test
	void generate() {
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		assertThat(lotto)
			.isNotNull()
			.isInstanceOf(Lotto.class)
			.hasNoNullFieldsOrPropertiesExcept("lottoNumbers");
	}

	@DisplayName("getRank: Lotto객체가 가진 번호와 당첨번호를 비교해 1,3,4,5등이 되면 LottoRank ENUM을 리턴함. (Optional임)")
	@ParameterizedTest
	@CsvSource(value = {
		"1,2,3,4,5,6:1,2,3,4,5,6:FIRST",
		"1,2,3,4,5,6:1,2,3,4,5,7:THIRD",
		"1,2,3,4,5,6:1,2,3,4,7,8:FOURTH",
		"1,2,3,4,5,6:1,2,3,7,8,9:FIFTH"
	}, delimiter = ':')
	void getRank(String numbers, String winningNumbers, LottoRank expected) {
		Lotto lotto = new Lotto(splitToIntList(numbers));
		Lotto winningLotto = new Lotto(splitToIntList(winningNumbers));
		assertThat(lotto.getRank(winningLotto))
			.isPresent()
			.hasValue(expected);
	}

	@DisplayName("getRank: Lotto객체가 가진 번호와 당첨번호를 비교해 낙첨이면 null을 Optional로 감싸 리턴함")
	@ParameterizedTest
	@CsvSource(value = {
		"1,2,3,4,5,6:7,8,9,10,11,12"
	}, delimiter = ':')
	void getRank(String numbers, String winningNumbers) {
		Lotto lotto = new Lotto(splitToIntList(numbers));
		Lotto winningLotto = new Lotto(splitToIntList(winningNumbers));
		assertThat(lotto.getRank(winningLotto)).isNotPresent();
	}

	private List<Integer> splitToIntList(String numbers) {
		return Arrays.stream(numbers.split(","))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}
}