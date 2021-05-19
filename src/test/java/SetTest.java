import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest {

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
	@DisplayName("Set Collection, Size 테스트")
	void sizeTest(){
		assertThat(numbers.size())
			.isEqualTo(3); // Set Collection 특성 때문에 중복이 제거되고 3개만 있어야한다.
	}

	@ParameterizedTest(name = "Set Collection, contains 테스트. value={0}")
	@ValueSource(ints = {
		1, 2, 3
	})
	void containsTest(final int value) {
		assertThat(numbers.contains(value))
			.isTrue();
	}
}
