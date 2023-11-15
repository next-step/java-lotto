package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoNumbers;
import step2.exception.InvalidLottoSizeException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoNumbersTest {

    @Test
    @DisplayName("6개 초과하는 숫자로 로또를 생성할 수 없다")
    public void invalid_lotto_number() {
        assertThatExceptionOfType(InvalidLottoSizeException.class)
            .isThrownBy(() -> {
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
            }).withMessageMatching("로또 숫자 개수가 유효하지 않습니다");
    }

    @Test
    @DisplayName("생성된 로또 번호들의 중복을 확인한다")
    public void lotto_number_duplicate() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        Set<Integer> lottoNumbersSet = new HashSet<>(lottoNumbers.numbers());

        assertThat(lottoNumbers.numbers()).hasSize(lottoNumbersSet.size());
    }

}
