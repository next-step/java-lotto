package step2.domain;

import java.util.ArrayList;
import java.util.List;
import step2.PurchaseInfomationDto;

public class LottoFactory {

    private static final int PRICE = 1000;

    private LottoFactory() {
    }

    public static PurchasedLotto of(PurchaseInfomationDto dto, List<String> manualLottoList) {
        validateInput(dto.getMoney());
        int autoLottoPurchasedMoney = dto.getMoney() - dto.getManualLottoCount() * PRICE;
        return toPurchasedLotto(autoLottoPurchasedMoney, manualLottoList);
    }

    private static PurchasedLotto getPurchasedLotto(int money, List<String> manualLottoList) {
        if (manualLottoList.isEmpty()) {
            List<Lotto> lottoList = new ArrayList<>();
            return new PurchasedLotto(makeAutoLottoList(money, lottoList));
        }

        List<Lotto> lottoList =
            makeAutoLottoList(money, new ManualLotto(manualLottoList).toLottoEntity());

        return new PurchasedLotto(lottoList);
    }

    private static List<Lotto> makeAutoLottoList(int money, List<Lotto> lottoStore) {
        int totalCount = money / PRICE;

        for (int i = 0; i < totalCount; i++) {
            Lotto lotto = Lotto.issue();
            lottoStore.add(lotto);
        }

        return lottoStore;
    }

    private static PurchasedLotto toPurchasedLotto(
        int autoLottoPurchasedMoney,
        List<String> manualLottoList
    ) {
        return autoLottoPurchasedMoney < PRICE
            ? new PurchasedLotto(new ManualLotto(manualLottoList).toLottoEntity())
            : getPurchasedLotto(autoLottoPurchasedMoney, manualLottoList);
    }

    private static void validateInput(int money) {
        if (money < PRICE) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다.");
        }
    }
}
