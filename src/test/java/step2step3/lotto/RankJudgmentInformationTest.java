package step2step3.lotto;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RankJudgmentInformationTest {
    @Test
    void 보너스_숫자를_통해_2등을_판별할_수_있다() {
        LottoTicket lottoTicket = LottoTicket.from(new NumbersGenerator.Fake(Set.of(1, 2, 3, 4, 5, 6)));

        RankJudgmentInformation rankJudgmentInformation = new RankJudgmentInformation(7, lottoTicket);

        assertTrue(rankJudgmentInformation.isSecond(LottoTicket.from(new NumbersGenerator.Fake(Set.of(1, 2, 3, 4, 5, 7)))));
    }
}
