package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FormulaTest {

	@Test
	void 미완성_계산식을_입력할_경우_IllegalArgumentException를_던진다() {
		String incompleteFormula = "1 + ";

		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Formula(incompleteFormula);
		});
	}

}
