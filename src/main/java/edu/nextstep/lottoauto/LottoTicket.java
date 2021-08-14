package edu.nextstep.lottoauto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private static final List<Integer> TOTAL_NUMBERS = new ArrayList<>();

    private final List<Integer> lottoNumbers;

    static{
        initTotalNumbers();
    }

    protected LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket create() {
        Collections.shuffle(TOTAL_NUMBERS);
        List<Integer> lottoNumbers = TOTAL_NUMBERS.subList(0, 6);
        Collections.sort(lottoNumbers);
        return new LottoTicket(lottoNumbers);
    }

    public static LottoTicket create(int[] lottoNumbersArr) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int lottoNumber : lottoNumbersArr) {
            lottoNumbers.add(lottoNumber);
        }
        Collections.sort(lottoNumbers);
        return new LottoTicket(lottoNumbers);
    }

    private static void initTotalNumbers() {
        for (int i = 1; i <= 45; i++) {
            TOTAL_NUMBERS.add(i);
        }
    }

    public int size() {
        return lottoNumbers.size();
    }
}
