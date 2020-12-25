package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    LottoTicket lottoTicket = new LottoTicket();
    List<Integer> list = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    List<Integer> target = new ArrayList<>();
    Lotto lotto;

    @BeforeEach
    void setup() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        lottoTicket.addLottoNumbers(new Lotto(list));

        list2.add(2);
        list2.add(3);
        list2.add(5);
        lottoTicket.addLottoNumbers(new Lotto(list2));

        target.add(1);
        target.add(2);
        target.add(3);
        target.add(4);
        target.add(5);
        lotto = new Lotto(target);
    }

    @Test
    void getRank_test() {
        List<Rank> rankOf = new ArrayList<>();
        rankOf.add(Rank.valueOf(5));
        rankOf.add(Rank.valueOf(3));

        assertThat(lottoTicket.getMatch(lotto.convertLottoNumbers())).isEqualTo(rankOf);
    }

    @Test
    void matchLottoCount_test() {
        assertThat(lottoTicket.getMatchLottoCount(target).size()).isEqualTo(2);
    }
}