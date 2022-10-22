package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class LottoTest {

    @Test
    void 로또를_출력() {
        LottoNumberStrategy lottoNumberStrategy = () -> Number.of(16, 15, 14, 13, 12, 11);
        Lotto lotto = Lotto.create(lottoNumberStrategy);
        Assertions.assertThat(lotto).isEqualTo(
            new Lotto(
                Number.of(11, 12, 13, 14, 15, 16)
            )
        );
    }

    @Test
    void 당첨_번호로_로또_등수_확인() {
        LottoNumberStrategy lottoNumberStrategy = () -> Number.of(16, 15, 14, 13, 12, 11);
        Lotto lotto = Lotto.create(lottoNumberStrategy);
        Assertions.assertThat(lotto.checkRank(new WinnerNumbers(Number.of(12, 14, 15, 20, 22, 24), Number.of(25))))
            .isEqualTo(Rank.FIFTH);
    }

    @Test
    void 로또의_숫자_갯수는_6개_이다() {
        Assertions.assertThatThrownBy(() -> new Lotto(Number.of(1, 2)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또의 숫자 갯수는 6개 입니다.");
    }

    @Test
    void 로또는_정렬을_위해_TreeSet만_사용가능() {
        Assertions.assertThatThrownBy(() -> new Lotto(new HashSet<>(Number.of(1, 2, 3, 4, 5, 6))))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또는 정렬을 위해 TreeSet 만 이용 가능합니다.");
    }

    @Test
    void 등수확인() {
        Lotto first = new Lotto(Number.of(1, 2, 3, 4, 5, 6));
        Lotto second = new Lotto(Number.of(2, 3, 4, 5, 6, 7));
        Lotto third = new Lotto(Number.of(2, 3, 4, 5, 6, 8));
        Lotto fourth = new Lotto(Number.of(3, 4, 5, 6, 7, 8));
        Lotto fifth = new Lotto(Number.of(4, 5, 6, 7, 8, 9));

        WinnerNumbers winnerNumbers = new WinnerNumbers(Number.of(1, 2, 3, 4, 5, 6), Number.of(7));

        Assertions.assertThat(first.checkRank(winnerNumbers)).isEqualTo(Rank.FIRST);
        Assertions.assertThat(second.checkRank(winnerNumbers)).isEqualTo(Rank.SECOND);
        Assertions.assertThat(third.checkRank(winnerNumbers)).isEqualTo(Rank.THIRD);
        Assertions.assertThat(fourth.checkRank(winnerNumbers)).isEqualTo(Rank.FOURTH);
        Assertions.assertThat(fifth.checkRank(winnerNumbers)).isEqualTo(Rank.FIFTH);
    }
}
