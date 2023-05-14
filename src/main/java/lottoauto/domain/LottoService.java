package lottoauto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lottoauto.model.*;
import lottoauto.utils.ValidationUtils;

public class LottoService {

    public Lottos generateLottoNumber(int amount) {
        int quantity = ValidationUtils.amountValidateForQuantity(amount);
        List<Lotto> lotto = generateLotto(quantity);
        return new Lottos(lotto);
    }

    private List<Lotto> generateLotto(int quantity) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lotto.add(new Lotto());
        }
        return lotto;
    }

    public LottoResult compareWinningLottoNumber(Lottos lottos, WinningLotto winningLotto) {
        List<WinningReward> matchCount = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            matchCount.add(winningLotto.compare(lotto));
        }

        return new LottoResult(matchCount);
    }

}
