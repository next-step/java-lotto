package lotto.oop.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
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
    @CsvSource(value = {"1 16 17 19 24 28:19"}, delimiter = ':')
    @DisplayName("보너스볼 체크")
    void checkLottoTest(String winNumbers, int bonus) {
        String[] winNumber = winNumbers.split(" ");
        List<Integer> winNumbersList = new ArrayList<>();
        for(String num : winNumber) {
            winNumbersList.add(Integer.parseInt(num));
        }
        List<Integer> generateNumbers = new ArrayList<>();
        generateNumbers.add(1);
        generateNumbers.add(16);
        generateNumbers.add(17);
        generateNumbers.add(19);
        generateNumbers.add(24);
        generateNumbers.add(27);
        lotto.setGenerateNumbers(generateNumbers);

        assertThat(lotto.checkLotto(winNumbersList, bonus)).isEqualTo(5);
        assertThat(lotto.getBonusCheck()).isEqualTo(true);
    }
}
