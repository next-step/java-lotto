package lotto;

import lotto.model.LottoNumbers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoNumbersTest {

    LottoNumbers lottoNumbers = new LottoNumbers();
    private static final int GAME_COUNT = 5;
    private static final int LOTTO_NUMBER_LENGTH = 6;

    @Test
    void 로또_게임수만큼_로또넘버_자동생성() {
        List<List<Integer>> lottoNumberList = lottoNumbers.getLottoNumbers(GAME_COUNT);
        for (List<Integer> lottoNumbers : lottoNumberList) {
            assertThat(lottoNumbers.size()).isEqualTo(LOTTO_NUMBER_LENGTH);
        }
        assertThat(lottoNumberList.size()).isEqualTo(GAME_COUNT);
    }



}
