package step2.study;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DistinctTest {
	@Test
	@DisplayName("distinct() 함수 학습 테스트")
	public void distinctTest() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);

		List<Integer> newList = list.stream().distinct().collect(Collectors.toList());
		assertThat(newList.size()).isEqualTo(3);
	}
}
