package lotto;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    @DisplayName("LottoNumber 객체 6개를 주면 정상적으로 Lotto 객체 생성")
    @Test
    void createTest() {
        for (int i = 1; i <= 6; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        assertThatCode(() -> new Lotto(lottoNumbers)).doesNotThrowAnyException();
    }

    @DisplayName("LottoNumber 객체가 6개보다 적으면 예외 발생")
    @Test
    void throwExceptionWhenNotSixLottoNumbers() {
        for (int i = 1; i <= 5; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(lottoNumbers);
        });
    }

    @DisplayName("LottoNumber 객체가 6개보다 많으면 예외 발생")
    @Test
    void throwExceptionWhenNotSixLottoNumbers_2() {
        for (int i = 1; i <= 7; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(lottoNumbers);
        });
    }
}