package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SplitterTest {

	@Test
	@DisplayName("스플리터 테스트")
	void generalSplitTest() {
		String[] expectedValue = {"1", "2", "3"};
		assertThat(Splitter.split("1,2:3")).isEqualTo(expectedValue);
		assertThat(Splitter.split("//;\n1;2;3")).isEqualTo(expectedValue);;
	}
}