package step2step3.lotto.lottoNumber;

import org.junit.jupiter.api.Test;
import step2step3.lotto.lottoNumber.LottoNumber;
import step2step3.lotto.lottoNumber.LottoNumberStorage;
import step2step3.lotto.lottoNumber.NumbersGenerator;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberStorageTest {
    @Test
    void 숫자들을_로또_번호들로_변환시켜준다() {
        NumbersGenerator numbersGenerator = new NumbersGenerator.Fake(Set.of(1, 2, 3, 4, 5, 6));
        LottoNumberStorage lottoNumberStorage = new LottoNumberStorage(numbersGenerator);

        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        assertThat(lottoNumberStorage.lottoNumbers()).isEqualTo(lottoNumbers);
    }
}
