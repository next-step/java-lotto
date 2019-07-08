package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoNumbersTest {

    @DisplayName("로또 번호가 6개 이상이면 IllegalException")
    @Test
    void throwExceptionWhenLottoNumberCountLowerThan6() {
        assertThatThrownBy(() -> new LottoNumbers(new LinkedHashSet<>(Arrays.asList(
                Number.of(4),
                Number.of(5),
                Number.of(6),
                Number.of(7),
                Number.of(8),
                Number.of(9),
                Number.of(10)))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 개수를 잘 가지고 오는 지 확인한다")
    @Test
    void getWinningCount(){
        LottoNumbers lottoNumbers = new LottoNumbers(new LinkedHashSet<>(Arrays.asList(
                Number.of(4),
                Number.of(5),
                Number.of(6),
                Number.of(7),
                Number.of(8),
                Number.of(9))));

        LottoNumbers winningNumbers = new LottoNumbers(new LinkedHashSet<>(Arrays.asList(
                Number.of(4),
                Number.of(5),
                Number.of(6),
                Number.of(7),
                Number.of(8),
                Number.of(10))));

        assertThat(lottoNumbers.getWinningCount(winningNumbers)).isEqualTo(5);
    }
}