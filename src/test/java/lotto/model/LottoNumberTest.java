package lotto.model;

import lotto.exception.OutOfBoundLottoNumberException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

	@ParameterizedTest
	@NullAndEmptySource
	void createWithNullableString(String nullableValue) {
		assertThatExceptionOfType(OutOfBoundLottoNumberException.class)
				.isThrownBy(() -> new LottoNumber(nullableValue));
	}

	@ParameterizedTest
	@ValueSource(strings = {"46", "0"})
	void outOfBoundWithStringConstructor(String value) {
		assertThatExceptionOfType(OutOfBoundLottoNumberException.class)
				.isThrownBy(() -> new LottoNumber(value));
	}
}