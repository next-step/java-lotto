package step4.domain;

import step4.exception.LottoMoneyException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    private final Lottos lottos;


    public LottoFactory(final AutoLottoFactory autoLottoFactory, final ManualLottoFactory manualLottoFactory) {

        lottos = new Lottos(addLottoList(autoLottoFactory, manualLottoFactory));
    }

    private List<Lotto> addLottoList(AutoLottoFactory autoLottoFactory, ManualLottoFactory manualLottoFactory) {
        List<Lotto> lottoList = new ArrayList<>();
        manualLottoFactory.addList(lottoList);
        autoLottoFactory.addList(lottoList);
        return lottoList;
    }

    public LottoMatcher matchNumbers(Lotto lastWeekLottoNums, LottoNumber bonusCount) {
        return LottoMatcher.ofMatch(lottos, LastWeekLotto.of(lastWeekLottoNums, bonusCount));
    }


    public int getLottoCount() {
        return lottos.getLottoCount();
    }


    public List<String> getLottoNumbersListToString() {
        return lottos.lottoNumbersToStringList();
    }

    public double getLottoRatio(LottoMatcher lottoMatcher, int lottoInvestMoney) {
        return lottoMatcher.getGamePrize()
                .splitRate(new GameMoney(lottoInvestMoney));
    }
}
