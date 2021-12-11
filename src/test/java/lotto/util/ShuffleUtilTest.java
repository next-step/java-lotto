package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ShuffleUtilTest {

    @DisplayName("1~10 사이의 숫자를 섞어서 반환한다")
    @Test
    void shuffledNumbers() {
        List<Integer> result = ShuffleUtil.shuffledNumbers(1, 10);
        int min = result.stream().mapToInt(num -> num).min().getAsInt();
        int max = result.stream().mapToInt(num -> num).max().getAsInt();
        assertThat(min).isEqualTo(1);
        assertThat(max).isEqualTo(10);
    }

    @DisplayName("로또 사이즈에 맞는 랜덤한 숫자를 생성한다.")
    @Test
    void shuffledLottoNumbers() {
        List<LottoNumber> result = ShuffleUtil.shuffledLottoNumbers(LottoNumber.MIN, LottoNumber.MAX, Lotto.SIZE);
        assertThat(result.size()).isEqualTo(Lotto.SIZE);
    }
}