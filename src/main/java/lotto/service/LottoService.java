package lotto.service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import java.util.Queue;
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
        Queue<Long> winners = new ArrayDeque<>();

        for (String number : lottoPurchasedNumberList) {
            long countMatches = new Lotto(number).countWinnerNumbersIn(winnerLotto);
            winners.add(countMatches);
        }

        return statsLottoResult(winners);
    }

    private LottoResultDto statsLottoResult(Queue<Long> winners) {
        LottoResultDto lottoResultDto = new LottoResultDto();
        PrizeMapper prizeMapper = new PrizeMapper();
        LottoEarningRateCalculator calculator = new LottoEarningRateCalculator(winners.size());

        while (!winners.isEmpty()) {
            long countMatches = winners.poll();
            lottoResultDto.putRewardRecord(countMatches);
            long prize = prizeMapper.findPrizeByCountMatches(countMatches);
            calculator.cumulateEarning(prize);
        }
        for (LottoPrize prize : LottoPrize.values()) {
            lottoResultDto.putPrizeMap(prize.getCountMatches(), prize.getPrize());
        }
        lottoResultDto.setEarningRate(calculator.resultToString());
        return lottoResultDto;
    }
}
