package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    private List<LottoNumber> numbers(int min, int max) {
        return IntStream.range(min, max).boxed().map(v -> new LottoNumber(v)).collect(Collectors.toList());
    }

    @Test
    void 랭킹_목록() {
        assertThat(Rank.values()).isEqualTo(Rank.values());
    }

    @Test
    void 당첨_1등() {
        assertThat(Rank.RankOf(6)).isEqualTo(Rank.FIRST);
    }

    @Test
    void 랭킹_계산하기() {
        Lotto winner = new Lotto(numbers(1, 7));
        List<Lotto> myLotto = new ArrayList<>();
        myLotto.add(new Lotto(numbers(1, 7))); // 6개 일치, 1등
        myLotto.add(new Lotto(numbers(4, 10))); // 4개 일치, 3등

        List<Rank> ranking = new ArrayList<>();
        Rank.FIRST.plusCount();
        Rank.THIRD.plusCount();
        for (Rank rank : Rank.values()) {
            ranking.add(rank);
        }

        assertThat(Rank.calculate(winner, myLotto)).containsAll(ranking);
    }
}
