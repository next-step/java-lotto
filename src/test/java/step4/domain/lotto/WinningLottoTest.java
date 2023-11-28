package step4.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {

    Set<LottoNumber> winningLottoNumbers;
    WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLottoNumbers = Set.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9));
    }

    @Test
    void 당첨_로또_번호_생성_테스트_오류() {
        winningLottoNumbers = Set.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10));
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(winningLottoNumbers, new LottoNumber(11)));
    }

    @Test
    void 당첨_로또_번호_생성_보너스_번호_중복_테스트_오류() {
        winningLottoNumbers = Set.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9));
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(winningLottoNumbers, new LottoNumber(9)));
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3"})
    void 로또_번호_존재_여부_테스트(int input) {
        winningLotto = new WinningLotto(winningLottoNumbers, new LottoNumber(45));
        assertThat(winningLotto.hasLottoNumber(new LottoNumber(input))).isTrue();
    }

    @Test
    void 보너스_번호_존재_여부_테스트() {
        winningLotto = new WinningLotto(winningLottoNumbers, new LottoNumber(10));
        assertThat(winningLotto.hasBonusNumber(new LottoNumber(10))).isTrue();
    }
}
