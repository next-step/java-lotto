package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @ParameterizedTest
    @ValueSource(ints = {10100, 1200, 2200})
    @DisplayName("총 로또 구매 가격 / 로또 장당 가격이 나누어 떨어지지 않을 때 예외가 발생한다.")
    void throwExceptionWhenTotalPriceNotDivisibleByTicketPrice(int totalPurchasePrice) {
        assertThatThrownBy(() -> Lotto.issueTickets(totalPurchasePrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 구매금액이 아닙니다. 로또 개수에 맞게 금액을 넣어주세요.(1장당 1000원)");
    }

    @ParameterizedTest
    @CsvSource(value = {"14000:14","1000:1","3000:3"}, delimiter = ':')
    @DisplayName("로또 구매 가격 만큼 로또를 발급한다.")
    void lottoCountTest(int totalPurchasePrice, int count) {
        List<List<Integer>> lottoResults = Lotto.issueTickets(totalPurchasePrice);
        assertThat(lottoResults).hasSize(count);
    }

    @ParameterizedTest
    @ValueSource(ints = {100000, 20000, 30000})
    @DisplayName("랜덤으로 발급된 로또 넘버가 1이상 46이하의 수를 보장한다.")
    void lottoBoundTest(int totalPurchasePrice) {
        List<List<Integer>> lottoResults = Lotto.issueTickets(totalPurchasePrice);
        assertThat(lottoResults)
                .isNotEmpty()
                .allSatisfy(lottoResult ->
                        assertThat(lottoResult)
                                .isNotEmpty()
                                .allMatch(number -> number > 0 && number < 46 )
                );
    }

    @ParameterizedTest
    @ValueSource(ints = {100000, 20000, 30000})
    @DisplayName("랜덤으로 발급된 로또 넘버가 중복을 허용하지 않는다.")
    void lottoNumberDuplicateTest(int totalPurchasePrice) {
        List<List<Integer>> lottoResults = Lotto.issueTickets(totalPurchasePrice);
        assertThat(lottoResults)
                .isNotEmpty()
                .allSatisfy(lottoResult -> {
                    Set<Integer> uniqueNumbers = new HashSet<>(lottoResult);
                    assertThat(uniqueNumbers).hasSize(lottoResult.size());
                });
    }

    @Test
    @DisplayName("발급된 로또 번호가 정렬되어 반환된다.")
    void sortTest() {
        List<List<Integer>> lottoResults = Lotto.issueTickets(2000);
        assertThat(lottoResults)
                .isNotEmpty()
                .allSatisfy(lottoResult -> assertThat(lottoResult).isSorted());
    }
}
