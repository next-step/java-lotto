package lotto;

import lotto.domain.BonusBall;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.AssertionsKt.assertDoesNotThrow;

class BonusBallTest {

    @Test
    public void 보너스일치_테스트() {
        final int bonusNumber = 4;
        final int startNumber = 4;
        final int endNumber = 10;
        final boolean matchingTrue = true;
        BonusBall bonusBall = new BonusBall(bonusNumber);
        List<LottoNumber> numberList = IntStream.range(startNumber, endNumber)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        assertThat(bonusBall.checkMatching(numberList)).isEqualTo(matchingTrue);
    }

    @Test
    public void 로또_자리수_번호_테스트() {
        final int bonusNumber = 100;
        final boolean matchingTrue = true;
        assertThatIllegalArgumentException().isThrownBy(() -> {
            BonusBall bonusBall = new BonusBall(bonusNumber);
        });

    }

}