import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {
    String price = "14000";
    String result;
    int numberOfLotto;


    @BeforeEach
    void setup() {
        result = price.substring(0, price.length() - 3);
        numberOfLotto = Integer.parseInt(result);
    }

    @Test
    @DisplayName("가격을 숫자로 자르기")
    void substringPricetoNumber() {
        assertThat(result).isEqualTo("14");
    }

    @Test
    @DisplayName("1000원보다 낮은 가격 입력이 되었을때 exception")
    void checkPrice() {
        assertThat(result.isEmpty()).isFalse();
    }

    @Test
    void makeLotto() {
        List<Integer> lotto = new ArrayList<>();
        List<Integer> element = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            element.add(i);
        }

        Collections.shuffle(element);

        for (int i = 0; i < numberOfLotto; i++) {
            lotto.add(element.get(i));
        }

        Collections.sort(lotto);
    }

    @Test
    void getNumberofWin() {
        int numofWin = 0;
        List<Integer> lotto = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            lotto.add(i);
        }

        for (int i = 1; i <= 45; i++) {
            if (lotto.contains(i))
                ++numofWin;
        }
        assertThat(numofWin).isEqualTo(6);
    }

    @Test
    void getRevenue() {
        int forth = 1;
        int third = 0;
        int second = 0;
        int first = 0;

        int total = (5000 * forth) + (50000 * third) + (1500000 * second) + (2000000000 * first);
        double revenue = total / (double)Integer.parseInt(price);
        String result = String.valueOf(revenue).substring(0,4);

        assertThat(result).isEqualTo("0.35");
    }
}
