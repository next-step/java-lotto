package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.util.NumberUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RevenueTest {

    @DisplayName("로또 번호 일치, 개수 체크 테스트")
    @ParameterizedTest
    @MethodSource("provideCheckTheNumberOfMatchingLottoTest")
    public void checkTheNumberOfMatchingLotto(Ticket lottoNumbers,
        WinningInfo winningNumbers, Enum<Revenue> expected) {
        assertEquals(expected,
            Revenue.checkTheNumberOfMatchingLotto(lottoNumbers, winningNumbers));
    }

    private static Stream<Arguments> provideCheckTheNumberOfMatchingLottoTest() {
        return Stream.of(
            Arguments.of(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::new).collect(
                Collectors.toList())), new WinningInfo(new WinningNumber(
                    new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::new).collect(Collectors.toList()))), new LottoNumber(8)),
                Revenue.SIX),
            Arguments.of(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::new).collect(
                Collectors.toList())), new WinningInfo(new WinningNumber(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 7).stream().map(LottoNumber::new).collect(
                Collectors.toList()))), new LottoNumber(6)),
                Revenue.FIVE_AND_BONUS),
            Arguments.of(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::new).collect(
                Collectors.toList())), new WinningInfo(new WinningNumber(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 7).stream().map(LottoNumber::new).collect(
                Collectors.toList()))), new LottoNumber(9)),
                Revenue.FIVE),
            Arguments.of(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::new).collect(
                Collectors.toList())), new WinningInfo(new WinningNumber(new Ticket(Arrays.asList(1, 2, 3, 4, 45, 44).stream().map(LottoNumber::new).collect(
                Collectors.toList()))), new LottoNumber(9)),
                Revenue.FOUR),
            Arguments.of(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::new).collect(
                Collectors.toList())), new WinningInfo(new WinningNumber(new Ticket(Arrays.asList(1, 2, 3, 33, 22, 11).stream().map(LottoNumber::new).collect(
                Collectors.toList()))), new LottoNumber(44)),
                Revenue.THREE),
            Arguments.of(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::new).collect(
                Collectors.toList())), new WinningInfo(new WinningNumber(new Ticket(Arrays.asList(11, 22, 33, 44, 45, 37).stream().map(LottoNumber::new).collect(
                Collectors.toList()))), new LottoNumber(10)),
                Revenue.NOTHING)
        );
    }
}
