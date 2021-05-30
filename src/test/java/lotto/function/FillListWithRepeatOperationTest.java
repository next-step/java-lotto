package lotto.function;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class FillListWithRepeatOperationTest {

	@Test
	void apply() {
		// given
		FillListWithRepeatOperation<Integer> fillResultList = new FillListWithRepeatOperation<>();

		// when
		List<Integer> integers = fillResultList.apply(5, this::generateOne);

		// then
		assertThat(integers).isEqualTo(Arrays.asList(1, 1, 1, 1, 1));
	}

	private int generateOne() {
		return 1;
	}
}
