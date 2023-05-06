package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTicketTest {
    @Test
    @DisplayName("로또숫자최소범위체크")
    void 로또숫자최소범위체크() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(0, 1, 5, 6, 40, 45));
        assertThatThrownBy(() -> {
            LottoTicket lottoTicket = LottoTicket.createLottoTicketByManual(numbers);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("1~45 이외의 숫자가 포함되어 있습니다.");
    }

    @Test
    @DisplayName("로또숫자최대범위체크")
    void 로또숫자최대범위체크() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 5, 6, 40, 45, 46));
        assertThatThrownBy(() -> {
            LottoTicket lottoTicket = LottoTicket.createLottoTicketByManual(numbers);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("1~45 이외의 숫자가 포함되어 있습니다.");
    }

    @Test
    @DisplayName("로또숫자6개미만체크")
    void 로또숫자6개미만체크() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 5, 6, 25, 30));
        assertThatThrownBy(() -> {
            LottoTicket lottoTicket = LottoTicket.createLottoTicketByManual(numbers);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자의 입력값은 6개 여야 합니다.");
    }

    @Test
    @DisplayName("로또숫자6개초과체크")
    void 로또숫자6개초과체크() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 5, 6, 25, 30, 35, 45));
        assertThatThrownBy(() -> {
            LottoTicket lottoTicket = LottoTicket.createLottoTicketByManual(numbers);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자의 입력값은 6개 여야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("당첨개수확인")
    @MethodSource("provideLottoNumbers")
    void 당첨개수확인(int[] inputNumbers, int matchCount) {
        ArrayList<Integer> numbers = new ArrayList<>();

        Arrays.stream(inputNumbers).forEach(i -> numbers.add(i));

        LottoTicket winningLottoTicket = LottoTicket.createLottoTicketByManual(new ArrayList<Integer>(Arrays.asList(1, 5, 10, 20, 30, 45)));

        Assertions.assertThat(winningLottoTicket.getMatchCount(numbers)).isEqualTo(matchCount);
    }

    static Stream<Object[]> provideLottoNumbers() {
        return Stream.of(new Object[][]{
                {new int[]{1, 5, 10, 20, 30, 45}, 6},
                {new int[]{2, 5, 10, 20, 30, 45}, 5},
                {new int[]{1, 5, 10, 20, 33, 44}, 4},
                {new int[]{2, 5, 10, 20, 33, 44}, 3},
                {new int[]{1, 6, 7, 8, 9, 45}, 2},
                {new int[]{6, 7, 8, 9, 10, 11}, 1},
                {new int[]{6, 7, 8, 9, 11, 12}, 0}
        });
    }
}
