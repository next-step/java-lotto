package lotto.domain;

import lotto.exception.InvalidLottoNumberCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMarkingNumbersTest {

    @Test
    @DisplayName("1,2,3,11,12,13을 가지고 있는 LottoNumbers와 2,3,4,14,24,34를 가지고 있는 List와의 matchCount는 2이다.")
    void matchCount() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(LottoNumber.valueOf(1));
        lottoNumbers.add(LottoNumber.valueOf(2));
        lottoNumbers.add(LottoNumber.valueOf(3));
        lottoNumbers.add(LottoNumber.valueOf(11));
        lottoNumbers.add(LottoNumber.valueOf(12));
        lottoNumbers.add(LottoNumber.valueOf(13));

        TreeSet<LottoNumber> lottoNumbers2 = new TreeSet<>();
        lottoNumbers2.add(LottoNumber.valueOf(2));
        lottoNumbers2.add(LottoNumber.valueOf(3));
        lottoNumbers2.add(LottoNumber.valueOf(4));
        lottoNumbers2.add(LottoNumber.valueOf(14));
        lottoNumbers2.add(LottoNumber.valueOf(24));
        lottoNumbers2.add(LottoNumber.valueOf(34));

        assertThat(new LottoMarkingNumbers(lottoNumbers).matchCount(new WinningNumbers(lottoNumbers2))).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 번호를 중복으로 입력 시 중복이 제거되서 생성된다.")
    void duplicate() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(LottoNumber.valueOf(1));
        lottoNumbers.add(LottoNumber.valueOf(2));
        lottoNumbers.add(LottoNumber.valueOf(3));
        lottoNumbers.add(LottoNumber.valueOf(4));
        lottoNumbers.add(LottoNumber.valueOf(5));
        lottoNumbers.add(LottoNumber.valueOf(6));
        lottoNumbers.add(LottoNumber.valueOf(6));

        List<LottoNumber> lottoNumbers2 = new ArrayList<>();
        lottoNumbers2.add(LottoNumber.valueOf(1));
        lottoNumbers2.add(LottoNumber.valueOf(2));
        lottoNumbers2.add(LottoNumber.valueOf(3));
        lottoNumbers2.add(LottoNumber.valueOf(4));
        lottoNumbers2.add(LottoNumber.valueOf(5));
        lottoNumbers2.add(LottoNumber.valueOf(6));

        assertThat(new LottoMarkingNumbers(lottoNumbers)).isEqualTo(new LottoMarkingNumbers(lottoNumbers2));
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닐경우 InvalidLottoNumberCount 를 반환한다.")
    void InvalidNumberException() {
        assertThatThrownBy(() -> new LottoMarkingNumbers(Arrays.asList(LottoNumber.valueOf(1)))).isInstanceOf(InvalidLottoNumberCount.class)
                .hasMessage("로또번호는 " + LottoMarkingNumbers.LOTTO_NUMBER_COUNT + "개를 가져야합니다.");
    }
}