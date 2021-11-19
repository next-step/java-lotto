package lotto.model;

import common.model.Number;
import common.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinnerTest {
    LottoNumbers lottoNumbers;
    LottoWinner winnerNumbers;

    @BeforeEach
    void setUp() {
        List<LottoNumber> temps = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            temps.add(new LottoNumber(7 * i + 3));
        }
        lottoNumbers = new LottoNumbers(temps);
        temps = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            temps.add(new LottoNumber(7 * i + 3));
        }
        winnerNumbers = new LottoWinner(temps);

        OutputView.print(lottoNumbers.getLottoNumbers());
        OutputView.print(winnerNumbers.getWinnerNumbers());
    }

    @Test
    @DisplayName("당첨번호 여부 확인 테스트")
    void contains() {
        assertThat(winnerNumbers.contains(new LottoNumber(10))).isTrue();
    }

    @Test
    @DisplayName("당첨시 matchCount 증가 테스트")
    void matchCount() {
        Number matchCount = new Number();
        winnerNumbers.match(new LottoNumber(10), matchCount);
        assertThat(matchCount).isEqualTo(new Number(1));
    }

    @Test
    @DisplayName("로또 당첨금 확인 테스트")
    void matchAmount() {
        winnerNumbers.match(lottoNumbers);
        assertThat(lottoNumbers.getLottoRank()).isEqualTo(LottoRank.SECOND);
    }
}