package step2.service;

import step2.domain.LottoTicket;
import step2.domain.LottoTickets;
import step2.domain.PrizeMoney;
import step2.domain.ResultDto;
import step2.utils.StringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private final ResultDto resultDto;
    private final Map<Integer, Integer> lottoPrizeMap;

    public LottoService(ResultDto resultDto){
        this.resultDto = resultDto;
        lottoPrizeMap = initializeLottoPrizeMap();
    }

    private Map<Integer, Integer> initializeLottoPrizeMap(){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = PrizeMoney.getMatchCountForPrize(PrizeMoney.LOWEST_RANK_FOR_PRIZE); i <= PrizeMoney.getMatchCountForPrize(PrizeMoney.HIGHEST_RANK_FOR_PRIZE); i++) {
            map.put(i, 0);
        }
        return map;
    }

    public void calculateTheMatchingNumberCompareToTheWinningNumbers(List<LottoTicket> myLottoTickets, List<Integer> winningNumbers, PrizeMoney prizeMoney, ResultDto resultDto){
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
            prizeMoney.getPrizeMoneyAsMatchCount(match);
            resultDto.setPrizeMoney(prizeMoney.getAmountOfPrizeMoney());
        }
    }

    public void calculateEarningRatio(LottoTickets lottoTickets){
        int amountOfPrizeMoney = resultDto.getSumOfPrizeMoney();
        List<LottoTicket> lottoTicketsList = lottoTickets.getLottoTickets();
        int cost = LottoTicket.LOTTO_PRICE*lottoTicketsList.size();
        double earningEatio = amountOfPrizeMoney/cost;
        resultDto.setEarningRatio(StringUtil.splitDouble(earningEatio));
    }
}
