package lotto;

import lotto.service.ValidationCheck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationCheckTest {
    @ParameterizedTest
    @NullAndEmptySource
    @CsvSource(value = {"500", "999"})
    void 입력된_구입금액_유효성확인(String input) {
        assertThatThrownBy(() -> {
            ValidationCheck.validatePurchaseAmount(Integer.parseInt(input));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @CsvSource(value = {"1,2,3", "1,2,3,4,5,6,7"})
    void 입력된_당첨번호_유효성확인(String input) {
        assertThatThrownBy(() -> {
            ValidationCheck.validatePurchaseAmount(Integer.parseInt(input));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_당첨번호와보너스번호_중복확인() {
        int bonusNumber = 6;
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> {
            ValidationCheck.validateNoDuplicateBonusNumbers(winningNumbers, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
