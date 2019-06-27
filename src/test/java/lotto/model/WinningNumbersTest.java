package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningNumbersTest {

    @Test
    @DisplayName("당첨 번호와 일치 개수")
    public void compareNumbers() {


        LottoNumbers lottoNumbers = new LottoNumbers(
                Arrays.asList(
                        new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(4),
                        new Number(5),
                        new Number(6)
                )
        );
        WinningNumbers winningNumbers = new WinningNumbers(
                new LottoNumbers(
                        Arrays.asList(
                                new Number(1),
                                new Number(2),
                                new Number(3),
                                new Number(4),
                                new Number(5),
                                new Number(6)
                        )
                ),
                new Number(7)
        );

        assertThat(winningNumbers.match(lottoNumbers)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("보너스 넘버가 중복일 경우 예외처리")
    public void bonusDuplicationException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningNumbers(
                    new LottoNumbers(
                            Arrays.asList(
                                    new Number(1),
                                    new Number(2),
                                    new Number(3),
                                    new Number(4),
                                    new Number(5),
                                    new Number(7)
                            )
                    ),
                    new Number(7)
            );
        });
    }
}