package study.step1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {

  private Set<Integer> numbers;

  /*
    @BeforeAll
    - 해당 annotation이 달린 메서드가 현재 클래스의 모든 테스트 메서드 보다 먼저 실행된다.
    - 해당 메서드는 static 이어야 한다.
    - 이전의 @BeforeClass 와 동일
    @BeforeEach
    - 해당 annotation이 달린 메서드가 각 테스트 메서드 전에 실행된다.
    - 이전의 @Before와 동일
  */
  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @Test
  @DisplayName("요구사항1 - Set의 size 테스트")
  void sizeTest() {
    assertThat(numbers.size()).isEqualTo(3);
  }

  /*
    @ValueSource는 리터럴 값의 단일 배열을 지정할 수 있으며 매개 변수화 된 테스트 호출마다 단일 인수를 제공하는 데만 사용할 수 있습니다.
    @ValueSource는 다음 유형의 리터럴 값을 지원합니다.

    short, byte, int, long, float, double, char, boolean, java.lang.String, java.lang.Class
  */
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  @DisplayName("요구사항2 - ParameterizedTest 테스트")
  void parameterizedTest(int input) {
    assertThat(numbers.contains(input)).isTrue();
  }

  /*
    @CsvSource는 delimiter로 분리된 문자열 을 테스트 메소드의 파라미터로 넣어준다.
    - ''로 넣은 것은 empty가 들어오고 아예 비워두는 것은 null이 들어오게 된다.
  */
  @ParameterizedTest
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
  @DisplayName("요구사항3 - ParameterizedTes에서 CsvSource를 활용한 테스트")
  void parameterizedDelimiterTest(int input, boolean expected) {
    assertThat(numbers.contains(input)).isEqualTo(expected);
  }
}
