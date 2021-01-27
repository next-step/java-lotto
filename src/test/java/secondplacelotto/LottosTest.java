package secondplacelotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import secondplacelotto.model.BonusNumber;
import secondplacelotto.model.Lotto;
import secondplacelotto.model.Lottos;
import secondplacelotto.model.MatchingNumbers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottosTest {

    @Test
    @DisplayName("로또 갯수를 잘 가져오는가")
    public void matchNumber() {
        List<Lotto> lottoList = new ArrayList<>();

        lottoList.add(new Lotto());
        lottoList.add(new Lotto());
        lottoList.add(new Lotto());

        Lottos lottos = new Lottos(lottoList);

        assertEquals(lottos.getLottosCount(), 3);
    }

    @Test
    @DisplayName("로또 비교를 잘 하는가")
    public void matchLotto() {
        List<Lotto> lottoList = new ArrayList<>();

        String[] lottoNumbers = {"1","2","3","4","5","6"};

        Lotto lotto = new Lotto(lottoNumbers);
        lottoList.add(lotto);
        Lottos lottos = new Lottos(lottoList);

        MatchingNumbers matchingNumbers = lottos.match(lotto, new BonusNumber(7));

        assertEquals(matchingNumbers.getMatchingCount("1"), 1);
    }
}
