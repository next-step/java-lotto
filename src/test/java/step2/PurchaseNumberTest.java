package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Match;
import step2.domain.PurchaseNumbers;
import step2.domain.WinningNumber;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PurchaseNumberTest {

    @Test
    void 로또_번호는_6개여야_한다() {

        // given
        List<List<Integer>> numbers = List.of(
                asList(1, 2, 3, 4, 5, 6, 7)
        );

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseNumbers.generate(numbers))
                .withMessage("로또 번호는 6개여야 합니다.");

    }

    @Test
    void 로또_번호는_중복될_수_없다() {

        // given
        List<List<Integer>> numbers = List.of(
                asList(1, 2, 3, 4, 5, 5)
        );

        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PurchaseNumbers.generate(numbers))
                .withMessage("서로 다른 번호를 입력해주세요.");
    }

    @Test
    void 당첨_번호와_일치하는_개수를_리스트로_반환한다() {

        List<List<Integer>> numbers = asList(
                asList(1, 2, 3, 4, 5, 6),
                asList(2, 3 ,4, 5, 6, 7),
                asList(4, 5, 6, 8, 11, 13),
                asList(4, 5, 6, 8, 11, 12)
        );

        PurchaseNumbers purchaseNumbers = PurchaseNumbers.generate(numbers);
        List<Integer> winningNumbers = asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumber lottoNumber = WinningNumber.generate(winningNumbers, bonusNumber);

        List<Match> result = purchaseNumbers.countNumber(lottoNumber);

        assertThat(result).hasSize(4);
        assertThat(result).contains(
                Match.from(3, false),
                Match.from(5, true),
                Match.from(6, false)
        );
    }
}
