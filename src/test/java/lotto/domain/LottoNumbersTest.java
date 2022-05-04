package lotto.domain;

import lotto.exception.InvalidLottoNumberCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @Test
    @DisplayName("LottoNumbers 3,1,5,7,8,2 순서의 리스트로 생성하면 1,2,3,5,7,8로 정렬되여 생성된다.")
    void sort() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(7));
        lottoNumbers.add(new LottoNumber(8));
        lottoNumbers.add(new LottoNumber(2));

        assertThat(new LottoNumbers(lottoNumbers).toList()).containsExactly(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(5), new LottoNumber(7), new LottoNumber(8));
    }

    @Test
    @DisplayName("1,2,3,11,12,13을 가지고 있는 LottoNumbers와 2,3,4,14,24,34를 가지고 있는 List와의 matchCount는 2이다.")
    void matchCount() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(11));
        lottoNumbers.add(new LottoNumber(12));
        lottoNumbers.add(new LottoNumber(13));

        List<LottoNumber> lottoNumbers2 = new ArrayList<>();
        lottoNumbers2.add(new LottoNumber(2));
        lottoNumbers2.add(new LottoNumber(3));
        lottoNumbers2.add(new LottoNumber(4));
        lottoNumbers2.add(new LottoNumber(14));
        lottoNumbers2.add(new LottoNumber(24));
        lottoNumbers2.add(new LottoNumber(34));

        assertThat(new LottoNumbers(lottoNumbers).matchCount(lottoNumbers2)).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 번호를 중복으로 입력 시 중복이 제거되서 생성된다.")
    void duplicate() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));
        lottoNumbers.add(new LottoNumber(6));

        List<LottoNumber> lottoNumbers2 = new ArrayList<>();
        lottoNumbers2.add(new LottoNumber(1));
        lottoNumbers2.add(new LottoNumber(2));
        lottoNumbers2.add(new LottoNumber(3));
        lottoNumbers2.add(new LottoNumber(4));
        lottoNumbers2.add(new LottoNumber(5));
        lottoNumbers2.add(new LottoNumber(6));

        assertThat(new LottoNumbers(lottoNumbers)).isEqualTo(new LottoNumbers(lottoNumbers2));
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닐경우 InvalidLottoNumberCount 를 반환한다.")
    void InvalidNumberException() {
        assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(new LottoNumber(1)))).isInstanceOf(InvalidLottoNumberCount.class);
    }
}