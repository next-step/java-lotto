package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PrizeTest {

    @Test
    @DisplayName("구매한 로또 결과 확인")
    void findPrize() {
        Lotto beforeLotto = Lotto.manual(List.of(1, 2, 3, 4, 5, 6));
        Lotto first = Lotto.manual(List.of(1, 2, 3, 4, 5, 6));
        Lotto second = Lotto.manual(List.of(1, 2, 3, 4, 5, 0));
        Lotto third = Lotto.manual(List.of(1, 2, 3, 4, 6, 0));
        Lotto forth = Lotto.manual(List.of(1, 2, 3, 4, 0, 0));
        Lotto fifth = Lotto.manual(List.of(1, 2, 3, 0, 0, 0));
        Lotto miss = Lotto.manual(List.of(1, 2, 0, 0, 0, 0));

        assertAll(() -> assertThat(Prize.work(beforeLotto, List.of(first)).getRanks()).containsKeys(Rank.FIRST).containsValue(Number.of(1)),
                () -> assertThat(Prize.work(beforeLotto, List.of(second)).getRanks()).containsKeys(Rank.SECOND).containsValue(Number.of(1)),
//                () -> assertThat(Prize.work(beforeLotto, List.of(third)).getRanks()).containsKeys(Rank.THIRD).containsValue(Number.of(1)),
                () -> assertThat(Prize.work(beforeLotto, List.of(forth)).getRanks()).containsKeys(Rank.FORTH).containsValue(Number.of(1)),
                () -> assertThat(Prize.work(beforeLotto, List.of(fifth)).getRanks()).containsKeys(Rank.FIFTH).containsValue(Number.of(1)),
                () -> assertThat(Prize.work(beforeLotto, List.of(miss)).getRanks()).containsKeys(Rank.MISS).containsValue(Number.of(1)));
    }
}
