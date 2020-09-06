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

    public List<UserLotto> getLottos() {
        return userLottos;
    }

    public static List<UserLotto> buyLottosWith(int budget) {
        int numOfLottos = CheckDivideBy.divideToInt(Integer.toString(budget), "1000");
        List<UserLotto> userLottoList = new ArrayList<>(numOfLottos);
            for (int i = 0; i < numOfLottos ; i++) {
                userLottoList.add(new UserLotto());
            }
            return userLottoList;
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
