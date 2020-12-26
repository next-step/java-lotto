package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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

        target.add(1);
        target.add(2);
        target.add(3);
        target.add(4);
        target.add(5);
        lotto = new Lotto(target);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void getRank_test(boolean isBonus) {
        List<Rank> rankOf = new ArrayList<>();
        rankOf.add(Rank.valueOf(5, isBonus));

//        System.out.println(lottoTicket.getMatch(lotto.convertLottoNumbers(), isBonus));
        assertThat(lottoTicket.getMatch(lotto.convertLottoNumbers(), isBonus)).isEqualTo(rankOf);
    }

    @Test
    void bonusMatch_test() {
//        System.out.println(lottoTicket.getMatchLottoCount(target, 5));
//        System.out.println(lottoTicket.getMatchLottoCount(target, 7));

        assertAll(
                () -> assertThat(lottoTicket.getMatchLottoCount(target, 5).containsKey(Rank.SECOND)).isTrue(),
                () -> assertThat(lottoTicket.getMatchLottoCount(target, 7).containsKey(Rank.SECOND)).isFalse()
        );
    }
}