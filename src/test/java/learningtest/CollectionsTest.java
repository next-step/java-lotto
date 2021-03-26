package learningtest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Collections 학습 테스트")
class CollectionsTest {

  @Test
  @DisplayName("shuffle이 어떻게 동작할까?")
  void shuffle() {
    // given
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // when
    Collections.shuffle(list);

    // then 왜 실패하지 않을까...
    assertThat(list.subList(0, 6)).usingFieldByFieldElementComparator().isNotEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
  }

  @Test
  @DisplayName("contains는 어떻게 동작할까?")
  void contains() {
    // given
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

    // when
    // then
    assertAll(
        () -> assertThat(list.contains(1)).isTrue(),
        () -> assertThat(list.contains(0)).isFalse()
    );
  }
}
