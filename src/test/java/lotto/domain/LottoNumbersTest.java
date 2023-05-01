package lotto.domain;

import lotto.exception.SameNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @Test
    @DisplayName("LottoNumbers 사이즈 테스트")
    void lottoNumbersRangeTest() {
        LottoNumbers lottoNumbers = LottoNumbers.createAutoLottoNumbers();

        assertThat(lottoNumbers.getLottoNumberSize())
                .isEqualTo(6);
    }

    @Test
    @DisplayName("LottoNumbers 길이 에러 리턴 테스트")
    void lottoNumbersSizeErrorTest() {
        LottoNumber lottoNumber_1 = LottoNumber.createAutoLottoNumber();
        LottoNumber lottoNumber_2 = LottoNumber.createAutoLottoNumber();
        LottoNumber lottoNumber_3 = LottoNumber.createAutoLottoNumber();
        LottoNumber lottoNumber_4 = LottoNumber.createAutoLottoNumber();
        LottoNumber lottoNumber_5 = LottoNumber.createAutoLottoNumber();

        List<LottoNumber> LottoNumbersList = List.of(
                lottoNumber_1,
                lottoNumber_2,
                lottoNumber_3,
                lottoNumber_4,
                lottoNumber_5);
        Set<LottoNumber> lottoNumbers = new TreeSet<>(LottoNumbersList);

        assertThatThrownBy(() -> new LottoNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 숫자는 6개를 입력해주세요!");
    }

    @Test
    @DisplayName("LottoNumbers 수동 입력")
    void initManualLottoNnumbers() {
        List<String> winningNumbers = List.of("1", "2", "3", "4", "5", "6");
        LottoNumbers manualLottoNumbers = LottoNumbers.createManualLottoNumbers(winningNumbers);

        List<LottoNumber> LottoNumbersList = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        Set<LottoNumber> lottoNumbers = new TreeSet<>(LottoNumbersList);
        LottoNumbers resultLottoNumbers = new LottoNumbers(lottoNumbers);

        assertThat(manualLottoNumbers)
                .usingRecursiveComparison()
                .isEqualTo(resultLottoNumbers);
    }

    @Test
    @DisplayName("LottoNumbers 같은 숫자 입력시 에러 리턴 테스트")
    void lottoNumbersSameNumberErrorTest() {
        List<String> winningNumbers = List.of("1", "2", "3", "3", "5", "5");

        assertThatThrownBy(() -> LottoNumbers.createManualLottoNumbers(winningNumbers))
                .isInstanceOf(SameNumberException.class)
                .hasMessage("같은 숫자를 입력했습니다 - 같은 숫자 : 3, 5");
    }

    @Test
    @DisplayName("당첨 번호 확인 테스트")
    void findMatchingNumbers() {
        List<String> winningNumbers = List.of("1", "2", "3", "4", "5", "6");
        LottoNumbers winingLotto = LottoNumbers.createManualLottoNumbers(winningNumbers);

        List<String> stringLottoNumbers = List.of("1", "2", "3", "11", "12", "13");
        LottoNumbers lottoNumbers = LottoNumbers.createManualLottoNumbers(stringLottoNumbers);

        assertThat(lottoNumbers.findMatchingNumbers(winingLotto))
                .isEqualTo(3);
    }

    @Test
    @DisplayName("보너스 번호 확인 테스트")
    void hasBonusNumberTest() {
        List<String> stringLottoNumbers = List.of("1", "2", "3", "4", "5", "6");
        LottoNumbers lottoNumbers = LottoNumbers.createManualLottoNumbers(stringLottoNumbers);

        LottoNumber bonusNumber = LottoNumber.createManualLottoNumber("6");

        assertThat(lottoNumbers.hasLottoNumber(bonusNumber))
                .isTrue();
    }

    @Test
    @DisplayName("보너스 번호 불일치 테스트")
    void hasNoBonusNumberTest() {
        List<String> stringLottoNumbers = List.of("1", "2", "3", "4", "5", "6");
        LottoNumbers lottoNumbers = LottoNumbers.createManualLottoNumbers(stringLottoNumbers);

        LottoNumber bonusNumber = LottoNumber.createManualLottoNumber("7");

        assertThat(lottoNumbers.hasLottoNumber(bonusNumber))
                .isFalse();
    }

}