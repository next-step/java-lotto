package lotto.application;

import lotto.domain.*;
import lotto.infra.ManualNumberGenerator;
import lotto.infra.RandomNumberGenerator;

import java.util.List;

public class LottoService {

    private final LottoSeller randomLottoSeller;
    private final LottoSeller manualLottoSeller;

    public LottoService(RandomNumberGenerator randomNumberGenerator, ManualNumberGenerator manualLottoSeller) {
        this.randomLottoSeller = new LottoSeller(randomNumberGenerator);
        this.manualLottoSeller = new LottoSeller(manualLottoSeller);
    }

    public UserLottoResult userLottoResult(User user, WinningLotto winningLotto) {
        return user.getUserLottoResult(winningLotto);
    }

    public User makeUser() {
        return new User();
    }

    public int purchaseCount(User user) {
        return user.getLottos().size();
    }



    public void purchaseLottos(User user, int purchasePrice, int manualCount) {
        if (manualCount < 0) {
            throw new IllegalArgumentException("[구매] 수동으로 구매할 개수가 0보다 작습니다.");
        }
        int manualPurchasePrice = manualCount * Lotto.PRICE;
        int randomPurchasePrice = purchasePrice - manualPurchasePrice;

        user.purchaseLottos(manualLottoSeller, manualPurchasePrice);
        user.purchaseLottos(randomLottoSeller, randomPurchasePrice);

    }

    public WinningLotto makeWinningLotto(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }

}
