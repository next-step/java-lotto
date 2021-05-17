package studytest;

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

  // Test Case 구현

  @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다. 중복 허용을 하지 않으니 사이즈는 3이어야 한다.")
  @Test
  void size() {
    assertThat(numbers).hasSize(3);
  }

  @DisplayName("ParameterizedTest를 활용해 중복 코드를 제거한 후 Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현한다.")
  @ValueSource(ints={1,2,3})
  @ParameterizedTest
  void containsUsingValueSource(int number) {
    assertThat(numbers.contains(number)).isTrue();
  }
}
