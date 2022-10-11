package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameTest {

	@Test
	void name() {
		assertThatThrownBy(() -> Game.start(999))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("최소 금액은 1000원 입니다");
	}
}
