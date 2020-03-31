package lotto.domain;

import lotto.exception.ExceptionType;
import lotto.exception.LottoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("로또 번호 갯수 체크 테스트")
    void lotto_갯수_검사() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(ExceptionType.INVALID_LOTTO_NUMBER_SIZE.getMessage());
    }

    @Test
    @DisplayName("로또 번호 중복 검사 테스트 ")
    void lotto_중복_검사() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(ExceptionType.DUPLICATED_LOTTO_NUMBER.getMessage());
    }

    @Test
    @DisplayName("로또 번호 검사 테스트 (1 이상 45 이하) ")
    void lotto_번호_검사() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(ExceptionType.INVALID_LOTTO_NUMBER.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "7:false"}, delimiter = ':')
    void contains(int value, boolean expected) {
        assertThat(lotto.contains(value)).isEqualTo(expected);
    }

    @Test
    void getMatchCount() {
        Lotto matchLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));

        int matchCount = lotto.getMatchCount(matchLotto);

        assertThat(matchCount).isEqualTo(5);
    }
}
