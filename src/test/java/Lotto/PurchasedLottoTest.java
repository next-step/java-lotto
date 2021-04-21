package Lotto;

import lotto.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PurchasedLottoTest {

    PurchasedLottos purchasedLottos;

    @BeforeEach
    public void before(){
        List<Lotto> lottos = LottoMachine.ticketingLotto(3);
        purchasedLottos = new PurchasedLottos(lottos);
    }

    @Test
    @DisplayName("lottos에 lotto 리스트가 잘 초기화 되는지")
    public void initialize_lotto(){
        //when
        String lottoNumbers = purchasedLottos.lottoNumbersToString();

        //than
        Assertions.assertThat(lottoNumbers.contains("["));
        Assertions.assertThat(lottoNumbers.contains("]"));
        System.out.println(lottoNumbers);

    }

    @Test
    @DisplayName("lotto 가 몇개 숫자를 맞췄는지 반환")
    public void get_correct_num(){
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        long correctNum = lotto.correctNum(Arrays.asList(1,2,3,4,5,9));
        Assertions.assertThat(correctNum).isEqualTo(5);
    }

    @Test
    @DisplayName("lotto 맞은 개수들 반환")
    public void get_correct_numbers(){

        List<Long> correctNumbers = purchasedLottos.correctNumbersPerEachLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(correctNumbers);
    }
}
