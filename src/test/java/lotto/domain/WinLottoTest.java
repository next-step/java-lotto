package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinLottoTest {
    @Test
    @DisplayName("bonus번호가 맞을경우 2등 rank 리턴")
    public void bonusNumberRankTest() {
        WinLotto winLotto = new WinLotto(new Lotto(1,2,3,4,5,6),10);
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,10));
        assertThat(Rank.SECOND == winLotto.matchCount(lotto)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("4개 이하로 번호가 맞았을경우 bonus번호는 카운트하지 않음")
    @MethodSource("provideLottoNumbers")
    public void bonusNumberRankTest2(List<Integer> winLotto, int bonusNumber, List<Integer> lotto, int matchCount) {
         WinLotto win = new WinLotto(winLotto,bonusNumber);
         Lotto myLotto = new Lotto(lotto);
         assertThat(win.matchCount(myLotto).matchCount()).isEqualTo(matchCount);
    }

    private static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6),7,Arrays.asList(1,2,3,4,7,8),4),
                Arguments.of(Arrays.asList(1,2,3,4,5,6),7,Arrays.asList(1,2,3,7,8,9),3),
                Arguments.of(Arrays.asList(1,2,3,4,5,6),7,Arrays.asList(11,22,33,17,18,19),0)
        );
    }
}
