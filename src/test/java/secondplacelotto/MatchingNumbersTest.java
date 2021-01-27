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
        MatchingNumbers matchingNumbers = new MatchingNumbers();
        assertTrue(matchingNumbers.getMatchingNumbersCount() == 5);
    }

    @Test
    @DisplayName("당첨번호 매칭 카운트가 제대로 되는가")
    public void matchWinnerNumber() {
        MatchingNumbers matchingNumbers = new MatchingNumbers();

        matchingNumbers.addMatchingCount("5");
        assertEquals(matchingNumbers.getMatchingCount("5"), 1);
    }
}
