package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class UserLottos {

    private final int quantity;
    private final List<UserLotto> userLottos;

    public UserLottos(int quantity) {
        this.quantity = quantity;
        this.userLottos = createUserLottos(quantity);
    }

    private List<UserLotto> createUserLottos(int quantity) {
        List<UserLotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            lottos.add(new UserLotto());
        }
        return lottos;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<UserLotto> getRawUserLottos() {
        return new ArrayList<>(userLottos);
    }
}
