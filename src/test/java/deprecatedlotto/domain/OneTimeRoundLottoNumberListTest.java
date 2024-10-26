package deprecatedlotto.domain;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OneTimeRoundLottoNumberListTest {

    public static final List<Integer> TEST_LOTTO_WINNER_NUMBER_LIST = List.of(1, 2, 3);

    @Test
    public void 로또당첨금액_6자리미만테스트() {
        List<Integer> lottoWinnerNumberList = TEST_LOTTO_WINNER_NUMBER_LIST;
        assertThatIllegalArgumentException().isThrownBy(() -> {
            OneTimeRoundLottoNumberList oneTimeRoundLottoNumberList = new OneTimeRoundLottoNumberList(lottoWinnerNumberList);
        });
    }
}