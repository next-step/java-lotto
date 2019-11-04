package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class AutoLottoTest {
	@ParameterizedTest
	@ValueSource(ints = {0, -100, 900})
	void vaidateTest(int money) {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new AutoLotto(money);
		});
	}

	@Test
	void mapTest() {
		String s = "1,2,3,4,5";
		System.out.println(Arrays.asList(s.replaceAll(" ", "").split(",")));
		System.out.println(Arrays.asList(s.replaceAll(" ", "").split(",")).stream().map(s1 -> Integer.parseInt(s1)).collect(Collectors.toList()));
	}
}
