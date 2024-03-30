package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ManualLottosTest {

    @Test
    @DisplayName("수동으로 구매하는 번호들은 중복되면 예외(1,1,3,5,6,7 => IllegalArgumentException)")
    void check_duplication() {
        assertThatThrownBy(() -> {
            new ManualLotto(List.of(1, 1, 3, 5, 6, 7));
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("수동으로 구매하는 번호들은 6개가 아니면 예외(1,2,3,4,5,6,7 => IllegalArgumentException, empty => IllegalArgumentException)")
    void check_size() {
        assertThatThrownBy(() -> {
            new ManualLotto(List.of(1, 2, 3, 4, 5, 6, 7));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new ManualLotto(Collections.emptyList());
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
