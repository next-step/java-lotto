import domain.Lotto.LottoNo;
import domain.Lotto.LottoTicket;
import domain.Lotto.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @Test
    void 보너스번호가_당첨번호에_포함되면_예외_발생() {
        List<LottoNo> winningNumbers = List.of(1, 2, 3, 4, 5, 6)
                .stream()
                .map(LottoNo::new)
                .collect(Collectors.toList());

        LottoTicket winningTicket = new LottoTicket(winningNumbers);

        LottoNo duplicateBonus = new LottoNo(6); // 당첨 번호에 이미 존재

        assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(winningTicket, duplicateBonus);
        });
    }

    @Test
    void 보너스번호가_당첨번호와_중복되지_않으면_정상_생성() {
        List<LottoNo> winningNumbers = List.of(1, 2, 3, 4, 5, 6)
                .stream()
                .map(LottoNo::new)
                .collect(Collectors.toList());

        LottoTicket winningTicket = new LottoTicket(winningNumbers);

        LottoNo bonus = new LottoNo(7); // 중복되지 않음

        assertDoesNotThrow(() -> new WinningLotto(winningTicket, bonus));
    }
}