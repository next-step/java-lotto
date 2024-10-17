package lotto.domain;

import fixture.LottoFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.enums.Rank.FIFTH_RANK;
import static lotto.enums.Rank.FIRST_RANK;
import static lotto.enums.Rank.FOURTH_RANK;
import static lotto.enums.Rank.SECOND_RANK;
import static lotto.enums.Rank.THIRD_RANK;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    @DisplayName("로또 리스트를 받았을 때,수익률 추출")
    void 당첨_금액_수익률() {
        Lotto lotto1 = LottoFixture.createLottoFixture(1, 2, 3, 4, 5, 6);
        Lotto lotto2 = LottoFixture.createLottoFixture(1, 2, 3, 4, 5, 7);
        Lotto lotto3 = LottoFixture.createLottoFixture(1, 2, 3, 4, 7, 8);
        Lotto lotto4 = LottoFixture.createLottoFixture(1, 2, 3, 7, 8, 9);
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4));
        Lotto winner = LottoFixture.createLottoFixture(1, 2, 3, 4, 5, 6);
        assertThat(LottoResult.getLottoResult(lottos, new WinnerLotto(winner, LottoNum.valueOf(10))).getReturnRate()).isEqualTo(500388.75);
    }

    @Test
    @DisplayName("로또 리스트를 받았을 때,당첨 금액 추출")
    void 당첨_금액_추출() {
        Lotto lotto1 = LottoFixture.createLottoFixture(1, 2, 3, 4, 5, 6);
        Lotto lotto2 = LottoFixture.createLottoFixture(1, 2, 3, 4, 5, 7);
        Lotto lotto3 = LottoFixture.createLottoFixture(1, 2, 3, 4, 7, 8);
        Lotto lotto4 = LottoFixture.createLottoFixture(1, 2, 3, 7, 8, 9);
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4));
        Lotto winner = LottoFixture.createLottoFixture(1, 2, 3, 4, 5, 6);
        assertThat(LottoResult.getLottoResult(lottos, new WinnerLotto(winner, LottoNum.valueOf(7))).getPriceTotal()).isEqualTo(2030055000);
    }

    @Test
    @DisplayName("로또 리스트를 받았을 때,당첨 결과 리스트 추출")
    void 로또_리스트로_당첨_결과_생성() {
        Lotto lotto1 = LottoFixture.createLottoFixture(1, 2, 3, 4, 5, 6);
        Lotto lotto2 = LottoFixture.createLottoFixture(1, 2, 3, 4, 5, 7);
        Lotto lotto3 = LottoFixture.createLottoFixture(1, 2, 3, 4, 7, 8);
        Lotto lotto4 = LottoFixture.createLottoFixture(1, 2, 3, 7, 8, 9);
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4));
        Lotto winner = LottoFixture.createLottoFixture(1, 2, 3, 4, 5, 6);
        assertThat(LottoResult.getLottoResult(lottos, new WinnerLotto(winner, LottoNum.valueOf(20)))).isEqualTo(new LottoResult(new Ranks(List.of(FIRST_RANK, THIRD_RANK, FOURTH_RANK, FIFTH_RANK)), 4000));
    }

    @Test
    @DisplayName("로또 결과에서 수익률 반환")
    void 당첨_수익률_생성() {
        assertThat(new LottoResult(new Ranks(List.of(FIRST_RANK, THIRD_RANK)), 10000).getReturnRate()).isEqualTo(200150);
    }

    @Test
    @DisplayName("로또 결과에서 당첨금액 합산한 값 반환")
    void 당첨_결과_2등() {
        assertThat(new LottoResult(new Ranks(List.of(SECOND_RANK)), 14000).getPriceTotal()).isEqualTo(30000000);
    }

    @Test
    @DisplayName("로또 결과에서 당첨금액 합산한 값 반환")
    void 당첨_결과_생성() {
        assertThat(new LottoResult(new Ranks(List.of(FIRST_RANK, THIRD_RANK)), 14000).getPriceTotal()).isEqualTo(2001500000);
    }
}
