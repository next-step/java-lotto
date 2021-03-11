package camp.nextcamp.edu.lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Test;

import camp.nextcamp.edu.lotto.entity.LottoNumber;
import camp.nextcamp.edu.lotto.module.LottoNumberGenerator;

public class LottoRandomGeneratorTest {

	@Test
	void LottoRandomGenerator_확인() {
		Set<LottoNumber> list = LottoNumberGenerator.generateRandomNumber(new Random());

		assertAll(
			() -> assertThat(list.size())
				.isEqualTo(6)
		);
	}
}
