package lotto.domain;

import lotto.strategy.LottoRandomGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBundleTest {

    @ParameterizedTest
    @MethodSource("LottoResultProvider")
    void 로또_당첨결과_확인(Lotto lotto, LottoResult lottoResult) {
        LottoBundle lottoBundle = new LottoBundle(List.of(lotto));
        WinningLotto winningLotto = new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), 7);

        Map<LottoResult, Integer> winningResult = lottoBundle.checkWinningResult(winningLotto);

        assertThat(winningResult.get(lottoResult)).isEqualTo(1);
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

    @Test
    void 로또_여러개_구매() {
        LottoBundle lottoBundle = new LottoBundle(new LottoRandomGenerator(), 5000);
        assertThat(lottoBundle.lottoCount()).isEqualTo(5);
        assertThat(lottoBundle.purchasedPrice()).isEqualTo(5000);
    }

}
