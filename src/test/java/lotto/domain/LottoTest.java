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
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class LottoTest {

    static Stream<Arguments> generateLottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(Arrays.asList(7, 8, 9, 10, 11, 12), 0)
        );
    }

    @DisplayName("인자로 받은 로또 번호 크기가 6개가 아니면 IllegalArgumentException을 발생시킨다.")
    @Test
    void throw_IllegalArgumentException_when_size_is_not_6() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .withMessage("로또는 6개의 로또 번호로 구성되어야 합니다.");
    }

    @DisplayName("두 개의 LottoNumbers가 주어졌을 때 매칭되는 갯수를 반환한다.")
    @MethodSource("generateLottoNumbers")
    @ParameterizedTest(name = "LottoNumbers: {0}, matchingCount: {1}개")
    void return_counting_of_matching_lottoNumbers(List<Integer> given, int expected) {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int actual = winningLotto.countMatchingNumbers(new Lotto(given));

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("로또 구입금액이 1000원 미만이면 IllegalArgumentException을 발생시킨다.")
    @Test
    void throw_IllegalArgumentException_when_purchaseAmount_is_underThan_1000() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.validatePurchaseAmount(999))
                .withMessage("구입금액은 최소 1000원 이상이어야 합니다.");
    }
}
