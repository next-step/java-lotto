package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.exception.IllegalLottoBonusNumberException;
import step2.exception.IllegalLottoNumberException;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottoBonusNumberTest {

    @DisplayName("로또 보너스 번호 - 정상 생성")
    @ParameterizedTest
    @CsvSource(
            value = {
                    "1:2:3:4:5:6:9",
                    "10:11:12:13:15:16:17",
                    "1:2:3:4:5:45:6",
                    "1:2:3:4:11:22:33",
                    "1:2:3:11:22:33:44"},
            delimiter = ':')
    void lottoBonusNumberTest(
            int first,
            int second,
            int third,
            int fourth,
            int fifth,
            int sixth,
            int bonusNumber) {
        Set<LottoNumber> expectedLottoNumbers = Stream.of(first, second, third, fourth, fifth, sixth)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        Assertions.assertDoesNotThrow(() -> new LottoBonusNumber(bonusNumber, expectedLottoNumbers));
    }

    @DisplayName("로또 보너스 번호 - 로또번호와 중복될 경우")
    @ParameterizedTest
    @CsvSource(
            value = {
                    "1:2:3:4:5:6:6",
                    "10:11:12:13:15:16:16",
                    "1:2:3:4:5:45:5",
                    "1:2:3:4:11:22:4",
                    "1:2:3:11:22:33:3"},
            delimiter = ':')
    void lottoBonusNumberDuplicatedTest(
            int first,
            int second,
            int third,
            int fourth,
            int fifth,
            int sixth,
            int bonusNumber) {
        Set<LottoNumber> expectedLottoNumbers = Stream.of(first, second, third, fourth, fifth, sixth)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        Assertions.assertThrows(
                IllegalLottoBonusNumberException.class,
                () -> new LottoBonusNumber(bonusNumber, expectedLottoNumbers));
    }
}

