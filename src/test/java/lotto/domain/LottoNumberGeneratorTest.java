package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    private List<Integer> lottoAllNumbers;

    @BeforeEach
    void setUp() {
        lottoAllNumbers = LottoNumberGenerator.create();
    }

    @Test
    @DisplayName("로또 번호가 총 45개인지 확인")
    void lottoNumberSizeCheck() {
        assertThat(lottoAllNumbers.size()).isEqualTo(45);
    }

    @ParameterizedTest
    @DisplayName("로또 번호 개수가 맞지 않은 번호 확인")
    @ValueSource(ints = {1, -1, 100, 50})
    void invalidLottoNumbersSize(int lottoNumberSize) {
        assertThat(lottoAllNumbers.size()).isNotEqualTo(lottoNumberSize);
    }

}
