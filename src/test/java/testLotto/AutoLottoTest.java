package testLotto;

import calculator.StringCalculator;
import lotto.AutoLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AutoLottoTest {
    private AutoLotto autoLotto;

    @BeforeEach
    void setup() {
        autoLotto = new AutoLotto();
    }

    @DisplayName(value = "로또번호를 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4"})
    void verifyLottoNumber(final String text) {
//        assertThat(calculaauto.(text)).isSameAs(3);
        System.out.println(autoLotto.generateLottoNumber());
    }
}

