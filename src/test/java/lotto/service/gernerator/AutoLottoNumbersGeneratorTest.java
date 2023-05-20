package lotto.service.gernerator;

import lotto.domain.LottoNumbers;
import lotto.domain.Money;
import lotto.model.request.ReqAutoLotto;
import lotto.service.gernerator.AutoLottoNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoNumbersGeneratorTest {

    private final AutoLottoNumbersGenerator autoLottoNumbersGenerator = new AutoLottoNumbersGenerator();

    @Test
    @DisplayName("로또 발급 금액이 부족할 경우 로또를 발급하지 않는다")
    void throwLottoNumber() {

        List<LottoNumbers> lottoNumbers = autoLottoNumbersGenerator.generateLottoNumbers(new ReqAutoLotto(Money.wons(900)));

        assertThat(lottoNumbers).hasSize(0);
    }

    @Test
    @DisplayName("6개의 로또번호 자동 생성 테스트")
    void bulkGenerateSingleLottoNumber() {

        List<LottoNumbers> lottoNumbers = autoLottoNumbersGenerator.generateLottoNumbers(new ReqAutoLotto(Money.wons(2000)));

        assertThat(lottoNumbers).hasSize(2);
    }

}