package step3;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

	@Test
	@DisplayName("로또 결과 확인")
	void results() {
		Set<Integer> set1 = Set.of(1, 2, 3, 4, 5, 6);
		Set<Integer> set2 = Set.of(7, 8, 9, 10, 11, 12);
		Set<Integer> set3 = Set.of(7, 8, 9, 10, 11, 12);
		Result result = new Result(new Lottos(List.of(set1, set2, set3)));
		Map<Operator, Integer> map = result.results(Set.of(1, 2, 3, 4, 5, 6), 7);

		assertThat(map.get(Operator.SIX)).isEqualTo(1);
		assertThat(map.get(Operator.FIVE)).isEqualTo(0);
	}
}
