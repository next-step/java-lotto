package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ManualLottoTest {

    @Test
    @DisplayName("수동으로 구매하는 번호들은 중복되면 예외(1,1,3,5,6,7 => IllegalArgumentException)")
    void check_duplication() {
        assertThatThrownBy(() -> {
            new ManualLotto(List.of(1,1,3,5,6,7));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
