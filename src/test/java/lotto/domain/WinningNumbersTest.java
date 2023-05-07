package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    void 보너스판별개수_보너스불일치_당첨() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            lottos.add(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(7))));
        }

        List<LottoNumber> winning = List.of(new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        WinningNumbers winningNumbers = new WinningNumbers(winning, new LottoNumber(8));
        Map<Rank, Integer> result = WinningResult.of(winningNumbers, new Lottos(lottos)).result();

        assertAll(
            () -> assertThat(result.keySet()).containsExactlyInAnyOrder(Rank.FIFTH_GRADE, Rank.FOURTH_GRADE,
                Rank.THIRD_GRADE, Rank.SECOND_GRADE, Rank.FIRST_GRADE),
            () -> assertThat(result.get(Rank.FIRST_GRADE)).isEqualTo(0),
            () -> assertThat(result.get(Rank.SECOND_GRADE)).isEqualTo(0),
            () -> assertThat(result.get(Rank.THIRD_GRADE)).isEqualTo(3),
            () -> assertThat(result.get(Rank.FOURTH_GRADE)).isEqualTo(0),
            () -> assertThat(result.get(Rank.FIFTH_GRADE)).isEqualTo(0)
        );
    }

    @Test
    void 보너스판별번호_보너스일치_당첨() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            lottos.add(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(7))));
        }

        List<LottoNumber> winning = List.of(new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        WinningNumbers winningNumbers = new WinningNumbers(winning, new LottoNumber(7));
        Map<Rank, Integer> result = WinningResult.of(winningNumbers, new Lottos(lottos)).result();

        assertAll(
            () -> assertThat(result.keySet()).containsExactlyInAnyOrder(Rank.FIFTH_GRADE, Rank.FOURTH_GRADE,
                Rank.THIRD_GRADE, Rank.SECOND_GRADE, Rank.FIRST_GRADE),
            () -> assertThat(result.values()).containsExactlyInAnyOrder(0, 0, 0, 3, 0),
            () -> assertThat(result.get(Rank.FIRST_GRADE)).isEqualTo(0),
            () -> assertThat(result.get(Rank.SECOND_GRADE)).isEqualTo(3),
            () -> assertThat(result.get(Rank.THIRD_GRADE)).isEqualTo(0),
            () -> assertThat(result.get(Rank.FOURTH_GRADE)).isEqualTo(0),
            () -> assertThat(result.get(Rank.FIFTH_GRADE)).isEqualTo(0)
        );
    }

    @Test
    void 당첨번호와보너스번호중복() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new WinningNumbers(
                List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                    new LottoNumber(5), new LottoNumber(6))
                , new LottoNumber(6)))
            .withMessageMatching("당첨 번호와 보너스 번호가 중복됩니다 : 6");
    }

    @Test
    void 보너스번호미입력() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new WinningNumbers(
                List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                    new LottoNumber(5), new LottoNumber(6))
                , null))
            .withMessageMatching("보너스번호는 필수입니다");
    }

    @Test
    void 중복불가() {
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1), new LottoNumber(1),
            new LottoNumber(1), new LottoNumber(1), new LottoNumber(1), new LottoNumber(1));
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new WinningNumbers(lottoNumbers, new LottoNumber(7)))
            .withMessageMatching("당첨번호의 개수가 다릅니다 : 1");
    }

    @Test
    void 당첨결과판별() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            lottos.add(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))));
        }
        for (int i = 0; i < 3; i++) {
            lottos.add(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(7))));
        }
        for (int i = 0; i < 1; i++) {
            lottos.add(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(7), new LottoNumber(8))));
        }

        List<LottoNumber> winning = List.of(new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        WinningNumbers winningNumbers = new WinningNumbers(winning, new LottoNumber(7));
        Map<Rank, Integer> result = WinningResult.of(winningNumbers, new Lottos(lottos)).result();

        assertAll(
            () -> assertThat(result.keySet()).containsExactlyInAnyOrder(Rank.FIFTH_GRADE, Rank.FOURTH_GRADE,
                Rank.THIRD_GRADE, Rank.SECOND_GRADE, Rank.FIRST_GRADE),
            () -> assertThat(result.values()).containsExactlyInAnyOrder(0, 1, 0, 3, 2),
            () -> assertThat(result.get(Rank.FIRST_GRADE)).isEqualTo(2),
            () -> assertThat(result.get(Rank.SECOND_GRADE)).isEqualTo(3),
            () -> assertThat(result.get(Rank.THIRD_GRADE)).isEqualTo(0),
            () -> assertThat(result.get(Rank.FOURTH_GRADE)).isEqualTo(1),
            () -> assertThat(result.get(Rank.FIFTH_GRADE)).isEqualTo(0)
        );
    }

    @Test
    void 당첨번호입력개수부족() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new WinningNumbers(
                List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                    new LottoNumber(4)),
                new LottoNumber(7)))
            .withMessageMatching("당첨번호의 개수가 다릅니다 : " + 4);
    }

    @Test
    void 당첨번호생성() {
        WinningNumbers winningNumbers = new WinningNumbers(
            List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6))
            , new LottoNumber(7));
        assertAll(
            () -> assertThat(winningNumbers.bonus()).isEqualTo(new LottoNumber(7)),
            () -> assertThat(winningNumbers.numbers())
                .isEqualTo(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                    new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))
        );
    }

}
