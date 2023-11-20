package step2.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.model.LottoGenerator;
import step2.model.Lotto;
import step2.model.Money;

public class LottoGeneratorTest {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @ParameterizedTest
    @CsvSource(value = {"500:0", "1000:1", "2500:2"}, delimiter = ':')
    public void 금액에_맞게_생성된_로또_개수_확인_테스트(int userMoney, int expectedSize) {
        assertThat(lottoGenerator.generateLottos(new Money(userMoney).determineLottoPurchaseCount())).hasSize(expectedSize);
    }

    @Test
    public void 사용자가_입력한_우승_로또_생성하기() {
        String userInput = "1, 2, 3, 4, 5, 6";
        Integer bonusNumber = 7;
        assertThat(lottoGenerator.generateWinningLotto(userInput, bonusNumber))
                .isEqualTo(new WinningLotto(new int[]{1, 2, 3, 4, 5, 6}, bonusNumber));
    }
}
