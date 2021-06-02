package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.LottoNumber;
import study.lotto.exception.WrongLottoNumberException;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoNumberTest {

    @DisplayName("로또 번호는 1~45 사이이다.")
    @Test
    public void lottoNumberTest() {
        LottoNumber firstNumber = LottoNumber.of(1);
        assertThat(firstNumber.value()).isEqualTo(1);

        LottoNumber lastNumber = LottoNumber.of(45);
        assertThat(lastNumber.value()).isEqualTo(45);

        assertThatThrownBy(() -> LottoNumber.of(0))
                .isInstanceOf(WrongLottoNumberException.class);

        assertThatThrownBy(() -> LottoNumber.of(46))
                .isInstanceOf(WrongLottoNumberException.class);

    }

    @DisplayName("로또 번호 재사용 테스트")
    @Test
    public void lottoNumberCachingTest() {
        LottoNumber firstNumber = LottoNumber.of(1);
        assertThat(firstNumber).isEqualTo(LottoNumber.of(1));
        assertSame(firstNumber,LottoNumber.of(1));
    }

    @DisplayName("오름차순 정렬(compareTo 메서드 테스트)")
    @Test
    public void sortTest() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(LottoNumber.of(3));
        lottoNumbers.add(LottoNumber.of(2));
        lottoNumbers.add(LottoNumber.of(1));
        lottoNumbers.add(LottoNumber.of(4));
        lottoNumbers.add(LottoNumber.of(5));
        lottoNumbers.add(LottoNumber.of(6));

        Collections.sort(lottoNumbers);

        assertThat(lottoNumbers).containsExactly(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
    }


}
