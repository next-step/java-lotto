package lotto;

import lotto.domain.LottoNumber;

import java.util.List;

public class ResultView {

    public void showNumberOfLotto(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void showLottos(List<LottoNumber> numbers) {
        System.out.print(numbers.toString());
        System.out.println();
    }
}
