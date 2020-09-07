package AutoLotto.domain.lotto;

import AutoLotto.utils.CheckDivideBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserLottos {

    private final List<UserLotto> userLottos;

    public UserLottos(List<UserLotto> userLottos) {
        this.userLottos = userLottos;
    }

    public List<UserLotto> getUserLottos() {
        return userLottos;
    }

    public static List<UserLotto> buyLottosWith(int money) {
        int lottosCount = countLottosBy(money);
        List<UserLotto> userLottoList = new ArrayList<>(lottosCount);
            for (int i = 0; i < lottosCount ; i++) {
                userLottoList.add(new UserLotto());
            }
            return userLottoList;
    }

    public static int countLottosBy(int money) {
        return CheckDivideBy.divideToInt(Integer.toString(money), "1000");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        UserLottos userLottos1 = (UserLottos) o;
        return Objects.equals(userLottos, userLottos1.userLottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLottos);
    }
}
