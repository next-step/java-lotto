package lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 수동_자동_구매한_티켓이_총_개수만큼_생성되는지_테스트() {
        Lotto lotto = new Lotto();
        List<String> lottoNumbers = Arrays.asList("1, 2, 3, 4, 5, 6",
                                                    "2, 3, 4, 5, 6, 7",
                                                    "2, 3, 4, 5, 6, 7");

        int result = lotto.generateTickets(11, lottoNumbers).size();
        assertThat(result).isEqualTo(14);
    }
}