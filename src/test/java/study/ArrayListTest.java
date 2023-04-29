package study;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayListTest {

	@DisplayName("ArrayList의 subList() 메서드 동작 확인")
	@Test
	void subList() {
		assertThat(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).subList(0, 6)).containsExactly(1, 2, 3, 4, 5, 6);
	}
}
