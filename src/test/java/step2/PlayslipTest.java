package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayslipTest {

    private Playslip playslip;

    @BeforeEach
    void setUp() {
        playslip = new Playslip();
    }

    @DisplayName("로또용지는 선택한 번호들을 제공한다.")
    @Test
    void selectNumbers() {
        assertThat(playslip.selectNumbers(2).size()).isEqualTo(2);
    }

    @DisplayName("로또용지는 0개 이하를 선택한 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void noPositiveNumberSelection(int selection) {
        assertThatThrownBy(() -> playslip.selectNumbers(selection)) //
                .hasMessage(Playslip.ONLY_POSITIVE_NUMBERS);
    }

    @DisplayName("로또용지는 선택번호셋을 여러개 제공한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void listNumbers(int selection) {
        List<LotteryNumber> nominatedNumbers = playslip.selectNumbers(selection);
        assertThat(nominatedNumbers.size()).isEqualTo(selection);
    }

    @DisplayName("번호셋은 6개의 번호를 가지고 있다.")
    @Test
    void sixNumbers() {
        List<LotteryNumber> nominatedNumbers = playslip.selectNumbers(1);
        for (LotteryNumber nominatedNumber : nominatedNumbers) {
            assertThat(nominatedNumber.getNumbers().size()).isEqualTo(6);
        }
    }


}
