package lottoauto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @Test
    void 구입금액만큼_발급() {
        Lottos lottos = Lottos.from(14000);
        System.out.println(lottos);
        assertThat(lottos.size()).isEqualTo(14);
    }

    @Test
    void 구입금액만큼_발급_수동구매() {
        List<Lotto> manualLottos = new ArrayList<>(
                List.of(
                        Lotto.from("8, 21, 23, 41, 42, 43"),
                        Lotto.from("3, 5, 11, 16, 32, 38"),
                        Lotto.from("7, 11, 16, 35, 36, 44")
                )
        );
        Lottos lottos = Lottos.of(14000, manualLottos);
        System.out.println(lottos);
        int theNumberOfAutoLottos = lottos.size() - manualLottos.size();
        assertThat(theNumberOfAutoLottos).isEqualTo(11);
    }

    @Test
    void 당첨_통계_확인() {
        String[] numberInput = "1,2,3,4,5,6".split(",");
        Lottos lottos = Lottos.from(new ArrayList<>(List.of(
                Lotto.from(numberInput),
                Lotto.from(numberInput))
        ));
        WinningLotto winningLotto = WinningLotto.from(Lotto.from(numberInput));

        RatingStatics ratingStatics = lottos.findRatingStatics(winningLotto);
        System.out.println(ratingStatics.toString());
        assertThat(ratingStatics).isNotNull();
    }
}