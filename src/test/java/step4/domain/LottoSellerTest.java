package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSellerTest {

    @DisplayName("LottoPaper에 맞게 로또를 반환한다.")
    @Test
    void buyTest() {
        LottoPaper lottoPaper = LottoPaper.of(1, Arrays.asList("1,2,3,4,5,6"));

        LottoSeller lottoSeller = new LottoSeller(() -> Lotto.of("7,8,9,10,11,12"));
        Lottos buy = lottoSeller.buy(lottoPaper);

        assertThat(buy.count()).isEqualTo(2);
        assertThat(buy).isEqualTo(
                Lottos.of(Arrays.asList(
                        Lotto.of("1,2,3,4,5,6"),
                        Lotto.of("7,8,9,10,11,12")
                ))
        );
    }

}
