package camp.nextcamp.edu.lotto;

import static camp.nextcamp.edu.lotto.module.LottoValidator.*;
import static java.util.stream.IntStream.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import camp.nextcamp.edu.lotto.module.LottoRandomGenerator;

public class LottoRandomGeneratorTest {

	@Test
	void LottoRandomGenerator_확인() {
		Set<Integer> list = LottoRandomGenerator.generate(new Random());

		assertAll(
			() -> assertThat(list.size())
				.isEqualTo(6),
			() -> {
				list.forEach(key -> {
					assertThat(isNotInRange(key))
						.isEqualTo(true);
				});
			}
		);
	}
}
