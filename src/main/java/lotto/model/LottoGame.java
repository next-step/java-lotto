package lotto.model;

import lotto.model.generate.AutoLottoNumberGenerate;
import lotto.model.generate.LottoNumberGenerate;
import lotto.model.generate.ManualLottoNumberGenerate;

import java.util.*;

import static java.util.stream.Collectors.*;

public class LottoGame {

    private List<Lotto> lottos;

    private LottoNumberGenerate lottoNumberGenerate;

    public List<Lotto> createLotto(Money money, String manualLottoNumbers) throws IllegalArgumentException {
        this.lottos = new ArrayList<>();
        manualLottoGenerate(manualLottoNumbers);

        int autoLottoTicketCount = money.buyManualLotto(lottos.size());
        autoLottoGenerate(autoLottoTicketCount);

        return lottos;
    }

    public LottoGameResult getReword(String stringNumber, Integer bonusNumber) {
        WinningLotto winnerLotto = createWinnerLotto(stringNumber, LottoNo.from(bonusNumber));
        LottoGameResult lottoGameResult = new LottoGameResult();

        for (Lotto lotto : lottos) {
            lottoGameResult.setRewordCount(lotto, winnerLotto);
        }
        return lottoGameResult;
    }

    private WinningLotto createWinnerLotto(String stringNumber, LottoNo bonusNumber) {
        Set<Integer> numbers = new HashSet(
            Arrays.asList(stringNumber.replace(" ", "").split(","))
            .stream().map(Integer::parseInt).collect(toList()));

        return WinningLotto.from(numbers, bonusNumber);
    }

    private void manualLottoGenerate(String manualLottoNumbers) {
        String[] manualLottos = manualLottoNumbers.split("\n");

        for(int i = 0; i < manualLottos.length; i++) {
            lottoNumberGenerate = new ManualLottoNumberGenerate(manualLottos[i].replace(" ", ""));

            Lotto lotto = Lotto.from(lottoNumberGenerate.generate());
            this.lottos.add(lotto);
        }
    }

    private void autoLottoGenerate(int autoLottoTicketCount) {
        lottoNumberGenerate = new AutoLottoNumberGenerate();

        for(int i= 0; i< autoLottoTicketCount; i++) {
            Lotto lotto = Lotto.from(lottoNumberGenerate.generate());
            this.lottos.add(lotto);
        }
    }

}
