package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class CollectionUtilsTest {

	@Test
	void transform() {
		// given
		List<String> source = Arrays.asList("1", "2", "3");
		List<Integer> target = new ArrayList<>();

		// when
		CollectionUtils.transform(source, target, Integer::parseInt);

		// then
		assertThat(target).containsExactly(1, 2, 3);
	}

}
