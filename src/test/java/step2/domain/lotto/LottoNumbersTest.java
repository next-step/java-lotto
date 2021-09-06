package step2.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.vo.Rank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {
    @Test
    void createLottoNumbersDuplicateExceptionTest() {
        assertThatThrownBy(() -> new LottoNumbers(() -> 1))
                .isExactlyInstanceOf(RuntimeException.class)
                .hasMessage("로또 숫자 생성 시간이 초과되었습니다.");
    }

    @Test
    void createLottoNumbersSuccessTest() {
        final LottoNumbers actual = new LottoNumbers(
                new LottoNumberGenerationStrategy() {
                    List<Integer> range = Arrays.asList(1, 2, 3, 4, 5, 6);

                    @Override
                    public int generateNumber() {
                        Collections.shuffle(range);
                        return range.get(0);
                    }
                }
        );
        final LottoNumbers expected = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void createLottoNumbersFailTest() {
        assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(1, 1, 1, 1, 1, 1, 1)))
                .isExactlyInstanceOf(RuntimeException.class)
                .hasMessage("로또 숫자는 6개여야 입니다.");
    }

    @Test
    void createLottoNumbersFail2Test() {
        assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(1, 1, 1, 1, 1)))
                .isExactlyInstanceOf(RuntimeException.class)
                .hasMessage("로또 숫자는 6개여야 입니다.");
    }

    @Test
    @DisplayName("일반 로또 숫자 4개 일치시 4등 확인 테스트")
    void countNumberOfMatch2Test() {
        final LottoNumbers winningNumber = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 7, 8));
        final Rank actual = winningNumber.countNumberOfMatch(lottoNumbers);
        final Rank expected = Rank.FOURTH;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("일반 로또 숫자 5개 일치시 3등 확인 테스트")
    void countNumberOfMatch2SuccessTest() {
        final LottoNumbers issueLottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 45));
        final LottoNumbers winningLottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 10));
        final Rank actual = issueLottoNumbers.countNumberOfMatch(winningLottoNumbers);

        final Rank expected = Rank.THIRD;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("일반 로또 숫자 5개 일치시 2등 실패 테스트")
    void countNumberOfMatch2FailTest() {
        final LottoNumbers issueLottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 45));
        final LottoNumbers winningLottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 10));
        final Rank actual = issueLottoNumbers.countNumberOfMatch(winningLottoNumbers);

        final Rank expected = Rank.SECOND;
        assertThat(actual).isNotEqualTo(expected);
    }
}
