package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class ManualBuyDetailsTest {
    public static LottoNumbers LOTTO_NUMBERS = new LottoNumbers(new int[] {1,2,3,4,5,6});
    @Test
    void create_validation_null_lottoNumber() {
        assertThatThrownBy(()->
                new ManualBuyDetails(1, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create_validation_count_lottoNumbers() {
        assertThatThrownBy(() ->
                        new ManualBuyDetails(1, new ArrayList<LottoNumbers>()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create_normal() {
        assertThat(new ManualBuyDetails(1, Arrays.asList(LOTTO_NUMBERS)));
    }
}
