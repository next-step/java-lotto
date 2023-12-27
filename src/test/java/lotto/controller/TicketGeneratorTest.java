package lotto.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class TicketGeneratorTest {
	@DisplayName("로또 번호 6개가 1세트 들어있는 티켓 생성.")
	@Test
	void 로또_번호_6개가_들어있는_1세트의_첫번째_로또_번호() {
		assertThat(TicketGenerator.generate(1).get(0).indexOfLottos(0).isBetween(1, 45)).isTrue();
	}
}
