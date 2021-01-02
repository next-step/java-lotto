package lotto.oop.domain;

import lotto.oop.ui.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    private LottoNumber lotto;
    
    @BeforeEach
    public void setUp() {
        lotto = new LottoNumber();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,16,17,19,24,28:19"}, delimiter = ':')
    @DisplayName("보너스볼 체크")
    void checkLottoTest(String winNumbers, int bonus) {
        InputView input = new InputView();
        List<Integer> winNumbersList = input.convertInt(winNumbers);
        List<Integer> generateNumbers = Arrays.asList(3,16,17,19,24,28);
        lotto.setGenerateNumbers(generateNumbers);

        assertThat(lotto.checkLotto(winNumbersList, bonus)).isEqualTo(5);
        assertThat(lotto.getBonusCheck()).isEqualTo(true);
    }

    @Test
    @DisplayName("수동 로또 넘버를 생성한다.")
    void checkHandLottoNumber() {
        assertThatThrownBy(() -> {
                    new LottoNumber("1,3,5,7,9,11,17");
                }
        ).isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }
}
