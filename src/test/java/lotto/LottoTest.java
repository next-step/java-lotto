package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또의 가격은 1000원이다")
    @Test
    void price() {
        assertThat(Lotto.PRICE).isEqualTo(1000);
    }

    @DisplayName("당첨 결과 확인시 당첨 번호의 개수가 지정된 개수와 같지 않으면 IllegalArgumentException")
    @Test
    void winningNumbersSizeNotEquals_Then_IllegalArgumentException() {
        Lotto lotto = new Lotto(() -> new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6).collect(toSet())));
        WinningNumbers winningNumbers = new WinningNumbers(Stream.of(1, 2, 3).collect(toSet()));
        int bonusNumber = 45;

        assertThatThrownBy(() -> lotto.checkResult(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 결과를 확인한다")
    @Test
    void checkResult() {
        Lotto lotto = new Lotto(() -> new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6).collect(toSet())));
        WinningNumbers winningNumbers = new WinningNumbers(Stream.of(1, 2, 3, 4, 5, 6).collect(toSet()));
        int bonusNumber = 45;

        Rank rank = lotto.checkResult(winningNumbers, bonusNumber);
        assertThat(rank).isNotNull();
    }
}
