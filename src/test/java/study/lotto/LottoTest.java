package study.lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import study.lotto.core.Lotto;
import study.lotto.core.LottoNumber;
import study.lotto.core.WinLottoNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LottoTest {

    @Test
    void test_create_success() {
        // Given
        List<LottoNumber> lottoNumbers = createLottoNumbers();

        // When
        Lotto lotto = new Lotto(lottoNumbers);

        // Then
        // do nothing
    }

    @Test
    void test_create_fail() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            // Given
            List<LottoNumber> lottoNumbers = new ArrayList<>();
            lottoNumbers.add(new LottoNumber(1));

            // When
            Lotto lotto = new Lotto(lottoNumbers);
        });
    }

    private List<LottoNumber> createLottoNumbers() {
        return Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(6));
    }
}