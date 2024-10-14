package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
    }

    @Test
    @DisplayName("로또 번호 자동 생성")
    void 자동_생성() {
        assertThat(lotto.generateAutoLottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("한 개의 로또에 일치하는 개수 확인")
    void 일치하는_개수_확인() {
        lotto = new Lotto(Arrays.asList(7, 2, 4, 5, 22, 37));
        assertThat(lotto.calculateMatchCount(new Lotto(Arrays.asList(1, 5, 13, 22, 43, 37)))).isEqualTo(3);
    }

    @Test
    @DisplayName("지난주 당첨번호 입력 후 유효한 로또 번호인지 확인")
    void winningNumber() {
        assertThat(Lotto.validateLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))).isTrue();
    }

    @Test
    @DisplayName("중복 번호가 있는 경우 IllegalArgumentException")
    void 중복_번호_확인() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Lotto.validateLottoNumbers(Arrays.asList(1, 2, 3, 6, 4, 6));
                }).withMessageMatching("중복된 번호가 있습니다.");
    }

    @Test
    @DisplayName("번호 갯수가 6개가 아닌 경우 IllegalArgumentException")
    void 갯수_확인() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Lotto.validateLottoNumbers(Arrays.asList(1, 2, 3, 4, 6));
                }).withMessageMatching("번호 갯수가 6개가 아닙니다.");
    }

    @Test
    @DisplayName("번호가 1~45 사이의 수가 아닌 경우 IllegalArgumentException")
    void 유효한_번호_확인() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Lotto.validateLottoNumbers(Arrays.asList(46, 47, 48, 33, 49, 10));
                }).withMessageMatching("유효한 번호가 아닙니다.");
    }
}
