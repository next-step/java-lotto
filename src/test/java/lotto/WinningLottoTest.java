package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    private static final Lotto LAST_WEAK_LOTTO = new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
        .map(LottoNumber::new)
        .collect(Collectors.toList()));


    @DisplayName("지난주 로또를 입력받는다.")
    @Test
    void inputLastWeakLotto() {
        assertThatNoException().isThrownBy(
            () -> WinningLotto.of(LAST_WEAK_LOTTO, new LottoNumber(8)));
    }

    @DisplayName("로또를 입력받아 지난주 로또 번호와 일치 개수를 반환한다.")
    @Test
    void compareWithLastWeakLottoAndReturnMatchCount() {
        WinningLotto winningLotto = WinningLotto.of(LAST_WEAK_LOTTO, new LottoNumber(8));
        Lotto myLotto = new Lotto(Stream.of(1, 2, 3, 4, 5, 7)
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
        int matchCount = winningLotto.compare(myLotto);
        assertThat(matchCount).isEqualTo(5);
    }

    @DisplayName("보너스 볼을 입력받습니다.")
    @Test
    void canInitializeBonusBall() {
        LottoNumber bonusBall = new LottoNumber(8);
        assertThatNoException().isThrownBy(() -> WinningLotto.of(LAST_WEAK_LOTTO, bonusBall));
    }

    @DisplayName("보너스 볼까지 점수로 반환합니다.")
    @Test
    void compareWithLastWeakLottoAndBonusBallAndReturnMatchCount() {
        LottoNumber bonusBall = new LottoNumber(8);
        WinningLotto winningLotto = WinningLotto.of(LAST_WEAK_LOTTO, bonusBall);
        Lotto myLotto = new Lotto(Stream.of(1, 2, 3, 4, 5, 8)
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
        assertThat(winningLotto.compare(myLotto)).isEqualTo(6);
    }
}
