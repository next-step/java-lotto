package step2.domain;

import java.util.List;

public class WinLotto {
    public static List<Integer> winLottoNumber;

    public WinLotto(List<Integer> winLottoNumber) {
        this.winLottoNumber = winLottoNumber;
    }

    public static int match(List<Integer> buyLottoList) {
        return (int) winLottoNumber.stream().filter(number -> buyLottoList.contains(number)).count();
    }
}
