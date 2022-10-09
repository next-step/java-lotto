package lotto.model;

import calculator.model.Expression;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTest {

    @DisplayName("로또가 생성된다.")
    @Test
    void createLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또의 개수가 맞지 않을 경우 에러를 반환한다.")
    @Test
    void validateLottoSize() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Lotto(List.of(1, 2, 3, 4, 5));
                    new Lotto(List.of(1, 2, 3, 4, 5, 6, 7));
                });
    }

    @DisplayName("로또의 번호가 중복되었을 경우 에러를 반환한다.")
    @Test
    void validateDuplicatedNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Lotto(List.of(1, 2, 3, 4, 5, 5));
                });
    }

    @DisplayName("로또 맞은 개수 반환한다.")
    @Test
    void countCorrectNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int count = lotto.countCorrectNumber(new Lotto(List.of(1, 2, 3, 7, 8, 9)));
        assertThat(count).isEqualTo(3);
    }
}
