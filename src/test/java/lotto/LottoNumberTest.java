package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static lotto.LottoConfig.LOTTO_NUMBER_SIZE;
import static lotto.LottoConfig.MAX_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {
    @DisplayName("LottoNumber 조건, 1~45 사이의 수 and 6개")
    @Test
    public void createLottoNumber() throws Exception {
        assertThat(new LottoNumber(Set.of(1,2,3,4,5,6)))
                .isNotNull();

        assertThatThrownBy(() -> new LottoNumber(Set.of(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Lotto requires " + LOTTO_NUMBER_SIZE + " numbers.");

        assertThatThrownBy(() -> new LottoNumber(Set.of(1,2,3,4,5,0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Lotto requires a number between 1 and " + (MAX_LOTTO_NUMBER - 1));
    }

    @DisplayName("LottoNumber 동일 번호 몇개인지 테스트")
    @Test
    public void intersectCount() throws Exception {
        LottoNumber lottoNumber = new LottoNumber(Set.of(1, 2, 4, 3, 5, 6));
        Assertions.assertThat(lottoNumber.intersectCount(new LottoNumber(Set.of(1,2,3,4,5,6))))
                .isEqualTo(6);

        Assertions.assertThat(lottoNumber.intersectCount(new LottoNumber(Set.of(1,2,3,4,5,7))))
                .isEqualTo(5);

        Assertions.assertThat(lottoNumber.intersectCount(new LottoNumber(Set.of(1,2,3,4,7,8))))
                .isEqualTo(4);

        Assertions.assertThat(lottoNumber.intersectCount(new LottoNumber(Set.of(1,2,3,7,8,9))))
                .isEqualTo(3);

        Assertions.assertThat(lottoNumber.intersectCount(new LottoNumber(Set.of(1,2,7,8,9,10))))
                .isEqualTo(2);

        Assertions.assertThat(lottoNumber.intersectCount(new LottoNumber(Set.of(1,7,8,9,10,11))))
                .isEqualTo(1);

        Assertions.assertThat(lottoNumber.intersectCount(new LottoNumber(Set.of(7,8,9,10,11,12))))
                .isEqualTo(0);
    }
}