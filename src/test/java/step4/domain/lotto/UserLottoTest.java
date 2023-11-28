package step4.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UserLottoTest {

    Set<LottoNumber> userLottoNumbersA;
    UserLotto userLotto;

    Set<LottoNumber> winningLottoNumbers;
    WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        userLottoNumbersA = Set.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        winningLottoNumbers = Set.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9));
    }

    @Test
    void 유저_로또_번호_생성_테스트_오류() {
        userLottoNumbersA = Set.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6), new LottoNumber(7));
        assertThatIllegalArgumentException().isThrownBy(() -> new UserLotto(userLottoNumbersA));
    }

    @Test
    void 당첨_로또와_매칭_되는_번호_개수_테스트() {
        userLotto = new UserLotto(userLottoNumbersA);
        winningLotto = new WinningLotto(winningLottoNumbers, new LottoNumber(10));
        assertThat(userLotto.findCountOfMatch(winningLotto)).isEqualTo(3);
    }

    @Test
    void 보너스_번호_존재_여부_True_테스트() {
        userLotto = new UserLotto(userLottoNumbersA);
        winningLotto = new WinningLotto(winningLottoNumbers, new LottoNumber(10));
        assertThat(userLotto.hasBonusNumber(winningLotto)).isFalse();
    }

    @Test
    void 보너스_번호_존재_여부_False_테스트() {
        userLotto = new UserLotto(userLottoNumbersA);
        winningLotto = new WinningLotto(winningLottoNumbers, new LottoNumber(6));
        assertThat(userLotto.hasBonusNumber(winningLotto)).isTrue();
    }
}
