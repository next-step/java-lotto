package lotto.domain.lottocreator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    @DisplayName("번호 개수 확인")
    void number() {
        String number = "1, 2, 3, 4, 5, 6, 7";
        assertThatThrownBy(() -> {
            LottoFactory.createManualLotto(number);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("개수가 6개가 아닙니다.");
    }

    @Test
    @DisplayName("로또 번호 확인")
    void lessThanZero_exception() {
        String number = "-1, 2, 3, 4, 5, 6";
        assertThatThrownBy(() -> {
            LottoFactory.createManualLotto(number);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("1보다 작은 값은 로또 번호가 될 수 없습니다.");
    }
    @Test
    @DisplayName("로또 번호 확인")
    void moreThan45_exception() {
        String number = "45, 47, 3, 4, 5, 6";
        assertThatThrownBy(() -> {
            LottoFactory.createManualLotto(number);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("로또 번호는 45를 넘어갈 수 없습니다.");
    }

    @Test
    @DisplayName("일치 개수")
    void match() {
        Lotto lotto1 = LottoFactory.createManualLotto("1, 2, 3, 4, 5, 6");
        Lotto lotto2 = LottoFactory.createManualLotto("22, 43, 15, 8, 9, 19");

        assertThat(lotto1.getMatchingNumberCount(lotto2)).isEqualTo(0);
    }

    @Test
    @DisplayName("중복 숫자")
    void duplicate_exception() {
        assertThatThrownBy(() -> {
            LottoFactory.createManualLotto("1, 1, 2, 3, 4, 5");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("수동 로또 생성 시 중복 숫자 불가합니다.");
    }
}
