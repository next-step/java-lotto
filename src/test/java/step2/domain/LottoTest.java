package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "로또 테스트")
class LottoTest {

    private static final PurchaseStrategy DEFAULT_STRATEGY = (count) -> new HashSet<>(List.of("1", "2", "3", "4", "5", "6"));
    private static final PurchaseStrategy MALFORMED_STRATEGY = (count) -> new HashSet<>();

    @Test
    void 구매전략이_반환하는_SET의_사이즈가_6개_아닌_경우_예외() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lotto(MALFORMED_STRATEGY)
        );
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "1:true",
                    "11:false"
            },
            delimiter = ':'
    )
    void 현재_로또가_주어진_번호를_포함하는지_반환(String number, boolean expect) {
        Lotto lotto = new Lotto(DEFAULT_STRATEGY);
        LottoNumber operand = LottoNumber.from(number);

        boolean result = lotto.contain(operand);

        assertThat(result).isEqualTo(expect);
    }
}