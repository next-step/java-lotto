package kr.aterilio.nextstep.techcamp.m1.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 생성 시 1-45 범위에 속하지 않는 숫자가 있으면 예외가 발생한다.")
    @Test
    public void createLottoFailed_outOfRange() {
        assertThatThrownBy(() -> {
            new Lotto(new Integer[]{-1, 2, 3, 4, 5, 46});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위");
    }

    @DisplayName("로또 생성 시 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    public void createLottoFailed_duplicated() {
        assertThatThrownBy(() -> {
            new Lotto(new Integer[]{1, 2, 3, 4, 5, 1});
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }
}
