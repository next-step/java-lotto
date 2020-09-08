package AutoLotto.domain.play;

import AutoLotto.domain.lotto.BuzzLotto;
import AutoLotto.domain.lotto.UserLotto;
import AutoLotto.domain.lotto.LottoNumber;
import AutoLotto.domain.lotto.UserLottos;
import AutoLotto.domain.money.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayLotto {

    private final Money money;
    private final List<UserLotto> userLottos;
    private final BuzzLotto buzzLotto;

    public PlayLotto(int money, List<LottoNumber> buzzLotto) {
        this(money, UserLottos.buyLottosWith(money), buzzLotto);
    }

     public PlayLotto(int money, List<UserLotto> userLottos, List<LottoNumber> buzzLotto) { //테스트 위해 userLotto 직접
        this.money = new Money(money);
        this.userLottos = userLottos;
        this.buzzLotto = new BuzzLotto(buzzLotto);
    }

    public int getMoney() {
        return money.getMoney();
    }

    public List<UserLotto> getUserLottos() {
        return userLottos;
    }

    public List<LottoNumber> getBuzzLotto() {
        return buzzLotto.getBuzzLotto();
    }

    public PlayLottoResult countMatchAll(PlayLottoResult playLottoResult) {
        for (UserLotto userLotto : userLottos) {
            playLottoResult.addRank(buzzLotto.findRankByMatch(userLotto.getUserLotto()));
        }
        return playLottoResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayLotto playLotto = (PlayLotto) o;
        return Objects.equals(money, playLotto.money) &&
                Objects.equals(userLottos, playLotto.userLottos) &&
                Objects.equals(buzzLotto, playLotto.buzzLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, userLottos, buzzLotto);
    }
}

