package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoNumberTest {
    @Test
    @DisplayName("당첨번호를 통해서 몇개 맞추었는지 확인한다.")
    void lottoMatchTest() {
        var lotto = new LottoNumber(List.of(1, 2, 3, 4, 5, 6));
        var winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        var result = lotto.countMatches(winningNumbers);

        Assertions.assertThat(result).isEqualTo(6L);
    }
}
