package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

public class LottoNumbersTest {

    @Test
    @DisplayName("46개중에서 랜덤으로 뽑은 숫자들이 6개이고, 1 ~ 46사이에 있는지 테스트")
    public void pickLottoNumberRandom() {
        // given
        LottoNumbers lottoNumbers = new LottoNumbers();

        // when
        List<Integer> pickLottoNumbers = lottoNumbers.pickLottoNumber();

        // then
        assertThat(pickLottoNumbers.size()).isEqualTo(6);

        pickLottoNumbers.stream().forEach(number -> {
            assertThat(number).isGreaterThanOrEqualTo(1)
                    .isLessThanOrEqualTo(46);
        });
    }

    @Test
    @DisplayName("고정으로 세팅한 숫자들을 6개 뽑았을때, 리스트에 해당 번호가 있는지 테스트")
    public void pickLottoNumberFixed() {
        // given
        List<Integer> numbers = Arrays.asList(1, 10, 20, 30, 40, 46);
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);

        // when
        List<Integer> pickLottoNumbers = lottoNumbers.pickLottoNumber();

        // then
        pickLottoNumbers.stream().forEach(number -> {
            assertThat(number).isIn(numbers);
        });
    }


    @Test
    @DisplayName("고정으로 세팅한 숫자들보다 더 큰 크기의 수를 뽑으려고 할 때 오류 발생 테스트")
    public void pickLottoNumberFixedOccurredException() {
        // given
        List<Integer> numbers = Arrays.asList(1, 10, 20, 30, 40, 46);
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);

        // when
        Throwable throwable = catchThrowable(() -> {
            lottoNumbers.pickLottoNumber(7);
        });

        // then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("뽑으려는 번호의 갯수가 미리 세팅된 로또 번호의 크기보다 큽니다.");
    }
}