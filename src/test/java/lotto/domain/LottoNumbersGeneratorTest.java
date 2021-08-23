package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersGeneratorTest {

    @DisplayName("주어진 범위 내에서 로또 번호를 자동으로 생성 할 수 있다.")
    @Test
    public void lottoNumbersGenerateWithNumberRange() {
        LottoNumbersGenerator lottoNumbersGenerator = LottoNumbersGenerator.rangeClosed(1,6);
        List<LottoNumbers> generated = lottoNumbersGenerator.generate(Money.of(1000), PurchaseQuantity.of(0));
        LottoNumbers expected = LottoNumbers.of(createMockLottoNumbers(1,2,3,4,5,6));
        assertThat(generated.get(0).countOfMatch(expected)).isEqualTo(6);
    }

    private List<LottoNumber> createMockLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    @ParameterizedTest(name = "LottoNumberGenerator 생성 시, LottoNumber 의 범위 유효성 테스트")
    @CsvSource(value = {"3,1", "1,5"})
    public void validateRangeTest(int lowerBound, int upperBound) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbersGenerator.rangeClosed(lowerBound,upperBound))
                .withMessageContainingAll(String.valueOf(lowerBound), String.valueOf(upperBound));
    }

    @ParameterizedTest(name = "구매 금액과 수동 구매 수량이 주어지면 자동 구매 수량만큼 로또 번호를 발행한다.")
    @CsvSource(value = {"3000,0,3", "3000,3,0", "3000,1,2"})
    public void automaticGenerateTest(int purchaseMoneyAmount, int manualPurchaseQuantity, int expectedGeneratedLottoNumbersCount) {
        LottoNumbersGenerator lottoNumbersGenerator = LottoNumbersGenerator.rangeClosed(1, 45);
        List<LottoNumbers> lottoNumbers = lottoNumbersGenerator.generate(Money.of(purchaseMoneyAmount), PurchaseQuantity.of(manualPurchaseQuantity));
        assertThat(lottoNumbers).hasSize(expectedGeneratedLottoNumbersCount);
    }

}