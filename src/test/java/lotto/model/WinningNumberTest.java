package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @DisplayName("보너스 넘버와, 위닝 넘버가 겹칠 경우 IllegalException을 발생 시킨다.")
    @Test
    void throwExceptionWhenDuplicatedNumbers() {
        LinkedHashSet<Number> LottoNumbers = new LinkedHashSet<>(Arrays.asList(Number.of(3),
                Number.of(5),
                Number.of(21),
                Number.of(26),
                Number.of(32),
                Number.of(38)));

        LottoNumbers winningNumbers = new LottoNumbers(LottoNumbers);

        Number bonusNumber = Number.of(38);

        assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }
}
