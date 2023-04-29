package util;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CollectionUtilTest {

  @DisplayName("CollectionUtils.isEmpty() | null 이거나 비어있는 리스트는 true를 반환한다.")
  @ParameterizedTest(name = "리스트 값: {0}")
  @NullAndEmptySource
  void test(List<String> given) {
    // when
    boolean isEmptyList = CollectionUtils.isEmpty(given);

    // then
    Assertions.assertThat(isEmptyList)
        .isTrue();
  }
}
