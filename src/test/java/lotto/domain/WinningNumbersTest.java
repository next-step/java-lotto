package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningNumbers.Rank;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    void 중복불가() {
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(1));
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new WinningNumbers(lottoNumbers))
            .withMessageMatching("당첨번호의 개수가 다릅니다 : 1");
    }

    @Test
    void 당첨결과판별() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            lottos.add(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))));
        }
        for (int i = 0; i < 3; i++) {
            lottos.add(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(7))));
        }
        for (int i = 0; i < 1; i++) {
            lottos.add(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(7), new LottoNumber(8))));
        }

        List<LottoNumber> winning = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        WinningNumbers winningNumbers = new WinningNumbers(winning);
        Map<Rank, Integer> result = winningNumbers.winningResult(new Lottos(lottos));

        assertAll(
            () -> assertThat(result.keySet()).containsExactly(Rank.FOURTH_GRADE, Rank.THIRD_GRADE, Rank.SECOND_GRADE, Rank.FIRST_GRADE),
            () -> assertThat(result.values()).containsExactly(0,1,3,2),
            () -> assertThat(result.get(Rank.FIRST_GRADE)).isEqualTo(2),
            () -> assertThat(result.get(Rank.SECOND_GRADE)).isEqualTo(3),
            () -> assertThat(result.get(Rank.THIRD_GRADE)).isEqualTo(1),
            () -> assertThat(result.get(Rank.FOURTH_GRADE)).isEqualTo(0)
        );
    }

    @Test
    void 당첨번호입력개수부족() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new WinningNumbers(List.of(new LottoNumber(1),new LottoNumber(2),new LottoNumber(3), new LottoNumber(4))))
            .withMessageMatching("당첨번호의 개수가 다릅니다 : " + 4);
    }

    @Test
    void 당첨번호생성() {
        assertThat(new WinningNumbers(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                new LottoNumber(6))).numbers())
            .isEqualTo(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                new LottoNumber(6)));
    }

}
