package step4;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4.domain.Lotto;
import step4.domain.LottoNumbers;
import step4.domain.Lottos;
import step4.domain.Rank;
import step4.domain.WinningNumber;
import step4.service.LottoValidateService;

public class LottoValidateServiceTest {
    @Test
    @DisplayName("로또 검증 시스템")
    public void lottoValidateServiceTest() {
        //6개
        Lotto requestFirst = new Lotto(LottoNumbers.ofManual("1,2,3,4,5,6"));
        //5개 + 보너스
        Lotto requestSecond = new Lotto(LottoNumbers.ofManual("1,2,3,4,5,8"));
        //5개
        Lotto requestThird = new Lotto(LottoNumbers.ofManual("1,2,3,4,5,7"));
        //4개
        Lotto requestFourth = new Lotto(LottoNumbers.ofManual("1,2,3,4,7,8"));
        //3개
        Lotto requestFifth = new Lotto(LottoNumbers.ofManual("1,2,3,8,9,10"));
        //2개
        Lotto requestSixth = new Lotto(LottoNumbers.ofManual("1,7,8,9,10,11"));
        //1개
        Lotto requestSeventh = new Lotto(LottoNumbers.ofManual("7,8,9,10,11,12"));

        Lottos requestList = new Lottos(List.of(
            requestFirst, requestSecond, requestThird, requestFourth, requestFifth, requestSixth, requestSeventh
        ));
        String actual = "1,2,3,4,5,6";
        int bonusNumber = 8;
        WinningNumber winner = new WinningNumber(actual, bonusNumber);
        LottoValidateService lottoValidateService = new LottoValidateService(winner);
        Map<Rank, Integer> result = lottoValidateService.validate(requestList);
        assertThat(result).contains(
            Map.entry(Rank.FIRST, 1),
            Map.entry(Rank.SECOND, 1),
            Map.entry(Rank.FOURTH, 1),
            Map.entry(Rank.FIFTH, 1),
            Map.entry(Rank.MISS, 2)
        );
    }
}
