package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningSheetTest {

    private static Stream<Arguments> provideMatchInformationAndResult() {
        return Stream.of(
                Arguments.of(6, true, WinningSheet.FIRST),
                Arguments.of(5, true, WinningSheet.SECOND),
                Arguments.of(5, false, WinningSheet.THIRD)
        );
    }

    @DisplayName("일치 개수와 맞는 당첨을 찾는다.")
    @ParameterizedTest
    @MethodSource("provideMatchInformationAndResult")
    void findByMatchCount(int matchCount, boolean matchBonus, WinningSheet findResult) {
        WinningSheet findSheet = WinningSheet.findByMatchCount(matchCount, matchBonus);
        assertThat(findSheet).isEqualTo(findResult);
    }

    @DisplayName("일치 개수가 0 이거나 당첨 개수가 아니면 FAIL 반환")
    @ParameterizedTest
    @CsvSource({"2, true", "1, false", "0, true"})
    void findByMissMatchCount(int missMatchCount, boolean matchBonus) {
        WinningSheet failSheet = WinningSheet.findByMatchCount(missMatchCount, matchBonus);
        assertThat(failSheet).isEqualTo(WinningSheet.FAIL);
    }

    @DisplayName("Enum 리스트안에 자신이 몇개 있는지 반환한다.")
    @ParameterizedTest
    @CsvSource({"FAIL, 1", "THIRD, 2", "FIRST, 0"})
    void countInList(String name, int count) {
        List<WinningSheet> winningSheets = Arrays.asList(WinningSheet.FAIL, WinningSheet.THIRD, WinningSheet.THIRD);
        WinningSheet findSheet = WinningSheet.valueOf(name);

        assertThat(findSheet.countInList(winningSheets)).isEqualTo(count);
    }
}
