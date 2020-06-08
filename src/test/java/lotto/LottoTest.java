package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또 생성 테스트")
    @Test
    void LOTTO_NUMBER_COUNT() {
        assertThat(new Lotto(5).getLottoNumbers()).hasSize(5);
    }

    @DisplayName("로또 당번호 테스트")
    @Test
    void USER_WINNER_NUMBER() {
        Lotto lotto = new Lotto(5);
        List<List<Integer>> lottoNumbers = lotto.getLottoNumbers();

        String[] winnerExpected = lottoNumbers.get(0).stream().map(n -> n.toString()).toArray(String[]::new);

        assertThat(lotto.getLottoWinnerNumbers(winnerExpected).get(0)).isEqualTo(winnerExpected.length);
    }




}
