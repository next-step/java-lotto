package step4.lotto.domain.numbers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class lottoRankTest {

    private LottoTicket lottoTicket;
    private List<Integer> compareData;

    @Test
    void 순위_1등_테스트() {
        lottoTicket = new LottoTicket(getList(6));
        LottoRank lottoRank = new LottoRank(7, lottoTicket);
        SortedSet<Integer> sortedSet = new TreeSet<>(getList(6));

        assertThat(1).isEqualTo(lottoRank.getRank(sortedSet));
    }

    @Test
    void 순위_2등_테스트() {
        lottoTicket = new LottoTicket(getList(6));
        LottoRank lottoRank = new LottoRank(7, lottoTicket);

        compareData = getList(5);
        compareData.add(7);
        SortedSet<Integer> sortedSet = new TreeSet<>(compareData);

        assertThat(2).isEqualTo(lottoRank.getRank(sortedSet));
    }

    @Test
    void 순위_3등_테스트() {
        lottoTicket = new LottoTicket(getList(6));
        LottoRank lottoRank = new LottoRank(7, lottoTicket);

        compareData = getList(5);
        compareData.add(8);
        SortedSet<Integer> sortedSet = new TreeSet<>(compareData);

        assertThat(3).isEqualTo(lottoRank.getRank(sortedSet));
    }

    @Test
    void 순위_4등_테스트() {
        lottoTicket = new LottoTicket(getList(6));
        LottoRank lottoRank = new LottoRank(7, lottoTicket);

        compareData = getList(4);
        compareData.add(8);
        compareData.add(9);
        SortedSet<Integer> sortedSet = new TreeSet<>(compareData);

        assertThat(4).isEqualTo(lottoRank.getRank(sortedSet));
    }

    @Test
    void 순위_5등_테스트() {
        lottoTicket = new LottoTicket(getList(6));
        LottoRank lottoRank = new LottoRank(7, lottoTicket);

        compareData = getList(3);
        compareData.add(8);
        compareData.add(9);
        compareData.add(10);
        SortedSet<Integer> sortedSet = new TreeSet<>(compareData);

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
