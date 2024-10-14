package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static lotto.domain.LottoNumbers.LOTTO_NUMBER_COUNT;
import static lotto.domain.LottoNumbers.LOTTO_NUMBER_SET;
import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoNumbersTest {
    @Test
    void generate_로또번호모음을_생성하여_반환한다() {
        LottoNumbers lottoNumbers = LottoNumbers.generate();
        List<Integer> lottoNumbersValue = lottoNumbers.getLottoNumbers();

        assertThat(new HashSet<>(lottoNumbersValue)).hasSize(LOTTO_NUMBER_COUNT);
        lottoNumbersValue.forEach(lottoNumber -> assertThat(lottoNumber).isIn(LOTTO_NUMBER_SET));
    }

    @Test
    void getMatchedNumberCount_인자로_받은_로또와_일치하는_개수를_반환한다() {
        LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
        WinningLottoNumbers winningNumbers = new WinningLottoNumbers(1, 2, 3, 7, 8, 9);

        assertThat(winningNumbers.getMatchedNumberCount(lottoNumbers)).isEqualTo(3);
    }
}
