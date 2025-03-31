package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SummaryTest {
    @Test
    @DisplayName("로또 없이 통계가 생성되지 않는다.")
    void create() {
        Assertions.assertThatThrownBy(() -> new Summary(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
