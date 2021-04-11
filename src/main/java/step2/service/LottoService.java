package step2.service;

import step2.domain.LottoTicket;
import step2.domain.PrizeMoney;
import step2.domain.ResultDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private final Map<Integer, Integer> lottoPrizeMap;

    public LottoService(){
        lottoPrizeMap = initializeLottoPrizeMap();
    }

    private Map<Integer, Integer> initializeLottoPrizeMap(){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = PrizeMoney.getMatchCountForPrize(PrizeMoney.LOWEST_RANK_FOR_PRIZE); i <= PrizeMoney.getMatchCountForPrize(PrizeMoney.HIGHEST_RANK_FOR_PRIZE); i++) {
            map.put(i, 0);
        }
        return map;
    }

    public void calculateNumberOfMatchToWinningNumbers(List<LottoTicket> myLottoTickets, List<Integer> winningNumbers
            , PrizeMoney prizeMoney, ResultDto resultDto){
        for (int i = 0; i < myLottoTickets.size(); i++) {
             LottoTicket lottoSingleTicket = myLottoTickets.get(i);
             List<Integer> myLottoNumbers = lottoSingleTicket.getNumbers();
            compareToWinningNumbers(myLottoNumbers,winningNumbers, prizeMoney, resultDto);
        }
        resultDto.setMatchCount(lottoPrizeMap);
    }

    private void compareToWinningNumbers(List<Integer> myLottoNumbers, List<Integer> winningNumbers, PrizeMoney prizeMoney, ResultDto resultDto){
        int match = 0;
        for (int i = 0; i < myLottoNumbers.size(); i++) {
            if(myLottoNumbers.contains(winningNumbers.get(i))){
                match++;
            }
        }
        if(match >= PrizeMoney.getMatchCountForPrize(PrizeMoney.LOWEST_RANK_FOR_PRIZE)){
            lottoPrizeMap.put(match, lottoPrizeMap.get(match)+1);
            resultDto.setPrizeMoney(prizeMoney.getPrizeMoneyAsMatchCount(match));
        }
    }
}
