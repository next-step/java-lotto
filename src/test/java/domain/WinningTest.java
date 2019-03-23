package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningTest {
    @Test
    public void 당첨번호입력() {
        String number = "1, 2, 3, 4, 5, 6";
        Winning winning = new Winning(number);

        assertThat(winning.getNumbers().size()).isEqualTo(6);
        assertThat(winning.getNumbers().get(0).getValue()).isEqualTo(1);
    }

    @Test
    public void 당첨확인_세개일치() {
        String number = "1, 2, 3, 4, 5, 6";
        Winning winning = new Winning(number);

        String lottoNumber = "1, 2, 3, 14, 15, 16";
        Lotto lotto = new Lotto(lottoNumber);

        int result = winning.compare(lotto);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 당첨확인_네개일치() {
        String number = "1, 2, 3, 4, 5, 6";
        Winning winning = new Winning(number);

        String lottoNumber = "1, 2, 3, 4, 15, 16";
        Lotto lotto = new Lotto(lottoNumber);

        int result = winning.compare(lotto);

        assertThat(result).isEqualTo(4);
    }
}
