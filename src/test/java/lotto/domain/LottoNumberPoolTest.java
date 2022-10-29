package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LottoNumberPoolTest {

    @Test
    void getLottoNumber() {
        LottoNumber firstLottoNumber = LottoNumberPool.getLottoNumber();
        LottoNumber secondLottoNumber = LottoNumberPool.getLottoNumber();

        assertNotEquals(firstLottoNumber, secondLottoNumber);
    }

    @Test
    void getLottoNumbers() {
        List<LottoNumber> firstLottoNumbers = LottoNumberPool.getLottoNumbers();
        List<LottoNumber> secondLottoNumbers = LottoNumberPool.getLottoNumbers();

        assertThat(firstLottoNumbers).doesNotHaveDuplicates();
        assertThat(secondLottoNumbers).doesNotHaveDuplicates();
        assertThat(firstLottoNumbers).anyMatch(lottoNumber -> !secondLottoNumbers.contains(lottoNumber));
    }
}
