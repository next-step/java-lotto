package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @Test
    void 로또번호_보너스번호_중복() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoNumber bonus = new LottoNumber(1);
        assertThatThrownBy(() -> {
            new WinningLotto(lotto, bonus);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("LottoResultProvider")
    void 로또_당첨결과_확인(Lotto purchasedLotto, LottoResult expected) {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoNumber bonus = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonus);

        assertThat(winningLotto.getLottoResult(purchasedLotto)).isEqualTo(expected);
    }

    public static List<Arguments> LottoResultProvider() {
        return List.of(
                Arguments.of(new Lotto(1, 2, 3, 4, 5, 6), LottoResult.SIX),
                Arguments.of(new Lotto(1, 2, 3, 4, 5, 7), LottoResult.BONUS),
                Arguments.of(new Lotto(1, 2, 3, 4, 5, 8), LottoResult.FIVE),
                Arguments.of(new Lotto(1, 2, 3, 4, 7, 8), LottoResult.FOUR),
                Arguments.of(new Lotto(1, 2, 3, 7, 8, 9), LottoResult.THREE),
                Arguments.of(new Lotto(1, 2, 7, 8, 9, 10), LottoResult.FAIL)
        );
    }

}