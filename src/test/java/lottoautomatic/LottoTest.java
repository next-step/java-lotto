package lottoautomatic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

	@Test
	@DisplayName("로또는 6개의 번호를 가진다.")
	void lotto_has_6_numbers() throws Exception {
		//given
		Lotto lotto = new Lotto();

		//when
		List<Integer> numbers = lotto.numbers();

		//then
		assertThat(numbers).hasSize(6);
	}

	@Test
	@DisplayName("지난주 당첨 번호와 비교")
	void compare_numbers() throws Exception {
		//given
		Lotto lotto = new Lotto();
		List<Integer> lastWeekNumbers = Arrays.asList(1,2,3,4,5,6);

		//when
		int matchesNumber = lotto.match(lastWeekNumbers);

		//then
		//테스트가 불가하다!
		//몇개 맞을지 알 수 없다..
		//전략패턴이 필요하다.

	}

}
