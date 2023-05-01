package step3.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.model.Lotto.LottoNumber;
import step3.domain.model.Lotto.LottoNumbers;
import step3.domain.strategy.lotto.LottoPolicyStrategy;

import static org.assertj.core.api.Assertions.assertThat;


class LottoServiceTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 8})
    void 로또_보너스넘버_값_있을때_객체값확인(int input) {
        LottoNumber bonusNumber = LottoNumber.from(input);

        LottoNumbers lottoNumbers = new LottoPolicyStrategy().createLottoNumbers();
        for (LottoNumber lottoNumber : lottoNumbers.getLottoNumbers()) {
            if (lottoNumber.getNumber() == input) {
                assertThat(lottoNumber.hasBonusNumber(bonusNumber)).isTrue();
            }
        }
    }
}
