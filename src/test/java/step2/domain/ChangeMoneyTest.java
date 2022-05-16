package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "남은 금액 테스트")
class ChangeMoneyTest {

    @Test
    void 수동_구매_후_님은_금액을_Wrapping하는_객체_생성() {
        assertThat(new ChangeMoney(1000)).isEqualTo(new ChangeMoney(1000));
    }

    @Test
    void 음수가_입력되면_예외() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new ChangeMoney(-1)
        );
    }

    @ParameterizedTest
    @CsvSource(
            delimiter = ':',
            value = {
                    "0:0",
                    "1000:1"
            }
    )
    void 남은_구매_횟수를_반환(int input, int expect) {
        ChangeMoney changeMoney = new ChangeMoney(input);

        PurchaseCount result = changeMoney.getRemainCount();

        assertThat(result).isEqualTo(new PurchaseCount(expect));
    }
}