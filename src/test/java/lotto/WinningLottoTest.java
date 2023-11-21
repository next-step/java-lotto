package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    private static final Lotto LAST_WEAK_LOTTO = new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
        .map(LottoNumber::new)
        .collect(Collectors.toList()));

    @DisplayName("지난주 로또를 입력받는다.")
    @Test
    void inputLastWeakLotto() {
        assertThatNoException().isThrownBy(() -> WinningLotto.from(LAST_WEAK_LOTTO));
    }

    @DisplayName("로또를 입력받아 지난주 로또 번호와 일치 개수를 반환한다.")
    @Test
    void compareWithLastWeakLottoAndReturnMatchCount() {
        WinningLotto winningLotto = WinningLotto.from(LAST_WEAK_LOTTO);
        Lotto lotto = new Lotto(Stream.of(1, 2, 3, 4, 5, 7)
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
        int matchCount = winningLotto.compare(lotto);
        assertThat(matchCount).isEqualTo(5);
    }

}
