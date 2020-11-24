package step3.lotto.domain.numbers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class lottoRankTest {

    @Test
    void 순위_1등_테스트() {
        LottoRank lottoRank = new LottoRank(7, getList(6));
        SortedSet<Integer> sortedSet = new TreeSet<>(getList(6));

        assertThat(1).isEqualTo(lottoRank.getRank(sortedSet));
    }

    @Test
    void 순위_2등_테스트() {
        List<Integer> list = getList(6);
        LottoRank lottoRank = new LottoRank(7, list);

        list = getList(5);
        list.add(7);
        SortedSet<Integer> sortedSet = new TreeSet<>(list);

        assertThat(2).isEqualTo(lottoRank.getRank(sortedSet));
    }

    @Test
    void 순위_3등_테스트() {
        List<Integer> list = getList(6);
        LottoRank lottoRank = new LottoRank(7, list);

        list = getList(5);
        list.add(8);
        SortedSet<Integer> sortedSet = new TreeSet<>(list);

        assertThat(3).isEqualTo(lottoRank.getRank(sortedSet));
    }

    @Test
    void 순위_4등_테스트() {
        List<Integer> list = getList(6);
        LottoRank lottoRank = new LottoRank(7, list);

        list = getList(4);
        list.add(8);
        list.add(9);
        SortedSet<Integer> sortedSet = new TreeSet<>(list);

        assertThat(4).isEqualTo(lottoRank.getRank(sortedSet));
    }

    @Test
    void 순위_5등_테스트() {
        List<Integer> list = getList(6);
        LottoRank lottoRank = new LottoRank(7, list);

        list = getList(3);
        list.add(8);
        list.add(9);
        list.add(10);
        SortedSet<Integer> sortedSet = new TreeSet<>(list);

        assertThat(5).isEqualTo(lottoRank.getRank(sortedSet));
    }

    private List<Integer> getList(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            list.add(i);
        }

        return list;
    }
}
