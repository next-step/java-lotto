package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.enums.DrawResult;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DrawnLottoTest {
    @Test
    @DisplayName("비교 결과를 구하는 테스트")
    void getMatchResult() {
        DrawnLotto drawnLotto = new DrawnLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 45);
        LottoEntry lottoEntry1 = new LottoEntry(Arrays.asList(1, 2, 3, 7, 8, 9));

        DrawResult result = drawnLotto.getDrawResult(lottoEntry1);

        assertThat(result).isEqualTo(DrawResult.THREE_MATCH);

        LottoEntry lottoEntry2 = new LottoEntry(Arrays.asList(1, 2, 3, 4, 5, 45));

        DrawResult result2 = drawnLotto.getDrawResult(lottoEntry2);

        assertThat(result2).isEqualTo(DrawResult.FIVE_WITH_BONUS_MATCH);
    }

    @Test
    @DisplayName("보너스 넘버가 포함된 엔트리인지 테스트")
    void bonusTest() {
        DrawnLotto drawnLotto = new DrawnLotto(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()), 7);
        boolean result = drawnLotto.bonus(new LottoEntry(Stream.of(7, 8, 9, 10, 11, 12).collect(Collectors.toList())));

        assertThat(result).isTrue();
    }
}
