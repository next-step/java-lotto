import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	@DisplayName(value = "set 에 element는 중복될 수 없어 4번 add가 발생했지만, size는 3이 된다")
	void setSize() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName(value = "set에 1, 2, 3 element 가 존재하는지 검증한다")
	void setContains(int element) {
		assertThat(numbers.contains(element)).isTrue();
	}

}
