package lotto.domain;

import java.util.*;

public class LottoNumbersPicker implements NumberPicker{
    private static final int MAX_BOUNDARY_NUMBER = 45;
    private static final int MAX_BOUNDARY_AMOUNT = 6;

    @Override
    public List<LottoNumber> pick() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        Random random = new Random();
        while (lottoNumbers.size() < MAX_BOUNDARY_AMOUNT) {
            int number = random.nextInt(MAX_BOUNDARY_NUMBER) + 1;
            lottoNumbers.add(new LottoNumber(number));
        }
        List<LottoNumber> lottoNumberList = new ArrayList<>(lottoNumbers);
        lottoNumberList.sort(Comparator.comparingInt(LottoNumber::getNumber));
        return lottoNumberList;
    }
}