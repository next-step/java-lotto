import domain.LottoGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputVeiw;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {
    int price = 14000;
    String count;
    LottoGame lottoGame;


    @BeforeEach
    void setup() {
        String priceStr = String.valueOf(price);
        count = priceStr.substring(0, priceStr.length() - 3);
        lottoGame = new LottoGame(price);
    }

    @Test
    @DisplayName("가격을 숫자로 자르기")
    void substringPricetoNumber() {
        assertThat(lottoGame.substringPricetoNumber(price)).isEqualTo(14);
    }
    
    @Test
    @DisplayName("지난 당첨번호를 잘못 입력했을 때 exception")
    void checkPrvStr() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            if (InputVeiw.checkPrvStr("12345"))
                throw new IllegalArgumentException("입력이 잘못되었습니다. 지난 당첨 번호를 다시 한번 입력해주세요.");
        });
    }

    @Test
    @DisplayName("지난 당첨번호와 당청 번호 비교 ")
    void comparePrvNumber() {
        int numofWin = 0;
        int[] prvLottoNumber = {1, 2, 3, 4, 5, 6};
        ArrayList<Integer> lottoElement = new ArrayList<>();
        for (int i = 1; i <= prvLottoNumber.length; i++) {
            lottoElement.add(i);
        }
        for (int i = 0; i < prvLottoNumber.length; ++i) {
            numofWin = lottoElement.contains(prvLottoNumber[i]) ? numofWin + 1 : numofWin;
        }
        assertThat(numofWin).isEqualTo(6);
    }

    @Test
    @DisplayName("공백문자 제거 및 , 기준으로 문자열 split ")
    void removeBlankAndSplit() {
        String input = "1, 2, 3, 4, 5, 6";
        assertThat(input.replaceAll(" ", "").split(",")).containsExactly("1", "2", "3", "4", "5", "6");
    }

    @Test
    @DisplayName("수익률을 소수점 2자리까지 만들기")
    void getPercentOfRevenue() {
        double revenue = 2332.323487;
        String[] result = String.valueOf(revenue).split("\\.");
        String percent = null;
        if (result[1].length() == 1)
            percent = result[0] + "." + result[1].substring(0, 1);
        if (result[1].length() > 1)
            percent = result[0] + "." + result[1].substring(0, 2);
        assertThat(percent).isEqualTo("2332.32");
    }
}
