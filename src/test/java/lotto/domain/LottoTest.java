package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssumptions.given;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    /**
     * * 로또 자동 생성 기능
     * * 로또 번호가 정렬 되어있는지 확인하는 기능
     * * 로또 당첨 번호 일치 여부 확인 기능
      */
    private static final boolean CREATE_STATE = true;
    private static final boolean SORTED_STATE = true;
    private static final boolean WIN_STATE = true;
    @DisplayName("로또 생성 후 로또가 생성되었는지 확인")
    @Test
    void createLotto(List<Integer> numbers) {
        Lotto.create();
        assertThat(Lotto.isCreate()).isEqualTo(CREATE_STATE);
    }

    @DisplayName("로또 번호가 정렬되어있는지 확인하는 기능")
    @Test
    void isSortedLotto(List<Integer> numbers) {
        Lotto.create(numbers);
        assertThat(Lotto.isSorted()).isEqualTo(SORTED_STATE);
    }

    @DisplayName("당첨 번호와 일치 여부 확인")
    @Test
    void isWin(List<Integer> numbers) {
        Lotto.create(numbers);
        assertThat(Lotto.isWin(getWinnerNumbers())).isEqualTo(WIN_STATE);
    }

    private List<Integer> getWinnerNumbers() {
        List<Integer> winnerNumbers = Arrays.asList(1,2,3,4,5,6);
        return winnerNumbers;
    }




}
