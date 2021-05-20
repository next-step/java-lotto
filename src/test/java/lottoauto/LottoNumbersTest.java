package lottoauto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

    @DisplayName("자동로또번호발생(1~45 중복되지않은 6개의 숫자) 테스트")
    @Test
    void 자동로또번호발생() {
        LottoNumbers lottoNumbers = new LottoNumbers();

        assertThat(lottoNumbers.isNonDuplicate()).isTrue();
        assertThat(lottoNumbers.isBetween1To45()).isTrue();
    }
}
