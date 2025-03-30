package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    @Test
    void getLottoMatch_0match() {
        List<Integer> lottoNumbers = Arrays.asList(5, 6, 7, 10, 11, 12);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 40, 41, 42);

        Lotto lotto = new Lotto(lottoNumbers);
        LottoMatch result = lotto.getLottoMatch(winningNumbers);

        assertThat(result).isEqualTo(LottoMatch.NONE);
    }

    @Test
    void getLottoMatch_3match() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 10, 11, 12);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 40, 41, 42);

        Lotto lotto = new Lotto(lottoNumbers);
        LottoMatch result = lotto.getLottoMatch(winningNumbers);

        assertThat(result).isEqualTo(LottoMatch.THREE);
    }

    @Test
    void getLottoMatch_6match() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 10, 11, 12);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 10, 11, 12);

        Lotto lotto = new Lotto(lottoNumbers);
        LottoMatch result = lotto.getLottoMatch(winningNumbers);

        assertThat(result).isEqualTo(LottoMatch.SIX);
    }

}
