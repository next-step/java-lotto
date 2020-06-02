package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoIssueRequestTest {

	@DisplayName("거슬러줘야 하는 돈을 받으면 IllegalArgumentException")
	@Test
	void paidMoneyToBeReturned_Then_IllegalArgumentException() {
		assertThatThrownBy(() -> new LottoIssueRequest(1100, Collections.emptyList()))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("받은 돈보다 수동 숫자가 더 많으면 IllegalArgumentException")
	@Test
	void manualNumbersExceed_Then_IllegalArgumentException() {
		List<Set<Integer>> manualNumbers = Arrays.asList(
				Stream.of(1, 2, 3, 4, 5, 6).collect(toSet()),
				Stream.of(1, 2, 3, 4, 5, 6).collect(toSet())
		);

		assertThatThrownBy(() -> new LottoIssueRequest(1000, manualNumbers))
				.isInstanceOf(IllegalArgumentException.class);
	}
}