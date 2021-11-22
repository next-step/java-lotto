package lotto;

import calculator.PositiveNumber;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

/**
 * @author han
 */
public class LottoTest {

    @Test
    @DisplayName("로또 자동 생성")
    void create() {
        Lotto byAuto = Lotto.createByAuto();
        assertThat(byAuto.getNumbers().size()).isEqualTo(5);
    }
}
