package lotto.domain;

import lotto.model.request.ReqAutoLotto;
import lotto.service.gernerator.AutoLottoNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class AutoLottoNumbersGeneratorTest {

    private final AutoLottoNumbersGenerator autoLottoNumbersGenerator = new AutoLottoNumbersGenerator();

    @Test
    @DisplayName("6개의 로또번호 자동 생성 테스트 - 단일")
    void generateSingleLottoNumber() {

        LottoNumbers lottoNumbers = autoLottoNumbersGenerator.generateLottoNumbers(new ReqAutoLotto(Money.wons(1000)));

        assertThat(lottoNumbers).isNotNull();
    }

    @Test
    @DisplayName("로또 발급 금액이 부족할 경우 예외를 던진다 1000원")
    void throwLottoNumber() {

        assertThatIllegalArgumentException().isThrownBy(
                        () -> autoLottoNumbersGenerator.generateLottoNumbers(new ReqAutoLotto(Money.wons(900)))
                )
                .withMessage("금액을 확인해주세요 :(");
    }

    @Test
    @DisplayName("6개의 로또번호 자동 생성 테스트 - 벌크")
    void bulkGenerateSingleLottoNumber() {

        List<LottoNumbers> lottoNumbers = autoLottoNumbersGenerator.bulkGenerateLottoNumbers(new ReqAutoLotto(Money.wons(2000)));

        assertThat(lottoNumbers).hasSize(2);
    }

}