package lotto.domain;

import lotto.LottoConstants;
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
    @DisplayName("from 호출할 때 매개변수 리스트의 요소가 최솟값보다 작은 경우 IllegalArgumentException")
    void from_min_number_valid_exception() {
        int invalidNumber = LottoConstants.MIN_LOTTO_NUMBER - 1;
        assertThatThrownBy(() -> {
            LottoNumber.from(List.of(invalidNumber, 3, 5, 10, 33, 45));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("from 호출할 때 매개변수 리스트의 요소가 최대값보다 작은 경우 IllegalArgumentException")
    void from_max_number_valid_exception() {
        int invalidNumber = LottoConstants.MAX_LOTTO_NUMBER + 1;
        assertThatThrownBy(() -> {
            LottoNumber.from(List.of(invalidNumber, 1, 5, 10, 33, 45));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("from 호출 시 LottoNumber 생성하여 정상 반환")
    void from_success() {
        LottoNumber lottoNumber = LottoNumber.from(List.of(1,2,3,4,5,6));

        assertThat(lottoNumber.size()).isEqualTo(6);
    }
}
