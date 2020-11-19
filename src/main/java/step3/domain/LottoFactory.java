package step3.domain;

import step3.exception.LottoMoneyException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    private static final int LOTTO_PRICE = 1000;
    private final Lottos lottos;

    public LottoFactory(final int money, final LottoGeneratorStrategy lottoMakeStrategy) {
        validMoney(money);

        lottos = new Lottos(IntStream.range(0 , getLottoTicketCount(money))
                        .mapToObj(i -> new Lotto(lottoMakeStrategy.generateLottoNumbers()))
                        .collect(Collectors.toList()));
    }

    public LottoMatcher matchNumbers(Lotto lastWeekLottoNums, LottoNumber bonusCount) {
        return LottoMatcher.ofMatch(lottos, LastWeekLotto.of(lastWeekLottoNums, bonusCount));
    }

    private int getLottoTicketCount(int money) {
        return money / LOTTO_PRICE;
    }

    private void validMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new LottoMoneyException();
        }
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
