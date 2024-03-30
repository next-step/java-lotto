package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("배열이 null이면 예외")
    void if_null() {
        assertThatThrownBy(() -> {
            new Lotto(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동으로 구매하는 번호들은 중복되면 예외(1,1,3,5,6,7 => IllegalArgumentException)")
    void check_duplication() {
        assertThatThrownBy(() -> {
            new Lotto(List.of(new LottoNumber(1), new LottoNumber(1), new LottoNumber(3), new LottoNumber(5), new LottoNumber(6), new LottoNumber(7)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동으로 구매하는 번호들은 6개가 아니면 예외(1,2,3,4,5,6,7 => IllegalArgumentException, empty => IllegalArgumentException)")
    void check_size() {
        assertThatThrownBy(() -> {
            new Lotto(List.of(
                    new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6),
                    new LottoNumber(7)));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Lotto(Collections.emptyList());
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
