package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoNumberSelectRuleTest {

	@DisplayName("주어진 번호를 그대로 리턴한다")
	@Test
	void select_Then_returnGivenNumbers() {
		Set<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6).collect(toSet());
		ManualLottoNumberSelectRule selectRule = new ManualLottoNumberSelectRule(numbers);

		Set<Integer> selectedNumbers = selectRule.select();

		assertThat(selectedNumbers).isEqualTo(numbers);
	}
}