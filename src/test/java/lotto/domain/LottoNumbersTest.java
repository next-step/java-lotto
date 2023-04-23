package lotto.domain;

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
        LottoNumbers lottoNumbers = LottoNumbers.initShuffledLottoNumbers();

        assertThat(lottoNumbers.getLottoNumberSize())
                .isEqualTo(6);
    }

    @Test
    @DisplayName("LottoNumbers 길이 에러 리턴 테스트")
    void lottoNumbersSizeErrorTest() {
        LottoNumber lottoNumber_1 = LottoNumber.createLottoNumber();
        LottoNumber lottoNumber_2 = LottoNumber.createLottoNumber();
        LottoNumber lottoNumber_3 = LottoNumber.createLottoNumber();
        LottoNumber lottoNumber_4 = LottoNumber.createLottoNumber();
        LottoNumber lottoNumber_5 = LottoNumber.createLottoNumber();

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
        LottoNumbers manualLottoNumbers = LottoNumbers.initManualLottoNumbers(winningNumbers);

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
        List<String> winningNumbers = List.of("1", "2", "3", "4", "5", "5");

        assertThatThrownBy(() -> LottoNumbers.initManualLottoNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("같은 숫자를 입력했습니다.");
    }

    @Test
    @DisplayName("당첨 번호 확인 테스트")
    void findMatchingNumbers() {
        List<String> winningNumbers = List.of("1", "2", "3", "4", "5", "6");
        LottoNumbers winingLotto = LottoNumbers.initManualLottoNumbers(winningNumbers);

        List<String> stringLottoNumbers = List.of("1", "2", "3", "11", "12", "13");
        LottoNumbers lottoNumbers = LottoNumbers.initManualLottoNumbers(stringLottoNumbers);

        assertThat(lottoNumbers.findSameNumbers(winingLotto))
                .isEqualTo(3);
    }

}