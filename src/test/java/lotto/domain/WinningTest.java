package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class WinningTest {

    @DisplayName("위닝_숫자_검증")
    @Test
    void winningNumberTest() {
        LottoNumbers lottoFullNumber = new LottoNumbers(
            Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));

        LottoNumber bonusLottoNumber = new LottoNumber(6);
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Winning(new Lotto(lottoFullNumber), bonusLottoNumber));
    }
}
