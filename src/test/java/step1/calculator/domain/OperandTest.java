package step1.calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import step1.calculator.domain.Operand;

public class OperandTest {
	@ParameterizedTest
	@NullAndEmptySource
	void 빈문자열_혹은_null_예외처리(String nullOrEmpty) {
		assertThatThrownBy(() -> Operand.from(null))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
