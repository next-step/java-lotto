package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoResultTest {
    @Test
    void 총_당첨_금액() {
        Lotto winLotto = new Lotto(1, 2, 3, 4, 5, 6);

        LottoGroup lottoGroup = new LottoGroup(
                List.of(
                new Lotto(1, 2, 3, 9, 8, 7),
                new Lotto(1, 2, 3, 44, 15, 26),
                new Lotto(1, 2, 31, 34, 45, 36)
            )
        );

        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winLotto, new LottoNumber(1));
        LottoResult lottoResult = lottoGroup.match(lottoWinningNumbers);

        Assertions.assertThat(lottoResult.calTotal()).isEqualTo(new Money(10000));
    }

    @Test
    void 해당_랭크의_개수() {
        Lotto winLotto = new Lotto(1, 2, 3, 4, 5, 6);

        LottoGroup lottoGroup = new LottoGroup(
                List.of(
                        new Lotto(1, 2, 3, 9, 8, 7),
                        new Lotto(1, 2, 3, 44, 15, 26)
                )
        );

        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winLotto, new LottoNumber(1));

        LottoResult lottoResult = lottoGroup.match(lottoWinningNumbers);

        Assertions.assertThat(lottoResult.getCntByLottoRank(LottoRank.FIFTH)).isEqualTo(2);
    }
}
