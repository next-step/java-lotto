package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {

    @ParameterizedTest
    @MethodSource("countOfLottoAndLottoNumbers")
    @DisplayName("로또 개수와 NumberDrawer를 매개변수로 받아 LottoNumbers를 반환")
    void createLottoNumbers(int countOfLotto, List<Integer> numberList) {
        List<LottoNumbers> lottoNumbers = LottoMachine.createLottoNumbers(countOfLotto, (bound, lottoCount)-> numberList);

        assertThat(lottoNumbers.size()).isEqualTo(countOfLotto);
        assertThat(lottoNumbers).containsExactly(LottoNumbers.from(numberList));
    }

    static Stream<Arguments> countOfLottoAndLottoNumbers() {
        return Stream.of(
                Arguments.arguments(1, new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)))
        );
    }
}
