package lotto.service;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoShop;
import lotto.domain.Money;
import lotto.domain.policy.DrawPolicy;
import lotto.domain.prize.LottoPrize;
import lotto.domain.prize.PrizeMapper;
import lotto.domain.util.LottoEarningRateCalculator;

import lotto.dto.LottoDrawDto;
import lotto.dto.LottoPurchaseMoneyDto;
import lotto.dto.LottoPurchasedDto;
import lotto.dto.LottoResultDto;


public class LottoService {
    private final LottoShop lottoShop;
    private final LottoMachine lottoMachine;

    public LottoService(DrawPolicy policy) {
        lottoMachine = new LottoMachine(policy);
        lottoShop = new LottoShop(lottoMachine);
    }

    public LottoPurchasedDto purchase(LottoPurchaseMoneyDto lottoMoneyDto) {
        Money money = new Money(lottoMoneyDto.getAmount());
        List<Lotto> lotteries = lottoShop.purchase(money);
        List<String> numberList = new ArrayList<>(lotteries.size());

        lotteries.stream().map(Lotto::toString)
                          .forEach(numberList::add);

        return new LottoPurchasedDto(numberList);
    }

    public LottoResultDto draw(LottoDrawDto lottoDrawDto) {
        List<String> lottoPurchasedNumberList = lottoDrawDto.getNumberList();
        final Lotto winnerLotto = new Lotto(lottoDrawDto.getWinnerNumber());

        PrizeMapper prizeMapper = new PrizeMapper();

        LottoResultDto resultDto = new LottoResultDto();
        for (LottoPrize prize : LottoPrize.values()) {
            resultDto.putPrizeMap(prize.getCountMatches(), prize.getPrize());
        }

        LottoEarningRateCalculator calculator = new LottoEarningRateCalculator(
            lottoPurchasedNumberList.size());

        for (String number : lottoPurchasedNumberList) {
            long countMatches = new Lotto(number).countWinnerNumbersIn(winnerLotto);
            resultDto.putRewardRecord(countMatches);

            long prize = prizeMapper.findPrizeByCountMatches(countMatches);
            calculator.cumulateEarning(prize);
        }
        resultDto.setEarningRate(calculator.resultToString());

        return resultDto;
    }
}
