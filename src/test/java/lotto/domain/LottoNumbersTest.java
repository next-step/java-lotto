package lotto.domain;

import lotto.exception.InvalidLottoNumberCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @Test
    @DisplayName("두개의 LottoNumbers 를 비교해서 같은 숫자 개수를 반환한다.")
    void matchCount() {
        LottoNumbers lottoNumbers1 = createLottoNumbers(1, 2, 3, 11, 12, 13);
        LottoNumbers lottoNumbers2 = createLottoNumbers(2, 3, 4, 14, 24, 34);

        assertThat(lottoNumbers1.matchCount(lottoNumbers2)).isEqualTo(2);
    }

    @Test
    @DisplayName("LottoNumbers 에 같은 값이 있으면 true 를 반환한다.")
    void isContain() {
        LottoNumbers lottoNumbers = createLottoNumbers(1, 2, 3, 4, 5, 6);

        assertThat(lottoNumbers.isContain(LottoNumber.valueOf(1))).isTrue();
    }

    @Test
    @DisplayName("LottoNumbers 에 같은 값이 없으면 false 를 반환한다.")
    void isNotContain() {
        LottoNumbers lottoNumbers = createLottoNumbers(1, 2, 3, 4, 5, 6);

        assertThat(lottoNumbers.isContain(LottoNumber.valueOf(7))).isFalse();
    }

    @Test
    @DisplayName("로또 번호를 중복으로 입력 시 중복이 제거되서 생성된다.")
    void duplicate() {
        LottoNumbers lottoNumbers1 = createLottoNumbers(1, 2, 3, 4, 5, 6, 6);
        LottoNumbers lottoNumbers2 = createLottoNumbers(1, 2, 3, 4, 5, 6);

        assertThat(lottoNumbers1).isEqualTo(lottoNumbers2);
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닐경우 InvalidLottoNumberCount 를 반환한다.")
    void InvalidNumberException() {
        assertThatThrownBy(() -> new LottoNumbers("1")).isInstanceOf(InvalidLottoNumberCount.class)
                .hasMessage("로또번호는 " + LottoNumbers.LOTTO_NUMBER_COUNT + "개를 가져야합니다.");
    }

    private LottoNumbers createLottoNumbers(int... numbers) {
        TreeSet<LottoNumber> lottoNumberTreeSet = new TreeSet<>();
        for (int number : numbers) {
            lottoNumberTreeSet.add(LottoNumber.valueOf(number));
        }
        return new LottoNumbers(lottoNumberTreeSet);
    }
}