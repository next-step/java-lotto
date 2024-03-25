package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

<<<<<<<< HEAD:src/test/java/lotto/domain/WinningLottoTest.java
class WinningLottoTest {
========
class LottoNumberTest {
>>>>>>>> b1837e4 (refactor : 원시값 bonusNumber와 컬렉션 winningNumbers를 합친 WinningNumber 클래스 추가):src/test/java/lotto/domain/LottoNumberTest.java

    private static Stream<Arguments> passInputListAndResult() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), 3),
                Arguments.of(List.of(1, 0, 4), List.of(1, 2, 3), 1),
                Arguments.of(List.of(1), List.of(1, 2, 3, 4), 1),
                Arguments.of(List.of(4, 3), List.of(1, 2, 3, 4), 2)
        );
    }

    private static Stream<Arguments> bonusInputAndResult() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), 2, true),
                Arguments.of(List.of(1, 2, 3), 5, false)
        );
    }

    @Test
    @DisplayName("winningNumber 또는 bonusNumber가 null이면 예외((null, 0) => IllegalArgumentException, (0, null) => IllegalArgumentException)")
    void validate_if_not_null() {
        assertThatThrownBy(() -> {
<<<<<<<< HEAD:src/test/java/lotto/domain/WinningLottoTest.java
            new WinningLotto(null, 1);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new WinningLotto(List.of(1, 2, 3), null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 숫자가 로또 넘버 안에 포함되면 예외(([1,2,3,4], 1) => IllegalArgumentException)")
    void bonus_number_should_not_be_in_lotto_numbers() {
        assertThatThrownBy(() -> {
            new WinningLotto(List.of(1, 2, 3), 1);
========
            new LottoNumber(List.of(1,2,3)).getMatchCount(new WinningNumber(nullList));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new LottoNumber(nullList).getMatchCount(new WinningNumber(List.of(1, 2, 3)));
>>>>>>>> b1837e4 (refactor : 원시값 bonusNumber와 컬렉션 winningNumbers를 합친 WinningNumber 클래스 추가):src/test/java/lotto/domain/LottoNumberTest.java
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("두 개의 배열을 비교하여 일치하는 개수 반환((1,2,3],[1,2,3]) => 3, ([1,0,4],[1,2,3]) => 1, ([1],[1,2,3,4]) =>1, ([4,3],[1,2,3,4]) => 2")
    @MethodSource("passInputListAndResult")
    void if_not_null(List<Integer> sources, List<Integer> targets, int result) {
<<<<<<<< HEAD:src/test/java/lotto/domain/WinningLottoTest.java
        int matchCount = new WinningLotto(targets).getMatchCount(new LottoNumber(sources));
========
        int matchCount = new LottoNumber(sources).getMatchCount(new WinningNumber(targets));
>>>>>>>> b1837e4 (refactor : 원시값 bonusNumber와 컬렉션 winningNumbers를 합친 WinningNumber 클래스 추가):src/test/java/lotto/domain/LottoNumberTest.java
        assertThat(matchCount).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 있는지 확인(([1,2,3], 2) => true, ([1,2,3], 5) => false")
    @MethodSource("bonusInputAndResult")
<<<<<<<< HEAD:src/test/java/lotto/domain/WinningLottoTest.java
    void if_bonus(List<Integer> sources, int bonusNumber, boolean result) {
        boolean isBonusContain = new WinningLotto(bonusNumber).isBonusContains(new LottoNumber(sources));
========
    void if_bonus(List<Integer> sources, int bonusNumber, boolean result){
        boolean isBonusContain = new LottoNumber(sources).isBonusContains(new WinningNumber(bonusNumber));
>>>>>>>> b1837e4 (refactor : 원시값 bonusNumber와 컬렉션 winningNumbers를 합친 WinningNumber 클래스 추가):src/test/java/lotto/domain/LottoNumberTest.java
        assertThat(isBonusContain).isEqualTo(result);
    }
}
