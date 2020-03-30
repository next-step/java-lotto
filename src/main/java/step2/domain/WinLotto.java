package step2.domain;

import java.util.List;

public class WinLotto {
    private List<Integer> winLottoNumber;

    public WinLotto(List<Integer> winLottoNumber) {
        this.winLottoNumber = winLottoNumber;
    }

    public int match(List<Integer> buyLottos) {
        return (int) winLottoNumber.stream()
        .filter(number -> buyLottos
        .contains(number))
        .count();
    }
}
