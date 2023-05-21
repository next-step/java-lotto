package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.LottoFixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinLottoTest {

    @Test
    void 지난주당첨번호() {
        WinLotto winLotto = winLottoFixture(List.of(1, 8, 11, 31, 41, 42));

        LottoNumbers lottoNumbers = lottoNumbersFixture(List.of(1, 8, 11, 31, 41, 42));

        assertThat(winLotto.numbers()).isEqualTo(lottoNumbers);
    }

    @Test
    void 지난주당첨번호with보너스번호() {
        WinLotto winLotto = winLottoWithBonusFixture(List.of(1, 3, 11, 13, 21, 23), LottoNo.of(31));
        LottoNumbers lottoNumbers = lottoNumbersFixture(List.of(1, 3, 11, 13, 21, 23));

        assertAll(
                () -> assertThat(winLotto.numbers()).isEqualTo(lottoNumbers),
                () -> assertThat(winLotto.bonusNumber()).isEqualTo(LottoNo.of(31))
        );
    }

    @Test
    void 당첨() {
        WinLotto winLotto = winLottoFixture(List.of(31, 32, 33, 34, 35, 36));
        Rank rank1 = winLotto.checkRank(lottoFixture(List.of(31, 32, 33, 34, 35, 36)));
        Rank rank2 = winLotto.checkRank(lottoFixture(List.of(11, 32, 33, 34, 35, 36)));
        assertAll(
                () -> assertThat(rank1).isEqualTo(Rank.FIRST),
                () -> assertThat(rank2).isEqualTo(Rank.THIRD)
        );
    }

    @Test
    void 미당첨() {
        WinLotto winLotto = winLottoFixture(List.of(31, 32, 33, 34, 35, 36));
        Rank rank = winLotto.checkRank(lottoFixture(List.of(11, 12, 13, 14, 35, 36)));
        assertThat(rank).isEqualTo(Rank.NONE);
    }

    @Test
    void 당첨_2등() {
        WinLotto winLotto = winLottoWithBonusFixture(List.of(31, 32, 33, 34, 35, 36), LottoNo.of(11));
        Rank rank = winLotto.checkRank(lottoFixture(List.of(11, 32, 33, 34, 35, 36)));
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
