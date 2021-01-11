package secondplacelotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import secondplacelotto.model.BonusNumber;
import secondplacelotto.model.LottoNumber;
import secondplacelotto.model.MatchingNumbers;

public class MatchingNumbersTest {

    @Test
    @DisplayName("매칭 기준들의 갯수를 잘 가져오는가")
    public void getMatchingNumberCount() {
        assertTrue(MatchingNumbers.getMatchingNumbersCount() == 5);
    }

    @Test
    @DisplayName("당첨번호 매칭 카운트가 제대로 되는가")
    public void matchWinnerNumber() {
        BonusNumber bonusNumber = new BonusNumber(38);

        MatchingNumbers.addMatchingCount("5", bonusNumber);
        assertEquals(MatchingNumbers.getMatchingCount(2), 1);

        LottoNumber lottoNumber = new LottoNumber(38);
        bonusNumber.match(lottoNumber,5);
        MatchingNumbers.addMatchingCount("5", bonusNumber);
        assertEquals(MatchingNumbers.getMatchingCount(3), 1);
    }
}
