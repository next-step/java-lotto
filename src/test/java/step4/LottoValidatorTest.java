package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step4.validator.LottoValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoValidatorTest {
    @ParameterizedTest
    @DisplayName("로또 번호 검증 성공")
    @MethodSource("lottoNumSuccessSource")
    public void successLottoInput(List<Integer> lottoNums) {
        //given, when, then
        LottoValidator.validateLottoNum(lottoNums);
    }

    @ParameterizedTest
    @DisplayName("로또 번호 검증 실패")
    @MethodSource("lottoNumFailSource")
    public void failLottoInput(List<Integer> lottoNums) {
        //given, when, then
        assertThatThrownBy(() -> {
            LottoValidator.validateLottoNum(lottoNums);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("보너스 번호 검증 성공")
    public void successLottoBonusNum() {
        //given, when, then
        LottoValidator.validateBonusNum(3);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호 검증 실패")
    @CsvSource(value = {"-1", "0", "46", "47"})
    public void failLottoBonusNum(int bonusNum) {
        //given, when, then
        assertThatThrownBy(() -> {
            LottoValidator.validateBonusNum(bonusNum);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("구매 금액 입력")
    public void successLottoMoney() {
        //given, when, then
        LottoValidator.validateMoney(1000);
    }

    @Test
    @DisplayName("구매 금액 잘못 입력")
    public void failLottoMoney() {
        //given, when, then
        assertThatThrownBy(() -> {
            LottoValidator.validateMoney(-1000);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("수동 구매 검증")
    public void successManualCount() {
        //given, when, then
        LottoValidator.validateManualCount(3);
    }

    @Test
    @DisplayName("수동 구매 실패")
    public void failManualCount() {
        //given, when, then
        assertThatThrownBy(() -> {
            LottoValidator.validateManualCount(-1);
        }).isInstanceOf(RuntimeException.class);
    }

    static Stream<Arguments> lottoNumSuccessSource() {
        return Stream.of(
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 6)),
            Arguments.arguments(Arrays.asList(8, 9, 10, 11, 12, 13)),
            Arguments.arguments(Arrays.asList(15, 16, 17, 18, 19, 20))
        );
    }

    static Stream<Arguments> lottoNumFailSource() {
        return Stream.of(
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
            Arguments.arguments(Arrays.asList(8, 9, 10, 11, 12, -13)),
            Arguments.arguments(Arrays.asList(15, 16, 17, 18, 19))
        );
    }
}
