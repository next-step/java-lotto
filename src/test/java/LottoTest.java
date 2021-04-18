import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Statistic;
import lotto.dto.InfoDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LottoTest {

    public Lottos lottos;

    @BeforeEach
    public void beforeEach(){
        lottos = new Lottos();
    }

    @Test
    @DisplayName("가격을 입력했을 때 사용자가 구매한 로또의 개수 반환")
    public void calculate_purchaseNum(){
        int purchaseNum = lottos.calculatePurchaseNum(14000);
        Assertions.assertThat(purchaseNum).isEqualTo(14);
    }

    @Test
    @DisplayName("알맞지 않은 가격을 입력했을 때 exception")
    public void calculate_Invalid_purchaseNum(){

        Assertions.assertThatIllegalStateException().isThrownBy(
                ()->{lottos.calculatePurchaseNum(140);}
        );
    }

    @Test
    @DisplayName("로또 넘버가 자동으로 잘 생성되는지 확인")
    public void generate_auto_lotto(){
        LottoNumber lottoNumber = new LottoNumber();
        List<Integer> lottoNumbers = lottoNumber.generateAuto();
        System.out.println("로또 넘버는"+lottoNumbers.toString());
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(6);

    }

    @Test
    @DisplayName("lottos에 lotto 리스트가 잘 초기화 되는지")
    public void initialize_lotto(){
        //given
        lottos.calculatePurchaseNum(5000);
        lottos.initializeLottoNumbers();

        //when
        String lottoNumbers = lottos.lottoNumbersToString();

        //than
        Assertions.assertThat(lottoNumbers.contains("["));
        Assertions.assertThat(lottoNumbers.contains("]"));
        System.out.println(lottoNumbers);

    }

    @Test
    @DisplayName("당첨번호를 제대로 입력받는지 확인")
    public void get_win_number(){

        List<Integer> winNumbers = lottos.winNumbers("1 , 4 , 5, 23, 43, 45");
        Assertions.assertThat(winNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨번호를 제대로 입력못했을때 예외")
    public void get_win_number_exception(){

        Assertions.assertThatIllegalStateException().isThrownBy(
                ()->{lottos.winNumbers("1 , 4 , 5, 23, 43");;}
        );
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
        lottos.calculatePurchaseNum(5000);
        lottos.initializeLottoNumbers();

        List<Long> correctNumbers = lottos.correctNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(correctNumbers);
    }

    @Test
    @DisplayName("각 lotto 의 맞은개수를 받아 통계를 잘 추합하는지 확인")
    public void lotto_statistic(){
        Map<Long, Integer> statistic = lottos.statistic(Arrays.asList(3L, 3L, 3L, 4L, 5L, 3L));
        Assertions.assertThat(statistic.get(3L)).isEqualTo(4);
    }

    @Test
    @DisplayName("통계 내용을 잘 전달하는지 확인")
    public void statistic(){
        Map<Long, Integer> statistic = lottos.statistic(Arrays.asList(3L, 3L, 3L, 4L, 5L, 3L));
        Statistic lottoStatistic = new Statistic(6000,statistic);
        Assertions.assertThat(lottoStatistic.getInfoDtos().size()).isEqualTo(4);
    }
}
