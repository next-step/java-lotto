package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LottoNumbersTest {

    @Test
    @DisplayName("랜덤으로 뽑은 숫자들이 6개이고, 1 ~ 46사이에 있는지 테스트")
    public void pickLottoNumber() {
        // given
        LottoNumbers lottoNumbers = new LottoNumbers();

        // when
        List<Integer> pickLottoNumbers = lottoNumbers.pickLottoNumber(6);

        // then
        assertThat(pickLottoNumbers.size()).isEqualTo(6);

        pickLottoNumbers.stream().forEach(number -> {
            assertThat(number).isGreaterThanOrEqualTo(1)
                    .isLessThanOrEqualTo(46);
        });
    }
}