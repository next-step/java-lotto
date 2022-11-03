package step3;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperatorTest {

	@Test
	@DisplayName("몇등인지 확인")
	void find() {
		Operator one = Operator.find(1, false);
		Operator two = Operator.find(2, false);
		Operator three = Operator.find(3, false);
		Operator four = Operator.find(4, false);
		Operator five = Operator.find(5, false);
		Operator bonus = Operator.find(5, true);
		Operator six = Operator.find(6, false);

		assertThat(one).isEqualTo(Operator.NOT_RANK);
		assertThat(two).isEqualTo(Operator.NOT_RANK);
		assertThat(three).isEqualTo(Operator.THREE);
		assertThat(four).isEqualTo(Operator.FOUR);
		assertThat(five).isEqualTo(Operator.FIVE);
		assertThat(bonus).isEqualTo(Operator.FIVE_BONUS);
		assertThat(six).isEqualTo(Operator.SIX);
	}
}
