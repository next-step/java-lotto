package edu.nextstep.lotto.domain.sub;

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
			.isInstanceOf(Lotto.class);
	}

	@DisplayName("getRank: Lotto객체가 가진 번호와 당첨번호를 비교해 결과에 맞는 LottoRank ENUM을 리턴함. (Optional임)")
	@ParameterizedTest
	@CsvSource(value = {
		"1,2,3,4,5,6:1,2,3,4,5,6:7:FIRST",
		"1,2,3,4,5,7:1,2,3,4,5,6:7:SECOND",
		"1,2,3,4,5,8:1,2,3,4,5,6:7:THIRD",
		"1,2,3,4,7,8:1,2,3,4,5,6:7:FOURTH",
		"1,2,3,7,8,9:1,2,3,4,5,6:7:FIFTH",
		"1,2,7,8,9,10:1,2,3,4,5,6:7:NONE"
	}, delimiter = ':')
	void getRank(String numbers, String winningNumbers, int bonusNumber, LottoRank expected) {
		Lotto lotto = new Lotto(splitToIntList(numbers));
		WinningLotto winningLotto = new WinningLotto(splitToIntList(winningNumbers), bonusNumber);
		assertThat(lotto.getRank(winningLotto))
			.isPresent()
			.hasValue(expected);
	}

	private List<Integer> splitToIntList(String numbers) {
		return Arrays.stream(numbers.split(","))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}
}