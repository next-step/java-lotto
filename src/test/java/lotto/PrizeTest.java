package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    private String[] number, otherNumber;
    private List<Lotto> lottoList;
    private Lottos lottos;
    private Lotto lotto;
    private Prize prize;

    @BeforeEach
    void initData() {
        number = new String[]{"1", "2", "3", "7", "5", "6"};
        otherNumber = new String[]{"1", "2", "3", "4", "9", "10"};
        lottoList = new ArrayList<>();
        lottoList.add(new Lotto(otherNumber));
        lottos = new Lottos(lottoList);
        lotto = new Lotto(number);
        prize = new Prize(lottos, lotto);
    }

    @DisplayName("맞춘 개수에 따른 결과(Rank) 값 반환")
    @Test
    void prize() {
        // GIVE
        //WHEN
        //TAHT
        assertThat(prize.getPrize().get(Rank.FOURTH)).isEqualTo(1);
    }

    @DisplayName("맞춘 개수에 따른 수익률 반환")
    @Test
    void calYield() {
        // GIVE
        //WHEN
        //TAHT
        assertThat(prize.calYield(1000)).isEqualTo(5.0);
    }
}
