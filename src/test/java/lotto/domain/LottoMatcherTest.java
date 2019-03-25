package lotto.domain;

import lotto.dto.Money;
import lotto.dto.UserLotto;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatcherTest {
    private Lotto lotto;

    @Before
    public void setUp() {
        lotto = new Lotto(new Money(1000));
    }

    @Test
    public void 로또3개_일치() {
        lotto.buy();
        UserLotto userLotto = lotto.getUserLotto();
        List<Integer> winningLotto = Arrays.asList(1, 8, 9, 2, 10, 3);

        for (LottoTicket ticket : userLotto.getUserLotto()) {
            final int[] count = {0};
            ticket.getTicket().stream().forEach(num -> {
                if (winningLotto.contains(num)) {
                    count[0] += 1;
                }
            });
            assertThat(count[0]).isEqualTo(3);
        }
    }
}
