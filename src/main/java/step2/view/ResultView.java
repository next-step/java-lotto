package step2.view;

import java.util.List;

public class ResultView {
    public void lottoCount(int number) {
        System.out.println(number + "개를 구매했습니다");
    }

    public void displayLottoNumber(List<Integer> numbers) {
        System.out.println(numbers);
    }

}
