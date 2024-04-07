package lottoTest;

import java.util.List;
import lotto.Lotto;
import lotto.LottoNumber;
import lotto.LottoRank;
import lotto.LottoResult;
import lotto.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    private static final Lottos lottos = Lottos.of(
        List.of(
            Lotto.of("1", "2", "3", "4", "5", "6")
        ));

    @Test
    @DisplayName("로또 결과 1등")
    void COMPARE_WINNING_LOTTO_THEN_FIRST_PRIZE() {
        Lotto lotto = Lotto.of("1", "2", "3", "4", "5", "6");
        LottoNumber bonus = new LottoNumber(7);

        LottoResult result = new LottoResult(LottoRank.FIRST);

        Assertions.assertThat(lottos.getWinningResult(lotto, bonus)).isEqualTo(result);
    }

    @Test
    @DisplayName("로또 결과 2등")
    void COMPARE_WINNING_LOTTO_WITH_SECOND_PRIZE() {
        Lotto lotto = Lotto.of("1", "2", "3", "4", "5", "7");
        LottoNumber bonus = new LottoNumber(6);

        LottoResult result = new LottoResult(LottoRank.SECOND);

        Assertions.assertThat(lottos.getWinningResult(lotto, bonus)).isEqualTo(result);
    }

    @Test
    @DisplayName("로또 결과 3등")
    void COMPARE_WINNING_LOTTO_WITH_THIRD_PRIZE() {
        Lotto lotto = Lotto.of("1", "2", "3", "4", "5", "9");
        LottoNumber bonus = new LottoNumber(10);

        LottoResult result = new LottoResult(LottoRank.THIRD);

        Assertions.assertThat(lottos.getWinningResult(lotto, bonus)).isEqualTo(result);
    }

}
