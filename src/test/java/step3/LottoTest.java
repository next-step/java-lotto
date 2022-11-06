package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {

    @Test
    @DisplayName("매개변수 set 일 때")
    void create() {
        Set<Integer> set = Set.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(set);

        assertThat(lotto.getLotto()).isEqualTo(set);
    }

    @Test
    @DisplayName("매개변수 String[], 당첨 번호 로또 생성")
    void createWinLotto() {
        String[] winLotto = {"1", "2", "3", "4", "5", "6"};
        Lotto lotto = new Lotto(winLotto);

        assertThat(lotto.getLotto()).isEqualTo(Set.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("자동로또, 당첨번호 포함 여부")
    void lotto() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.isExist(7)).isFalse();
        assertThat(lotto.isExist(6)).isTrue();
    }

    @Test
    @DisplayName("매개변수 String[], 당첨 번호 중복 체크")
    void validCreateWinLotto() {
        String[] winLotto = {"1", "2", "3", "4", "6", "6"};

        assertThatThrownBy(() -> new Lotto(winLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("로또 생성 시 번호 범위 또는 중복 번호 예외 체크")
    @CsvSource(value = {
            "1, 2, 3, 4, 5, 5",
            "1, 2, 3, 4, 5, 101"
    })
    void checkRangeAndSameBall(String input) {
        assertThatThrownBy(() -> new Lotto(input.split(", ")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
