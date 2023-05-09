package lotto.domain;

import lotto.model.request.ReqManualLotto;
import lotto.service.gernerator.ManualLottoNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinnerLottoTest {

    private final ManualLottoNumbersGenerator manualLottoNumbersGenerator = new ManualLottoNumbersGenerator();

    @Test
    @DisplayName("보너스볼 매칭을 제외한 당첨로또 찾기 테스트")
    void findWinnerList() {

        List<String> requestLottoNumber = List.of("1,2,3,4,5,6");
        List<String> winnerLottoNumber = List.of("1,2,3,4,5,7");

        Lotto lotto = new Lotto(manualLottoNumbersGenerator.bulkGenerateLottoNumbers(new ReqManualLotto(requestLottoNumber)));
        LottoNumbers winnerLottoNumbers = manualLottoNumbersGenerator.generateLottoNumbers(new ReqManualLotto(winnerLottoNumber));
        LottoNumber bonusNumber = LottoNumber.provideLottoNumber(11);
        WinnerLotto winnerLotto = new WinnerLotto(winnerLottoNumbers, bonusNumber);

        assertThat(winnerLotto.findWinnerList(lotto).get(0).providePrize()).isEqualTo(Prize.THIRD_PLACE);
    }

    @Test
    @DisplayName("보너스볼 매칭을 포함 당첨로또 찾기 테스트")
    void findWinnerWithBonusBallList() {

        List<String> requestLottoNumber = List.of("1,2,3,4,7,10");
        List<String> winnerLottoNumber = List.of("1,2,3,4,5,7");

        Lotto lotto = new Lotto(manualLottoNumbersGenerator.bulkGenerateLottoNumbers(new ReqManualLotto(requestLottoNumber)));
        LottoNumbers winnerLottoNumbers = manualLottoNumbersGenerator.generateLottoNumbers(new ReqManualLotto(winnerLottoNumber));
        LottoNumber bonusNumber = LottoNumber.provideLottoNumber(10);
        WinnerLotto winnerLotto = new WinnerLotto(winnerLottoNumbers, bonusNumber);

        assertThat(winnerLotto.findWinnerList(lotto).get(0).providePrize()).isEqualTo(Prize.SECOND_PLACE);
    }

    @Test
    @DisplayName("보너스볼이 담청번호에 존재한다면 예외를 던진다.")
    void throwExceptionExistBonusBallIntoWinnerNumber() {
        List<String> winnerLottoNumber = List.of("1,2,3,4,5,10");
        LottoNumbers winnerLottoNumbers = manualLottoNumbersGenerator.generateLottoNumbers(new ReqManualLotto(winnerLottoNumber));
        LottoNumber bonusNumber = LottoNumber.provideLottoNumber(10);

        assertThatIllegalArgumentException().isThrownBy(() -> new WinnerLotto(winnerLottoNumbers,bonusNumber))
                .withMessage("보너스볼 번호가 당첨 로또에 이미 있는 번호입니다 :(");
    }
}