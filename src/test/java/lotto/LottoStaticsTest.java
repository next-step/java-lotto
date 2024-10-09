package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class LottoStaticsTest {

    @Test
    void 생성() {
        LottoStatics lottoStatics = new LottoStatics();

        assertThat(lottoStatics).isEqualTo(new LottoStatics());
    }

    @Test
    void 추가() {
        LottoStatics lottoStatics = new LottoStatics();

        lottoStatics.add(new Lotto());

        assertThat(lottoStatics).isEqualTo(new LottoStatics(List.of(new Lotto())));
    }

    @Test
    void 로또들과_당첨_번호를_넘기면_통계_결과를_준다() {
        List<Lotto> lottos = List.of(
            new Lotto(List.of(1, 2, 3, 11, 12, 13)),
            new Lotto(List.of(1, 2, 3, 4, 12, 7)),
            new Lotto(List.of(1, 2, 3, 4, 5, 8)),
            new Lotto(List.of(1, 2, 3, 4, 5, 8)),
            new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );
        LottoStatics lottoStatics = new LottoStatics(lottos);
        List<Integer> winnerNumber = List.of(1, 2, 3, 4, 5, 6);
        int matchThree = 3;
        int matchFour = 4;
        int matchFive = 5;
        int matchSix = 6;

        int resultThree = lottoStatics.match(winnerNumber, matchThree);
        int resultFour = lottoStatics.match(winnerNumber, matchFour);
        int resultFive = lottoStatics.match(winnerNumber, matchFive);
        int resultSix = lottoStatics.match(winnerNumber, matchSix);

        assertThat(resultThree).isEqualTo(1);
        assertThat(resultFour).isEqualTo(1);
        assertThat(resultFive).isEqualTo(2);
        assertThat(resultSix).isEqualTo(1);
    }

    @Test
    void 수익률을_계산한다() {
        int money = 14000;
        List<Lotto> lottos = List.of(
            new Lotto(List.of(8, 21, 23, 41, 42, 43)),
            new Lotto(List.of(3, 5, 11, 16, 32, 38)),
            new Lotto(List.of(7, 11, 16, 35, 36, 44)),
            new Lotto(List.of(1, 8, 11, 31, 41, 42)),
            new Lotto(List.of(13, 14, 16, 38, 42, 45)),
            new Lotto(List.of(7, 11, 30, 40, 42, 43)),
            new Lotto(List.of(2, 13, 22, 32, 38, 45)),
            new Lotto(List.of(23, 25, 33, 36, 39, 41)),
            new Lotto(List.of(1, 3, 5, 14, 22, 45)),
            new Lotto(List.of(5, 9, 38, 41, 43, 44)),
            new Lotto(List.of(2, 8, 9, 18, 19, 21)),
            new Lotto(List.of(13, 14, 18, 21, 23, 35)),
            new Lotto(List.of(17, 21, 29, 37, 42, 45)),
            new Lotto(List.of(3, 8, 27, 30, 35, 44))
        );
        LottoStatics lottoStatics = new LottoStatics(lottos);
        List<Integer> winnerNumber = List.of(1, 2, 3, 4, 5, 6);

        double ratio = lottoStatics.calculateRatio(winnerNumber, money);

        assertThat(ratio).isEqualTo(0.35);
    }
}
