package step2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.domain.Lotto;
import step2.domain.LottoNumbers;
import step2.domain.Lottos;
import step2.domain.Rank;
import step2.domain.WinningNumber;
import step2.service.LottoValidateService;

;

public class LottoValidateServiceTest {
    @Test
    @DisplayName("로또 검증 시스템")
    public void lottoValidateServiceTest() {
        Lotto requestFirst = new Lotto(LottoNumbers.organized(List.of(
            1, 2, 3, 4, 5, 6
        )));
        Lotto requestSecond = new Lotto(LottoNumbers.organized(List.of(
            1, 2, 3, 4, 5, 7
        )));
        Lotto requestThird = new Lotto(LottoNumbers.organized(List.of(
            1, 2, 3, 4, 7, 8
        )));
        Lotto requestFourth = new Lotto(LottoNumbers.organized(List.of(
            1, 2, 3, 7, 8, 9
        )));
        Lotto requestFifth = new Lotto(LottoNumbers.organized(List.of(
            1, 2, 7, 8, 9, 10
        )));
        Lotto requestSixth = new Lotto(LottoNumbers.organized(List.of(
            1, 7, 8, 9, 10, 11
        )));
        Lotto requestSeventh = new Lotto(LottoNumbers.organized(List.of(
            7, 8, 9, 10, 11, 12
        )));
        Lottos requestList = new Lottos(List.of(
            requestFirst, requestSecond, requestThird, requestFourth, requestFifth, requestSixth, requestSeventh
        ));
        LottoNumbers actual = LottoNumbers.organized(List.of(
            1, 2, 3, 4, 5, 6
        ));
        WinningNumber winner = new WinningNumber(actual);
        LottoValidateService lottoValidateService = new LottoValidateService(requestList, winner);
        lottoValidateService.validateAll();
        Map<Rank, Integer> result = lottoValidateService.result();
        assertAll(
            () -> assertEquals(1, result.get(Rank.FIRST)),
            () -> assertEquals(1, result.get(Rank.SECOND)),
            () -> assertEquals(1, result.get(Rank.THIRD)),
            () -> assertEquals(1, result.get(Rank.FOURTH)),
            () -> assertEquals(3, result.get(Rank.NONE))
        );
    }
}
