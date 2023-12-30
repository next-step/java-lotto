package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTicket {

    private static final int LOTTO_NUMBERS_LENGTH = 6;
    private List<LottoNumbers> allLottoNumbers;

    public LottoTicket() {
        this.allLottoNumbers = new ArrayList<>();
    }

    public LottoTicket(int numberOfLotto) {
        this();
        for (int i = 0; i < numberOfLotto; i++) {
            LottoNumbers newLottoNumbers = LottoNumbers.create();
            allLottoNumbers.add(newLottoNumbers);
        }
    }

    public LottoTicket(Integer... integerLottoNumbers) {
        this();
        allLottoNumbers.add(new LottoNumbers(integerLottoNumbers));
    }

    public List<LottoNumbers> allLottoNumbers() {
        return allLottoNumbers;
    }

    public Map<Integer, Integer> match(LottoNumbers winningNumbers) {
        Map<Integer, Integer> result = initializeLottoMatchResultMap();
        for (LottoNumbers lottoNumbers : allLottoNumbers) {
            int duplicateNumberCount = lottoNumbers.countDuplicateNumber(winningNumbers);
            result.replace(duplicateNumberCount, result.get(duplicateNumberCount) + 1);
        }
        return result;
    }

    private Map<Integer, Integer> initializeLottoMatchResultMap() {
        Map<Integer, Integer> lottoResultMap = new HashMap<>();
        for (int i = 0; i <= LOTTO_NUMBERS_LENGTH; i++) {
            lottoResultMap.put(i, 0);
        }
        return lottoResultMap;
    }

}
