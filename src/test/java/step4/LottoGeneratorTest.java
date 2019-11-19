package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @DisplayName("로또번호 범위 확인: 1 ~ 45")
    @Test
    public void 로또번호_범위_확인() {
        Set<Lotto> autoLottos = LottoGenerator.purchasedLottos(3);
        assertThat(autoLottos.size()).isEqualTo(3);
    }

    @DisplayName("생성 된 로또 수량 확인")
    @Test
    public void 생성_된_로또_수량확인() {
        LottoGenerator.generateStandardLotto();
        Set<Lotto> autoLottos = LottoGenerator.purchasedLottos(3);
        assertThat(autoLottos.size()).isEqualTo(3);
    }

    @DisplayName("생성 된 로또가 6자리인지 확인")
    @Test
    public void 생성_된_로또_자릿수_확인() {
        LottoGenerator.generateStandardLotto();
        Set<Lotto> autoLottos = LottoGenerator.purchasedLottos(6);
        assertThat(autoLottos.size()).isEqualTo(LottoGenerator.WINNING_NUMBERS_LENGTH);
    }

    @DisplayName("로또 수동으로 생성하기")
    @Test
    public void 로또_수동으로_생성하기() {
        String[] winningNumbers = "30, 2, 12, 22, 45, 5".split(",");
        Set<Lotto> collectManualLotto = new LinkedHashSet<>();
        collectManualLotto.add(LottoGenerator.makeManualLottos(winningNumbers));
        for( Lotto manualLotto: collectManualLotto){
            List<LottoNumber> manual = Lotto.valueOf(manualLotto);
            assertThat(manual.size()).isEqualTo(winningNumbers.length);
        }
}

}
