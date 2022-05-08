package lottoauto.domain;

import lottoauto.domain.Lotto;
import lottoauto.domain.Lottos;
import lottoauto.domain.RatingStatics;
import lottoauto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    private Lottos lottos;
    private WinningLotto winningLotto;
    private String[] numberInput;

    @BeforeEach
    void setUp() {
        numberInput = "1,2,3,4,5,6".split(",");
        lottos = Lottos.from(new ArrayList<>(List.of(Lotto.from(numberInput), Lotto.from(numberInput))));
        winningLotto = WinningLotto.from(Lotto.from(numberInput));
    }

    @Test
    void 구입금액만큼_발급() {
        Lottos lottos = Lottos.from(14000);
        System.out.println(lottos);
        assertThat(lottos.size()).isEqualTo(14);
    }

    @Test
    void 당첨_통계_확인() {
        RatingStatics ratingStatics = lottos.findRatingStatics(winningLotto);
        System.out.println(ratingStatics.toString());
        assertThat(ratingStatics).isNotNull();
    }

}