package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DrawnLottoTest {
    @Test
    @DisplayName("보너스 넘버가 포함된 엔트리인지 테스트")
    void bonusTest() {
        DrawnLotto drawnLotto = new DrawnLotto(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList()), 7);
        boolean result = drawnLotto.bonus(new LottoEntry(Stream.of(7, 8, 9, 10, 11, 12).collect(Collectors.toList())));

        assertThat(result).isTrue();
    }
}
