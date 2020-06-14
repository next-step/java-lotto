package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("생성한 로또 번호의 숫자가 6개인지 테스트")
    void IsLottoNumbersSizeEqualWithSix() {
        int actual = Lotto.getAutoLotto().getLottoNumbers().size();

        assertThat(actual).isEqualTo(6);
    }

    @Test
    @DisplayName("생성한 로또 번호에 중복이 있는지 테스트")
    void IsDuplicateNumberExistInLotto() {
        List<Integer> lottoNumbers = Lotto.getAutoLotto().getLottoNumbers();
        Set<Integer> set = new HashSet<>(lottoNumbers);
        int actual = lottoNumbers.size();
        int expected = set.size();

        assertThat(actual).isEqualTo(expected);
    }

}
