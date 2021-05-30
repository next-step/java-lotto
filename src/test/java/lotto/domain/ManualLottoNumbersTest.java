package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ManualLottoNumbersTest {

    @Test
    void constructor() {
        // given
        List<LottoNumberText> lottoNumberTextList = Arrays.asList(new LottoNumberText("1,2,3,4,5,6"), new LottoNumberText("1,2,3,4,5,6"));

        // then
        assertThat(new ManualLottoNumbers(lottoNumberTextList)).isNotNull();
    }

    @Test
    void count() {
        // given
        List<LottoNumberText> lottoNumberTextList = Arrays.asList(new LottoNumberText("1,2,3,4,5,6"), new LottoNumberText("1,2,3,4,5,6"));
        ManualLottoNumbers manualLottoNumbers = new ManualLottoNumbers(lottoNumberTextList);

        // when
        int count = manualLottoNumbers.count();

        // then
        assertThat(count).isEqualTo(lottoNumberTextList.size());
    }

    @Test
    void toList() {
        // given
        List<LottoNumberText> lottoNumberTextList = Arrays.asList(new LottoNumberText("1,2,3,4,5,6"), new LottoNumberText("1,2,3,4,5,6"));
        ManualLottoNumbers manualLottoNumbers = new ManualLottoNumbers(lottoNumberTextList);

        // when
        List<LottoNumberText> lottoNumberTexts = manualLottoNumbers.toList();

        // then
        assertThat(lottoNumberTexts).isEqualTo(lottoNumberTextList);
    }
}
