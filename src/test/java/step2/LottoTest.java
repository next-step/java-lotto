package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;

import java.util.List;

public class LottoTest {
    @Test
    @DisplayName("print 로 랜덤 값이 들어간 배열이 잘 생성되는지 확인")
    void randomNumbersTest() {
        Lotto lotto = new Lotto();
        List<Integer> randomNumberList = lotto.getLottoNumbers();
        System.out.println(randomNumberList);
    }


}
