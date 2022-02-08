package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class WinningTest {

    @DisplayName("지난_주_당첨번호에_보너스볼이_중복으로_들어가있는지_검증")
    @Test
    void winningNumberTest() {
        List<LottoNumber> lottoNumber =
            Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        LottoNumber bonusLottoNumber = new LottoNumber(6);
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Winning(new Lotto(lottoNumber), bonusLottoNumber));
    }
}
