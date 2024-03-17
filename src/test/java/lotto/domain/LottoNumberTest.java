package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @Test
    @DisplayName("from 호출할 때 매개변수 리스트의 size 6이 아니면 IllegalArgumentException")
    void from_list_size_exception() {
        assertThatThrownBy(() -> {
            LottoNumber.from(List.of(1, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            LottoNumber.from(List.of(1, 2, 3, 4, 5, 6, 7));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("from 호출할 때 매개변수 리스트의 요소가 1보다 작은 경우 IllegalArgumentException")
    void from_number_valid_exception() {
        assertThatThrownBy(() -> {
            LottoNumber.from(List.of(-1, 0, 5, 10, 33, 45));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("from 호출 시 LottoNumber 생성하여 정상 반환")
    void from_success() {
        LottoNumber lottoNumber = LottoNumber.from(List.of(1,2,3,4,5,6));

        assertThat(lottoNumber.size()).isEqualTo(6);
    }
}
