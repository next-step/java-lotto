package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NumberTest {

	@Test
	void Number는_숫자_타입을_보장한다() {
		String numericStr = "111";

		Number actual = new Number(numericStr);
		Number expected = new Number(Integer.parseInt(numericStr));

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void 숫자가_아닌_값이_인자로_전달될_경우_IllegalArgumentException를_던진다() {
		String notNumericStr = "a1";
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Number(notNumericStr);
		});
	}

}
