package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        Map<Integer, Long> lottoMap = new HashMap<>();
        lottoMap.put(3,1l);
        lottoMap.put(6,1l);
        lottoResult = new LottoResult(lottoMap);
    }

    @Test
    @DisplayName("로또 결과 리턴 메소드 기능 테스트")
    void winningResult() {
        Assertions.assertAll(
                ()->assertEquals(lottoResult.winningResult(3), 1l),
                ()->assertEquals(lottoResult.winningResult(6), 1l)
        );
    }

    @Test
    @DisplayName("로또 결과 당첨금 기능 테스트")
    void winnings() {
        Assertions.assertEquals(lottoResult.winnings(), 2000005000l);
    }

}