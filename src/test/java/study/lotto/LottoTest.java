package study.lotto;

import org.junit.jupiter.api.Test;
import study.lotto.core.Lotto;
import study.lotto.core.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    // Given
                    List<LottoNumber> lottoNumbers = new ArrayList<>();
                    lottoNumbers.add(new LottoNumber(1));

                    // When
                    Lotto lotto = new Lotto(lottoNumbers);
                }).withMessageMatching("로또 번호는 6개를 입력해주세요.");
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