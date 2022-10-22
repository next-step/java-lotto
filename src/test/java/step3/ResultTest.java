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
		Lotto set1 = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
		Lotto set2 = new Lotto(Set.of(7, 8, 9, 10, 11, 12));
		Lotto set3 = new Lotto(Set.of(7, 8, 9, 10, 11, 12));
		Result result = new Result(new Lottos(List.of(set1, set2, set3)));
		Map<Operator, Integer> map = result.results(new Lotto(Set.of(1, 2, 3, 4, 5, 6)), 7);

		assertThat(map.get(Operator.SIX)).isEqualTo(1);
		assertThat(map.get(Operator.FIVE)).isEqualTo(0);
	}
}
