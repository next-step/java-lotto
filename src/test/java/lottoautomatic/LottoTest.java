package lottoautomatic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

	@Test
	@DisplayName("로또는 6개의 번호를 가진다.")
	void lotto_has_6_numbers() throws Exception {
		//given
		Lotto lotto = new Lotto();
		List<Integer> defaultNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		//when
		lotto.generateNumbers(() -> defaultNumbers);
		List<Integer> numbers = lotto.numbers();

		//then
		assertThat(numbers).hasSize(defaultNumbers.size());
	}


	@Test
	@DisplayName("로또의 번호가 6개가 아닌 경우 예외")
	void lotto_number_size_exception() throws Exception {
		//given
		Lotto lotto = new Lotto();

		//when
		List<Integer> defaultNumbers = Arrays.asList(1, 2, 3, 4, 5);

		//then
		assertThatThrownBy(() -> lotto.generateNumbers(() -> defaultNumbers)).isInstanceOf(IllegalStateException.class);
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
