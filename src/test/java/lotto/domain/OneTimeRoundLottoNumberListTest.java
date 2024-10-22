package lotto.domain;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OneTimeRoundLottoNumberListTest {

    @Test
    public void 로또당첨금액_6자리미만테스트() {
        List<Integer> lottoWinnerNumberList = List.of(1,2,3);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            OneTimeRoundLottoNumberList oneTimeRoundLottoNumberList = new OneTimeRoundLottoNumberList(lottoWinnerNumberList);
        });
    }
}