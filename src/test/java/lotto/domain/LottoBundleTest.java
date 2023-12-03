package lotto.domain;

import lotto.strategy.LottoRandomGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBundleTest {

    @ParameterizedTest
    @MethodSource("LottoResultProvider")
    void 로또_당첨결과_확인(Lotto lotto, LottoResult lottoResult) {
        LottoBundle lottoBundle = new LottoBundle(List.of(lotto));
        WinningLotto winningLotto = new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), new LottoNumber(7));

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
        assertThat(lottoBundle.totalLottoCount()).isEqualTo(5);
        assertThat(lottoBundle.purchasedPrice()).isEqualTo(5000);
    }

    @Test
    void 로또_수동_구매() {
        List<Lotto> manualLottoList = Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(7, 8, 9, 10, 11, 12),
                new Lotto(13, 14, 15, 16, 17, 18)
        );
        LottoBundle lottoBundle = new LottoBundle(new LottoRandomGenerator(), 5000, manualLottoList);
        assertThat(lottoBundle.manualCount()).isEqualTo(3);
        assertThat(lottoBundle.automaticCount()).isEqualTo(2);
    }

    @Test
    void 로또구매_개수보다_수동개수를_더_많이_입력한_경우_오류() {
        List<Lotto> manualLottoList = Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(7, 8, 9, 10, 11, 12),
                new Lotto(13, 14, 15, 16, 17, 18),
                new Lotto(19, 20, 21, 22, 23, 24),
                new Lotto(25, 26, 27, 28, 29, 30),
                new Lotto(31, 32, 33, 34, 35, 36)
        );

        assertThatThrownBy(() -> {
            new LottoBundle(new LottoRandomGenerator(), 5000, manualLottoList);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매한 로또 개수는 5개입니다. 5개 이하로 입력해주세요.");
    }

    @Test
    void 수동로또_정보확인() {
        List<Lotto> manualLottoList = Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(7, 8, 9, 10, 11, 12),
                new Lotto(13, 14, 15, 16, 17, 18)
        );

        LottoBundle lottoBundle = new LottoBundle(new LottoRandomGenerator(), 5000, manualLottoList);

        List<Lotto> lottoList = lottoBundle.lottoList();
        assertThat(lottoList.get(0)).usingRecursiveComparison().isEqualTo(manualLottoList.get(0));
        assertThat(lottoList.get(1)).usingRecursiveComparison().isEqualTo(manualLottoList.get(1));
        assertThat(lottoList.get(2)).usingRecursiveComparison().isEqualTo(manualLottoList.get(2));
    }

}
