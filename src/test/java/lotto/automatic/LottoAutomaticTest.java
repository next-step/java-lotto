package lotto.automatic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAutomaticTest {
    LottoAutomatic lottoAutomatic = new LottoAutomatic();
    @DisplayName("로또 번호 6개 사이즈 체크확인")
    @Test
    void listSize(){
        List<Integer> lottoOne = lottoAutomatic.lottoOne(lottoAutomatic.numberList());
        assertThat(lottoOne.size()).isEqualTo(6);
    }


}
