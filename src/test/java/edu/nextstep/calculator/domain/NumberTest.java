package edu.nextstep.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Number: 원시값인 int형 숫자 포장 클래스")
class NumberTest {

	@DisplayName("createFromString: 정적 팩토리 메서드로서 문자열을 받아 Number 객체를 정상적으로 생성하여 리턴함.")
	@Test
	public void createFromString() {
		Number number = Number.createFromString("1");
		assertThat(number)
			.isNotNull()
			.isInstanceOf(Number.class)
			.hasFieldOrPropertyWithValue("number", 1);
	}

	@DisplayName("createFromString: 숫자로 파싱할 수 없는 문자열이 들어오면 Exception 발생.")
	@Test
	public void createFromString_shouldException() {
		assertThatThrownBy(() -> Number.createFromString("a"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("createFromInteger: 정적 팩토리 메서드로서 원시값인 int형 숫자를 받아 Number 객체를 정상적으로 생성하여 리턴함.")
	@Test
	public void createFromInteger() {
		Number number = Number.createFromInteger(1);
		assertThat(number)
			.isNotNull()
			.isInstanceOf(Number.class)
			.hasFieldOrPropertyWithValue("number", 1);
	}

	@DisplayName("createFromInteger: 음수가 들어오면 Exception 발생.")
	@Test
	public void createFromInteger_shouldException() {
		assertThatThrownBy(() -> Number.createFromInteger(-1))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("sum: Number 객체 두 개 내부의 원시값을 더하여 새로운 Number객체를 생성하여 return함")
	@Test
	void sum() {
		Number number1 = Number.createFromInteger(1);
		Number number2 = Number.createFromInteger(2);
		assertThat(number1.sum(number2)).isEqualTo(Number.createFromInteger(3));
	}

	@DisplayName("getValue: 원시값 int형을 그대로 return함.")
	@Test
	void getValue() {
		assertThat(Number.createFromString("1").getValue()).isEqualTo(1);
		assertThat(Number.createFromInteger(1).getValue()).isEqualTo(1);
	}

	@DisplayName("equals: Number 객체의 원시값이 같으면 같은 Number 객체임.")
	@Test
	void equals() {
		assertThat(Number.createFromInteger(1)).isEqualTo(Number.createFromString("1"));
		assertThat(Number.createFromInteger(1)).isNotEqualTo(Number.createFromString("2"));
	}
}