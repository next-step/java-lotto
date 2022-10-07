package lotto.services;

import lotto.models.Lotto;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PickNumberServiceTest {

    private static final PickNumberService pickNumberService = new PickNumberService();
    private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();
    private static final int NUMBER_COUNT = 6;
    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;

    @BeforeEach
    public void setLottoNumbers() {
        for (int num = LOTTO_FIRST_NUMBER ; num <= LOTTO_LAST_NUMBER ; num++){
            LOTTO_NUMBERS.add(num);
        }
    }

    @Test
    @DisplayName("pickNumbers 메소드는 6개의 수를 획득한다.")
    void issueLotto2() {
        assertThat(pickNumberService.pickNumbers().size()).isEqualTo(NUMBER_COUNT);
    }

    @Test
    @DisplayName("발급된 6개의 수는 중복 되지 않는다.")
    void issueLotto3() {
        Set<Integer> numberSet = Sets.newHashSet(pickNumberService.pickNumbers());
        assertThat(numberSet.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("발급된 6개의 수는 1~45 사이의 값을 가진다.")
    void issueLotto4() {
        assertThat(pickNumberService.pickNumbers()).isIn(LOTTO_NUMBERS);
    }
}
