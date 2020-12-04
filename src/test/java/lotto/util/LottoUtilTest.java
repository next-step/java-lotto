package lotto.util;

import lotto.domain.InputMoney;
import lotto.domain.Lotto;
import lotto.domain.Ticket;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoUtilTest {

    @Test
    void createAutoLottoList() {
        Assertions.assertThat(LottoUtil.createAutoLottoList(new Ticket(new InputMoney(3000))).size())
                .isEqualTo(3);
    }

    @Test
    void createMenualLotto() {
        Assertions.assertThat(LottoUtil.createMenualLotto(Arrays.asList(1, 2, 3, 4, 5, 6)).toString())
                .isEqualTo("[1, 2, 3, 4, 5, 6]");

    }

    @Test
    void createMenualLottoList() {
        Assertions.assertThat(LottoUtil.createMenualLottoList(Arrays.asList(1, 2, 3, 4, 5, 6)).toString())
                .isEqualTo("[[1, 2, 3, 4, 5, 6]]");
    }

    @Test
    void initTextToLotto() {
        LottoGenerator manualGenerator = new ManualLottoGenerator(Arrays.asList(1,2,3,4,5,6));
        Assertions.assertThat(LottoUtil.initTextToLotto("1, 2, 3, 4, 5, 6"))
                .isEqualToComparingFieldByField(new Lotto(manualGenerator));
    }
}