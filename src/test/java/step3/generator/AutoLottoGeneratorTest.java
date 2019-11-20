package step3.generator;

import org.junit.jupiter.api.Test;
import step3.model.Lotto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoGeneratorTest {
	@Test
	void 로또생성() {
		List<Lotto> lottos = new AutoLottoGenerator().generate(10000);
		System.out.println(lottos);
		assertThat(lottos).hasSize(10);
	}
}
