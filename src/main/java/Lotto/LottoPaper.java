package Lotto;


import java.util.*;

public class LottoPaper {

    private final int LOTTO_NUMBER_BOUND = 45;
    private final int LOTTO_MAX_LENGTH = 7;

    private List<Integer> lottoNumbers;
    private int bonusNumber;
    Map<String, Object> lottoNumberMap;

    public LottoPaper() {
        lottoNumbers = new ArrayList<>();
        makeDeal();
    }

    private Map<String, Object> makeDeal() {

        for (int i = 1; i <= LOTTO_NUMBER_BOUND; i++) {
            lottoNumbers.add(i);
        }

        Collections.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(0, LOTTO_MAX_LENGTH);
        bonusNumber = lottoNumbers.get(lottoNumbers.size() - 1);
        lottoNumbers = lottoNumbers.subList(0, LOTTO_MAX_LENGTH - 1);

        Collections.sort(lottoNumbers);

        lottoNumberMap = new HashMap<>();
        lottoNumberMap.put("lottoNumbers", lottoNumbers);
        lottoNumberMap.put("bonusNumber", bonusNumber);

        return lottoNumberMap;
    }

    public int getSize() {
        return lottoNumbers.size();
    }

    public int getNumber(int index) {
        return lottoNumbers.get(index);
    }

    public boolean contains(int value) {
        return lottoNumbers.contains(value);
    }

}
