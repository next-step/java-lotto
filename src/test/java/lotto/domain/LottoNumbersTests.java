package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTests {

    @DisplayName("로또 번호 담는 일급 객체 생성 테스트")
    @Test
    void createLottoNumbersTest() {
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(8, 21, 23, 41, 42, 43));

        LottoNumber lottoNumber2 = new LottoNumber(Arrays.asList(8, 21, 23, 41, 42, 45));

        LottoNumbers lottoNumbers = LottoNumbers.of(Arrays.asList(lottoNumber, lottoNumber2));

        assertThat(lottoNumbers.value()).isEqualTo(Arrays.asList(Arrays.asList(8, 21, 23, 41, 42, 43), Arrays.asList(8, 21, 23, 41, 42, 45)).toString());
    }

    @DisplayName("지난주 우승 번호로 로또 맞은 갯수들 기록 가져오는 테스트")
    @Test
    void getMatchRecordsTests() {
        LottoNumber winningLottoNumber = new LottoNumber(Arrays.asList(8, 21, 23, 41, 42, 43));

        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(8, 21, 23, 41, 42, 43));

        LottoNumber lottoNumber2 = new LottoNumber(Arrays.asList(8, 21, 23, 41, 42, 45));

        LottoNumbers lottoNumbers = LottoNumbers.of(Arrays.asList(lottoNumber, lottoNumber2));

        assertThat(Arrays.toString(lottoNumbers.getMatchingRecords(winningLottoNumber))).isEqualTo("[0, 0, 1, 1]");
    }
}
