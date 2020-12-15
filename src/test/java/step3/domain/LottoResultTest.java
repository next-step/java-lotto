package step3.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.LottoResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static step3.domain.Rank.*;
import static step3.domain.factory.LottoFactory.produceLotto;

class LottoResultTest {

    LottoResult lottoResult;
    Lotto lotto;
    List<Lotto> lottos;

    @BeforeEach
    void setUp() {
        lotto = produceLotto("1,2,3,4,5,6");
        lottos = new ArrayList<>();
    }

    @Test
    @DisplayName("로또 FIRST 결과 테스트")
    void winningFirstResult() {
        lottoResult = lottoResult(FIRST.getCountOfMatch());
        Assertions.assertTrue(lottoResult.winningResult().containsKey(FIRST));
    }

    @Test
    @DisplayName("로또 SECOND 결과 테스트")
    void winningSecondResult() {
        lotto.setMatchBonus(true);
        lottoResult = lottoResult(SECOND.getCountOfMatch());
        Assertions.assertTrue(lottoResult.winningResult().containsKey(SECOND));
    }

    @Test
    @DisplayName("로또 THIRD 결과 테스트")
    void winningThirdResult() {
        lottoResult = lottoResult(THIRD.getCountOfMatch());
        Assertions.assertTrue(lottoResult.winningResult().containsKey(THIRD));
    }

    @Test
    @DisplayName("로또 FOURTH 결과 테스트")
    void winningFourthResult() {
        lottoResult = lottoResult(FOURTH.getCountOfMatch());
        Assertions.assertTrue(lottoResult.winningResult().containsKey(FOURTH));
    }

    @Test
    @DisplayName("로또 FIFTH 결과 테스트")
    void winningFifthResult() {
        lottoResult = lottoResult(FIFTH.getCountOfMatch());
        Assertions.assertTrue(lottoResult.winningResult().containsKey(FIFTH));
    }

    @Test
    @DisplayName("로또 MISS 결과 테스트")
    void winningMissResult() {
        lottoResult = lottoResult(MISS.getCountOfMatch());
        Assertions.assertTrue(lottoResult.winningResult().containsKey(MISS));
    }

    private LottoResult lottoResult(int winningCount) {
        lottos.add(lotto);
        Map<Integer, List<Lotto>> lottoResultMap = new HashMap<>();
        lottoResultMap.put(winningCount, lottos);
        return new LottoResult(lottoResultMap);
    }
}