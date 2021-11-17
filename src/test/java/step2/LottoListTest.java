package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoList;
import step2.view.Input;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class LottoListTest {
    @Test
    @DisplayName("print 로 랜덤 값이 들어간 배열의 배열이 잘 생성되는지 확인")
    void randomNumbersListTest() {
        LottoList lottoList = new LottoList(5);
        List<Lotto> randomNumberList = lottoList.getLottoList();
        randomNumberList.stream().map(Lotto -> Lotto.getLottoNumbers()).forEach(System.out::println);
    }

    @Test
    @DisplayName("얼마나 로또당첨번호와 일치하는지 확인하는 checkMatching 테스트")
    void checkMatching() {
        List<Integer> winningNumber = Input.inputWinningNumbers();
        LottoList lottoList = new LottoList(3);
        List<Integer> result = lottoList.checkMatching(winningNumber);
        System.out.println(result);
    }
}
