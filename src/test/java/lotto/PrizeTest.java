package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.Prize;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    private List<Number> number, otherNumber;
    private List<Lotto> lottoList;
    private Lottos lottos;
    private Lotto lastLotto;
    private Prize prize;

    @BeforeEach
    void initData() {
        number = Arrays.asList(new Number(1),new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        otherNumber = Arrays.asList(new Number(1),new Number(2), new Number(3), new Number(4), new Number(5), new Number(8));
        lottoList = new ArrayList<>();
        lottoList.add(new Lotto(otherNumber));
        lottos = new Lottos(() -> lottoList);
        lastLotto = new Lotto(number);
        prize = new Prize(lottos, lastLotto, new Number(8));
    }

    @DisplayName("맞춘 개수에 따른 결과(Rank) 값 반환")
    @Test
    void prize() {
        // GIVE
        //WHEN
        //TAHT
        assertThat(prize.getPrize().get(Rank.SECOND))
                .isEqualTo(1);
    }

    @DisplayName("맞춘 개수에 따른 수익률 반환")
    @Test
    void calYield() {
        // GIVE
        //WHEN
        //TAHT
        assertThat(prize.calYield(1000)).isEqualTo(1500.0);
    }
}
