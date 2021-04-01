package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    List<Lotto> lottoList;

    public User() {
        this.lottoList = new ArrayList<>();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void buyLottos(Lotto defaultLotto) {
        lottoList.add(defaultLotto.buyLotto());
    }


    public int winningConfirm(Lotto winningLotto, Lotto lotto) {
        int count = 0;
        List<Integer> number = lotto.getLottoNumber();

        for (int i = 0; i < number.size(); i++) {
            count += winningLotto.numberConfirm(number.get(i));
        }
        return count;
    }
}
