package lotto.service;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoShop;
import lotto.domain.Money;
import lotto.domain.policy.DrawPolicy;

import lotto.dto.LottoDrawDto;
import lotto.dto.LottoOrderedDto;
import lotto.dto.LottoResultDto;


public class LottoService {
    private final LottoShop lottoShop;
    private final LottoMachine lottoMachine;

    public LottoService(DrawPolicy policy) {
        lottoMachine = new LottoMachine(policy);
        lottoShop = new LottoShop(lottoMachine);
    }

    public LottoOrderedDto purchase(int amount) {
        Money money = new Money(amount);
        List<Lotto> lotteries = lottoShop.purchase(money);
        List<String> numberList = new ArrayList<>(lotteries.size());

        lotteries.stream().map(Lotto::toString)
                          .forEach(numberList::add);

        return new LottoOrderedDto(numberList);
    }

    public LottoResultDto draw(LottoDrawDto lottoDrawDto) {
        List<String> lottoOrderedNumberList = lottoDrawDto.getNumberList();

        final Lotto winnerLotto = new Lotto(lottoDrawDto.getWinnerNumber());
        LottoResultDto resultDto = new LottoResultDto();

        for (String number : lottoOrderedNumberList) {
            long countMatches = new Lotto(number).countWinnerNumbersIn(winnerLotto);
            resultDto.putRewardRecord(countMatches);
        }
        return null;
    }
}
