package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumbersTest {
    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = new LottoNumbers();
    }

    @Test
    @DisplayName("로또 번호 자동 생성")
    void 자동_생성() {
        assertThat(lottoNumbers.generateAutoLottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("지난주 당첨번호 입력 후 유효한 로또 번호인지 확인")
    void winningNumber() {
        assertThat(lottoNumbers.validateLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))).isTrue();
    }

    @Test
    @DisplayName("중복 번호가 있는 경우 IllegalArgumentException")
    void 중복_번호_확인() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    lottoNumbers.validateLottoNumbers(Arrays.asList(1, 2, 3, 6, 4, 6));
                }).withMessageMatching("중복된 번호가 있습니다.");
    }

    @Test
    @DisplayName("번호 갯수가 6개가 아닌 경우 IllegalArgumentException")
    void 갯수_확인() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    lottoNumbers.validateLottoNumbers(Arrays.asList(1, 2, 3, 4, 6));
                }).withMessageMatching("번호 갯수가 6개가 아닙니다.");
    }

    @Test
    @DisplayName("번호가 1~45 사이의 수가 아닌 경우 IllegalArgumentException")
    void 유효한_번호_확인() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    lottoNumbers.validateLottoNumbers(Arrays.asList(46, 47, 48, 33, 49, 10));
                }).withMessageMatching("유효한 번호가 아닙니다.");
    }

}
