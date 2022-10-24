package step4.domain;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

    @DisplayName("로또 발행 시 6개의 번호가 있는 로또가 발행")
    @Test
    void lotto_list_size_6() {
        LottoNumbers lottoNumbers = LottoNumbers.from(
            LottoNumberGenerator.generateLottoNumber());
        Assertions.assertThat(lottoNumbers.getLottoNumbers().size()).isEqualTo(6);
    }

    @DisplayName("MatchCount 계산 시 당첨 번호와 로또 번호 일치 개수를 반환")
    @Test
    void calculateMatchCount() {
        step3.domain.LottoNumbers lottoNumbers = step3.domain.LottoNumbers.from(Arrays
            .asList(step3.domain.LottoNumber.from(1),
                step3.domain.LottoNumber.from(2),
                step3.domain.LottoNumber.from(3),
                step3.domain.LottoNumber.from(4),
                step3.domain.LottoNumber.from(5),
                step3.domain.LottoNumber.from(6)));
        int countOfMatch = lottoNumbers.calculateMatchCount(Arrays.asList(1, 2, 3, 4, 5));
        Assertions.assertThat(countOfMatch).isEqualTo(5);
    }

    @DisplayName("BonusBall 당첨 확인 시 로또 번호 중 일치 확인")
    @Test
    void lottoNumbers_contains_bonusBall_return_true() {
        LottoNumbers lottoNumbers = LottoNumbers.from(Arrays
            .asList(LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)));
        boolean isBonusBallMatch = lottoNumbers.hasNumber(5);
        Assertions.assertThat(isBonusBallMatch).isTrue();
    }
}
