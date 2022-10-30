package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberPoolTest {

    @Test
    void getLottoNumbers() {
        List<LottoNumber> firstLottoNumbers = LottoNumberPool.getLottoNumbers();
        List<LottoNumber> secondLottoNumbers = LottoNumberPool.getLottoNumbers();

        assertThat(firstLottoNumbers).doesNotHaveDuplicates();
        assertThat(secondLottoNumbers).doesNotHaveDuplicates();
        assertThat(firstLottoNumbers).anyMatch(lottoNumber -> !secondLottoNumbers.contains(lottoNumber));
    }
}
