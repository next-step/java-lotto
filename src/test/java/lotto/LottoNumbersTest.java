package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {
    @DisplayName("LottoNumber 동일 번호 몇개인지 테스트")
    @Test
    public void intersectCount() throws Exception {
        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(1, 2, 4, 3, 5, 6));
        assertThat(lottoNumbers.intersectCount(new LottoNumbers(Set.of(1,2,3,4,5,6))))
                .isEqualTo(6);

        assertThat(lottoNumbers.intersectCount(new LottoNumbers(Set.of(1,2,3,4,5,7))))
                .isEqualTo(5);

        assertThat(lottoNumbers.intersectCount(new LottoNumbers(Set.of(1,2,3,4,7,8))))
                .isEqualTo(4);

        assertThat(lottoNumbers.intersectCount(new LottoNumbers(Set.of(1,2,3,7,8,9))))
                .isEqualTo(3);

        assertThat(lottoNumbers.intersectCount(new LottoNumbers(Set.of(1,2,7,8,9,10))))
                .isEqualTo(2);

        assertThat(lottoNumbers.intersectCount(new LottoNumbers(Set.of(1,7,8,9,10,11))))
                .isEqualTo(1);

        assertThat(lottoNumbers.intersectCount(new LottoNumbers(Set.of(7,8,9,10,11,12))))
                .isEqualTo(0);
    }
}