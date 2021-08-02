package lotto.domain;

import lotto.exception.InvalidLottoNumberCountException;
import lotto.exception.LottoNumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumbersTests {

    @DisplayName("로또 번호 담는 일급 객체 생성 테스트")
    @Test
    void createLottoNumbersTest() {

        LottoNumbers expectedLottoNumbers = LottoNumbers.of(new HashSet<>(Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))));

        LottoNumbers actualLottoNumbers = LottoNumbers.of(new HashSet<>(Arrays.asList(
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))));

        assertThat(actualLottoNumbers).isEqualTo(expectedLottoNumbers);
    }

    @DisplayName("로또 번호들의 갯수를 10개로 생성 시킬 때 에러 처리 테스트")
    @Test
    void invalidCountLottoNumberCreateTest() {

        assertThatExceptionOfType(InvalidLottoNumberCountException.class)
                .isThrownBy(() -> {
                    LottoNumbers lottoNumbers = LottoNumbers.of(new HashSet<>(Arrays.asList(
                            LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5),
                            LottoNumber.of(6), LottoNumber.of(7), LottoNumber.of(8), LottoNumber.of(9), LottoNumber.of(10))));
                }).withMessageMatching("로또 숫자는 반드시 6개 여야 합니다.");
    }

    @DisplayName("중복의 경우 5개만 생성 되므로, 그에 관한 에러 처리 테스트")
    @Test
    void duplicatedCountLottoNumberCreateTest() {
        assertThatExceptionOfType(InvalidLottoNumberCountException.class)
                .isThrownBy(() -> {
                    LottoNumbers lottoNumbers = LottoNumbers.of(new HashSet<>(Arrays.asList(
                            LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(5))));
                }).withMessageMatching("로또 숫자는 반드시 6개 여야 합니다.");
    }

//
//    @DisplayName("지난주 우승 번호로 로또 맞은 갯수들 기록 가져오는 테스트")
//    @Test
//    void getMatchRecordsTests() {
//        LottoNumber winningLottoNumber = new LottoNumber(Arrays.asList(8, 21, 23, 41, 42, 43));
//
//        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(8, 21, 23, 41, 42, 43));
//
//        LottoNumber lottoNumber2 = new LottoNumber(Arrays.asList(8, 21, 23, 41, 42, 45));
//
//        LottoNumbers lottoNumbers = LottoNumbers.of(Arrays.asList(lottoNumber, lottoNumber2));
//
//        assertThat(Arrays.toString(lottoNumbers.getMatchingRecords(winningLottoNumber))).isEqualTo("[0, 0, 1, 1]");
//    }
}
