package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {


    @Test
    @DisplayName(value = "입력번호안에 보너스볼 있는지 체크하는 테스트")
    public void checkBonusInWinningLottoTest() {
        LottoNumber bonusBall = new LottoNumber(3);
        List<LottoNumber> numberList = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        LottoNumbers testInputNumbers = new LottoNumbers(numberList);
        WinningLotto winningLotto = new WinningLotto(testInputNumbers, bonusBall);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            winningLotto.checkBonusInWinningLotto(testInputNumbers);
        });
    }

}
