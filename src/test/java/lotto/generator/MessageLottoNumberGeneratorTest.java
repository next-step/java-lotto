package lotto.generator;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.LottoNumber;
import lotto.LottoNumbers;

public class MessageLottoNumberGeneratorTest {

    @Test
    @DisplayName(value = "메세지(string)으로 로또 번호를 만든다")
    void generatedUsingString() {
        Generator generator = new MessageLottoNumberGenerator("1, 2, 3, 4, 5, 6");
        LottoNumbers lottoNumbers = generator.generate();

        assertThat(lottoNumbers.hasWinLottoNumber(new LottoNumber(1))).isTrue();
        assertThat(lottoNumbers.hasWinLottoNumber(new LottoNumber(2))).isTrue();
        assertThat(lottoNumbers.hasWinLottoNumber(new LottoNumber(3))).isTrue();
        assertThat(lottoNumbers.hasWinLottoNumber(new LottoNumber(4))).isTrue();
        assertThat(lottoNumbers.hasWinLottoNumber(new LottoNumber(5))).isTrue();
        assertThat(lottoNumbers.hasWinLottoNumber(new LottoNumber(6))).isTrue();
    }

    @Test
    @DisplayName(value = "숫자 리스트를 넘겨주면 LotteNumbers를 반환한다")
    void generateLottoNumbers() {
        MessageLottoNumberGenerator generator = new MessageLottoNumberGenerator();

        assertThat(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)))
            .isEqualTo(generator.generate("1, 2, 3, 4, 5, 6"));
    }
}
