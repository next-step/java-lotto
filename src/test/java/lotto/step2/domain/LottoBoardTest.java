package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoBoardTest {

    @DisplayName("LottoBoard 생성 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoBoardList")
    void lottoGame_of(long[] input, long[] expected) {
        List<Long> lottoBoardInputList = new ArrayList<>(Arrays.stream(input)
                .boxed()
                .collect(Collectors.toList()));
        LottoBoard lottoBoard = LottoBoard.of(lottoBoardInputList);

        List<Long> lottoBoardExpectedList = new ArrayList<>(Arrays.stream(expected)
                .boxed()
                .collect(Collectors.toList()));

        assertThat(lottoBoard).isEqualTo(LottoBoard.of(lottoBoardExpectedList));
    }

    private static Stream<Arguments> provideLottoBoardList() {
        return Stream.of(
                Arguments.of(new long[]{1, 3, 2, 2, 6, 5, 0, 4}, new long[]{1, 3, 2, 2, 6, 5, 0, 4}),
                Arguments.of(new long[]{2, 5, 1, 0, 0, 1, 3, 5}, new long[]{2, 5, 1, 0, 0, 1, 3, 5}),
                Arguments.of(new long[]{0, 0, 1, 0, 0, 1, 3, 2}, new long[]{0, 0, 1, 0, 0, 1, 3, 2})
        );
    }
}
