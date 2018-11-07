package lotto.domain;

import lotto.domain.validator.LottoTicketValidator;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hspark on 07/11/2018.
 */
public class ShuffleLottoMachineTest {

	@Test
	public void test_리스트_sublist_학습테스트() {
		List<Integer> numberList = Stream.iterate(1, i -> i + 1).limit(45).collect(Collectors.toList());
		List<Integer> subList = numberList.subList(0, 6);
		Assertions.assertThat(subList).hasSize(6);
	}

	@Test
	public void test_로또번호_validator_test() {
		ShuffleLottoMachine shuffleLottoMachine = new ShuffleLottoMachine();
		for (int i = 0; i < 1000; i++) {
			LottoTicketValidator.valid(LottoTicket.newInstanceByAutomation(shuffleLottoMachine));
		}
	}
}