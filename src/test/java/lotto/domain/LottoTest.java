package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void duplicate_Lotto_Tickets() {
        Lotto lotto_one = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto_two = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto_one.getNumberList()).isEqualTo(lotto_two.getNumberList());
    }

    @Test
    void compare_Lotto_Rank() {
        List<Integer> numberList = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winnerNumberList = List.of(1, 2, 3, 4, 5, 7);

        Lotto lotto = new Lotto(numberList);
        Lotto rank = lotto.matchRank(winnerNumberList);

        System.out.println(lotto);
        System.out.println(rank);
        System.out.println(winnerNumberList);

        assertThat(rank.getRank()).isEqualTo(Rank.SECOND);
    }

}
