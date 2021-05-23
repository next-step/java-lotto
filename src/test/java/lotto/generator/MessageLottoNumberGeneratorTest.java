package lotto.generator;

import static org.assertj.core.api.Assertions.*;

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
}
