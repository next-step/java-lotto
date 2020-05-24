package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {

    private final static int LOTTO_MAX_NUMBER = 45;
    private final static int LOTTO_MIN_NUMBER = 1;
    private final static int LOTTO_TICKET_SIZE = 6;

    private final static int LOTTO_MATCH  = 1;
    private final static int LOTTO_NOT_MATCH  = 0;

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    private LottoTicket() {
        initLottoNumbers();
        shuffleLottoTicket();
    }

    private void initLottoNumbers() {
        for (int i = LOTTO_MIN_NUMBER; i < LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }

    protected static LottoTicket create() {
        return new LottoTicket();
    }

    public int matchWinningNumbers(String winningNumber) {
        int matchResult = 0;
        String[] splitNumbers = winningNumber.split(",");
        validateNumber(splitNumbers);

        for (String splitNumber : splitNumbers) {
            int number = getNumber(splitNumber);
            matchResult += isMatchNumber(number);
        }
        return matchResult;
    }

    private void validateNumber(String[] splitNumbers) {
        if (splitNumbers.length != LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException("6개의 당첨번호를 입력해야 합니다. ,(콤마) 구분");
        }
    }

    private int isMatchNumber(int number) {
        List<Integer> collect = this.lottoNumbers.stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList());
        return collect.contains(number) ? LOTTO_MATCH : LOTTO_NOT_MATCH;
    }

    private static int getNumber(String splitNumber) {
        return Integer.parseInt(splitNumber.trim());
    }

    private void shuffleLottoTicket() {
        Collections.shuffle(this.lottoNumbers);

        List<LottoNumber> newLottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_TICKET_SIZE; i++) {
               newLottoNumbers.add(this.lottoNumbers.get(i));
        }

        Collections.sort(newLottoNumbers);
        this.lottoNumbers =  newLottoNumbers;
    }

    public int size() {
        return this.lottoNumbers.size();
    }

    public void printLottoNumbers() {
        List<Integer> collect = this.lottoNumbers.stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList());

        System.out.println(collect.toString());
    }
}
