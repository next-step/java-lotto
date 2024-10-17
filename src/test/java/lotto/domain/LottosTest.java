package lotto.domain;

import fixture.LottoFixture;
import lotto.enums.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static lotto.enums.Rank.FIRST_RANK;
import static lotto.enums.Rank.SECOND_RANK;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("두 로또를 합친다.")
    void 로또_합침() {
        Lotto lotto1 = LottoFixture.createLottoFixture(1, 2, 3, 4, 5, 6);
        Lotto lotto2 = LottoFixture.createLottoFixture(2, 3, 4, 5, 6, 7);
        Lottos lottos1 = new Lottos(Collections.singletonList(lotto1));
        Lottos lottos2 = new Lottos(Collections.singletonList(lotto2));
        Assertions.assertThat(Lottos.of(lottos1, lottos2)).isEqualTo(new Lottos(List.of(lotto1, lotto2)));
    }

    @Test
    @DisplayName("로또 결과 리스트를 반환한다.")
    void 결과_리스트_반환() {
        Lottos lottos = new Lottos(List.of(LottoFixture.createLottoFixture(1, 2, 3, 4, 5, 6), LottoFixture.createLottoFixture(2, 3, 4, 5, 6, 7)));
        WinnerLotto winner = new WinnerLotto(LottoFixture.createLottoFixture(1, 2, 3, 4, 5, 6), LottoNum.valueOf(7));
        List<Rank> ranks = lottos.getRanks(winner);
        assertThat(ranks).hasSize(2);
        assertThat(ranks).contains(FIRST_RANK, SECOND_RANK);
    }

    @Test
    @DisplayName("로또 리스트를 받으면 Lottos 객체를 생성한다.")
    void Lottos_객체_생성() {
        List<Lotto> lottos = List.of(LottoFixture.createLottoFixture(1, 2, 3, 4, 5, 6), LottoFixture.createLottoFixture(2, 3, 4, 5, 6, 7));
        assertThat(new Lottos(lottos).getSize()).isEqualTo(2);
    }
}
