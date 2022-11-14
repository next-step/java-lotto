package step2step3.lotto.lottoNumber;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberStorageTest {
    @Test
    void 숫자들을_로또_번호들로_변환시켜준다() {
        LottoNumberStorage lottoNumberStorage = LottoNumberStorage.lottoNumberStorage();

        NumbersGenerator numbersGenerator = new NumbersGenerator.Fake(Set.of(1, 2, 3, 4, 5, 6));
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        assertThat(lottoNumberStorage.lottoNumbers(numbersGenerator)).isEqualTo(lottoNumbers);
    }

    @Test
    void 숫자들_개수가_6개가_아닐_경우_예외가_발생한다() {
        LottoNumberStorage lottoNumberStorage = LottoNumberStorage.lottoNumberStorage();

        NumbersGenerator numbersGenerator = new NumbersGenerator.Fake(Set.of(1, 2, 3, 4, 5));
        assertThatThrownBy(() -> lottoNumberStorage.lottoNumbers(numbersGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개이어야 합니다.");
    }
}
