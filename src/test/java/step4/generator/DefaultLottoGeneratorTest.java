package step4.generator;

import org.junit.jupiter.api.Test;
import step4.model.Lotto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultLottoGeneratorTest {
	@Test
	void 로또생성() {
		LottoGenerator generator = new DefaultLottoGenerator("1,2,3,4,5,6\n7,8,9,10,11,12");
		List<Lotto> lottos = generator.generate(10000);
		System.out.println(lottos);
		assertThat(lottos).hasSize(10);
	}
}
