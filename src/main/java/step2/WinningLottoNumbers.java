package step2;

import step2.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLottoNumbers {
    private final LottoNumberGenerator lottoNumberGenerator;
    private List<Integer> winningNumbers = new ArrayList<>();
    private final Map<Integer, Integer> matchCountMap;

    public WinningLottoNumbers(LottoNumberGenerator lottoNumberGenerator){
        this.lottoNumberGenerator = lottoNumberGenerator;
        makeWinningNumbers();
        matchCountMap = initializeMatchCountMap();
    }

    private void makeWinningNumbers(){
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        winningNumbers = lottoNumberGenerator.generateNumbers();
        ValidationUtils.validationNumbers(winningNumbers);
    }

    public List<Integer> getWinningNumbers(){
        return winningNumbers;
    }

    private Map<Integer, Integer> initializeMatchCountMap(){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(PrizeMoney.MATCH_NUMBERS_NEED_TO_FIRST_GRADE,0);
        map.put(PrizeMoney.MATCH_NUMBERS_NEED_TO_SECOND_GRADE,0);
        map.put(PrizeMoney.MATCH_NUMBERS_NEED_TO_THIRD_GRADE,0);
        map.put(PrizeMoney.MATCH_NUMBERS_NEED_TO_FOURTH_GRADE,0);
        return map;
    }

    public void compareToWinningNumbers(LottoTickets lottoTickets){
        List<LottoTicket> lottoCollections = lottoTickets.getLottoTickets();
        for (LottoTicket lottoTicket : lottoCollections) {
            List<Integer> lottoNumbers = lottoTicket.getLottoNumbers();
            calculateMatchNumbers(lottoNumbers);
        }
    }

    private void calculateMatchNumbers(List<Integer> myLottoNumbes){
        int match = 0;
        for (int i = 0; i < myLottoNumbes.size(); i++) {
            if(myLottoNumbes.contains(winningNumbers.get(i))){
                match++;
            }
        }
        if(match>=PrizeMoney.MATCH_NUMBERS_NEED_TO_FOURTH_GRADE){
            matchCountMap.put(match, matchCountMap.get(match)+1);
        }
    }

    public Map<Integer, Integer> getMatchCountMap(){
        return matchCountMap;
    }
}
