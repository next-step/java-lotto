package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottosTest {

    @Test
    @DisplayName("매칭되는 로또 번호 개수에 맞는 당첨 결과를 반환")
    void calculateLottoResultTest() {
        // 셋업
        String lottoString1 = "1, 2, 3, 4, 5, 6"; // 3개 일치
        String lottoString2 = "7, 8, 9, 10, 11, 4"; // 4개 일치 + 보너스볼
        String lottoString3 = "7, 8, 9, 10, 27, 4"; // 4개 일치
        String winningNumbersString = "4, 5, 6, 7, 8, 9";

        Lotto lotto1 = new Lotto(lottoString1);
        Lotto lotto2 = new Lotto(lottoString2);
        Lotto lotto3 = new Lotto(lottoString3);
        Lotto winningNumbers = new Lotto(winningNumbersString);

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto1);
        lottoList.add(lotto2);
        lottoList.add(lotto3);

        Lottos lottos =  new Lottos(lottoList, 0);
        LottoNumber bonusBall = LottoNumber.of(11);
        PaidAmount paidAmount = new PaidAmount(4000);

        // 실행
        lottos.calculateLottoResult(winningNumbers, bonusBall, paidAmount);
        LottoResult lottoResult = lottos.getLottoResult();

        assertAll(
                () -> assertThat(lottoResult.getResultByRank(Rank.FIRST))
                        .isEqualTo(0),
                () -> assertThat(lottoResult.getResultByRank(Rank.BONUS))
                        .isEqualTo(1),
                () -> assertThat(lottoResult.getResultByRank(Rank.SECOND))
                        .isEqualTo(0),
                () -> assertThat(lottoResult.getResultByRank(Rank.THIRD))
                        .isEqualTo(1),
                () -> assertThat(lottoResult.getResultByRank(Rank.FOURTH))
                        .isEqualTo(1)
        );
    }
}
