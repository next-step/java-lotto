package lotto.domain;

import lotto.model.request.ReqManualLotto;
import lotto.service.gernerator.ManualLottoNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {

    private final ManualLottoNumbersGenerator manualLottoNumbersGenerator = new ManualLottoNumbersGenerator();

    @Test
    @DisplayName("Lotto 생성 테스트")
    void LottoGenerateTest() {

        List<String> given = List.of("1,2,3,4,5,6");

        Lotto lotto = new Lotto(manualLottoNumbersGenerator.bulkGenerateLottoNumbers(new ReqManualLotto(given)));

        assertAll(
                () -> assertThat(lotto).isNotNull(),
                () -> assertThat(lotto.getLottoNumbersSize()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("Lotto 번호 매칭 테스트 - lottNumbers")
    void lottoNumbersMatchingTest() {
        List<String> given = List.of("1,2,3,4,5,6");

        Lotto lotto = new Lotto(manualLottoNumbersGenerator.bulkGenerateLottoNumbers(new ReqManualLotto(given)));
        LottoNumbers lottoNumbers = manualLottoNumbersGenerator.generateLottoNumbers(new ReqManualLotto(List.of("1, 7, 8, 9, 10, 11")));

        assertThat(lotto.countMatchingBall(lottoNumbers).get(0)).isEqualTo(1);
    }


    @Test
    @DisplayName("Lotto 번호 매칭 테스트 - lottNumber")
    void lottoNumberMatchingTest() {
        List<String> given = List.of("1,2,3,4,5,6");

        Lotto lotto = new Lotto(manualLottoNumbersGenerator.bulkGenerateLottoNumbers(new ReqManualLotto(given)));
        LottoNumber lottoNumber = LottoNumber.provideLottoNumber(1);
        assertThat(lotto.bonusNumberMatchingList(lottoNumber).get(0)).isTrue();
    }

}