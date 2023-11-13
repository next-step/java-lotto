package lotto.validate;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumberValidationTest {

    private NumberValidation numberValidation;

    @BeforeEach
    void setUp() {
        numberValidation = new NumberValidation();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 로또_번호_유효성_검사_성공(int number) {
        // given
        // when
        numberValidation.checkNumberRange(number);
        // then
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 47, 48, 49, 50})
    void 로또_번호_유효성_검사_실패(int number) {
        // given
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            numberValidation.checkNumberRange(number);
        });
    }

    @Test
    public void 로또_번호_6개_보너스_추가_유효성_검사_성공() {
        // given
        Lotto lotto = new Lotto();
        lotto.create(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        // when
        numberValidation.checkBonusNumber(lotto, bonusNumber);
        // then
    }

    @Test
    public void 로또_번호_6개_보너스_추가_유효성_검사_중복번호_입력() {
        // given
        Lotto lotto = new Lotto();
        lotto.create(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(6);
        // when
        assertThatIllegalArgumentException().isThrownBy(() -> numberValidation.checkBonusNumber(lotto, bonusNumber));
        // then
    }
}
