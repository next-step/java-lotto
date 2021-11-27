package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


/**
 * @author han
 */
class LottoNumberTest {

    @Test
    @DisplayName("생성")
    void create() {
        LottoNumber byString = new LottoNumber("1");
        assertThat(byString.getNumber()).isEqualTo(1);

        LottoNumber byInt = new LottoNumber(1);
        assertThat(byInt.getNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("45 이상 값을 입력했을 경우 에러를 던진다.")
    void throwErrorIfExceedBound() {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new LottoNumber(46));
    }

    @Test
    @DisplayName("중복된 로또 넘버들을 반환하지 않는다")
    void createNonDuplicated() {
        List<LottoNumber> nonDuplicated = LottoNumber.createNonDuplicated();
        assertThat(nonDuplicated.size()).isEqualTo(new HashSet<>(nonDuplicated).size());
    }

    @Test
    @DisplayName("String을 통해 로또 생성 시, 중복된 로또 넘버들을 반환하지 않는다")
    void createNonDuplicatedByStrings() {
        List<LottoNumber> nonDuplicated = LottoNumber.createNonDuplicated("1,2,3,4,5,6");
        assertThat(nonDuplicated.size()).isEqualTo(new HashSet<>(nonDuplicated).size());
    }
}