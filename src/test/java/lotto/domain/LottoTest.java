package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setup() {
        lotto = new Lotto();
    }

    @Test
    void createLotto() {
        int numberSize = lotto.generateNumbers();
        assertThat(numberSize).isEqualTo(6);
    }

    @Test
    void toStringLotto() {
        lotto.generateNumbers();
        String lottoNumbers = lotto.toString();
        assertAll(() -> {
            assertThat(lottoNumbers.charAt(0)).isEqualTo('[');
            assertThat(lottoNumbers.split(",").length).isEqualTo(6);
            assertThat(lottoNumbers.charAt(lottoNumbers.length() - 1)).isEqualTo(']');
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void checkLastWinningNumber(String lastWinnerNumber){
        System.out.println(lastWinnerNumber);
        lotto.createNumber(Arrays.asList(1,2,3,8,9,10));
        int matchNumber = lotto.checkLastWinningNumber(lastWinnerNumber);
        assertThat(matchNumber).isEqualTo(3);
    }

}