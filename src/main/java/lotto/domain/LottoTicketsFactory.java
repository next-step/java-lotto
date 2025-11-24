package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketsFactory {
    public static LottoTickets create(PurchaseAmount purchaseAmount) {
        int count = purchaseAmount.getLottoCount();
        List<Lotto> lottos = generateAutoLottos(count);
        return new LottoTickets(lottos, new ManualLottos(null));
    }

    public static LottoTickets create(PurchaseAmount purchaseAmount, ManualLottos manualLottos) {
        validateManualCount(purchaseAmount, manualLottos);
//        List<Lotto> allLottos = createLottos(purchaseAmount, manualLottos);
        List<Lotto> lottos = convertToLottos(manualLottos);
        List<Lotto> allLottos = createLottos(purchaseAmount, lottos, manualLottos.getCount());
        return new LottoTickets(allLottos, manualLottos);
    }

    private static List<Lotto> convertToLottos(ManualLottos manualLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (String input : manualLottos.getManualLottosInput()) {
            lottos.add(parseLotto(input));
        }
        return lottos;
    }

    private static Lotto parseLotto(String input) {
        String[] tokens = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token.trim()));
        }
        return Lotto.from(numbers);
    }


    private static void validateManualCount(PurchaseAmount purchaseAmount, ManualLottos manualLottos) {
        if (manualLottos.getCount() > purchaseAmount.getLottoCount()) {
            throw new IllegalArgumentException("수동로또 개수가 구입 가능한 개수보다 많습니다.");
        }
    }
    
    private static List<Lotto> createLottos(PurchaseAmount purchaseAmount, List<Lotto> manualLottosList, int manualCount) {
        List<Lotto> lottos = new ArrayList<>(manualLottosList);
        int autoCount = purchaseAmount.getLottoCount() - manualCount;
        lottos.addAll(generateAutoLottos(autoCount));
        return lottos;
    }

    private static List<Lotto> generateAutoLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.from(LottoNumberGenerator.generate()));
        }
        return lottos;
    }
}
