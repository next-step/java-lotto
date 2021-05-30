package lotto.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CollectionUtilsTest {

	@Test
	void transform() {
		// given
		List<String> source = Arrays.asList("1", "2", "3");

		// when
		List<Integer> integerList = CollectionUtils.transform(source, new ArrayList<>(), Integer::parseInt);

		// then
		assertThat(integerList).containsExactly(1, 2, 3);
	}

}
