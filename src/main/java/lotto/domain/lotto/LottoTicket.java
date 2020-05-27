package lotto.domain.lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private final static int LOTTO_MAX_NUMBER = 45;
    private final static int LOTTO_MIN_NUMBER = 1;
    private final static int LOTTO_TICKET_SIZE = 6;

    private final static int LOTTO_MATCH  = 1;
    private final static int LOTTO_NOT_MATCH  = 0;

    private final static List<LottoNumber> lottoAllNumbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .mapToObj(LottoNumber::create)
            .collect(Collectors.toList());

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoTicket() {
        makeLottoTicket();
    }

    public LottoTicket(String inputValue) {
        String[] splitNumbers = inputValue.split(",");
        validateNumber(splitNumbers);
        for (String number : splitNumbers) {
            LottoNumber lottoNumber = LottoNumber.create(Integer.parseInt(number.trim()));
            lottoNumbers.add(lottoNumber);
        }
    }

    public int matchLottoTicketRank(LottoTicket lottoTicket) {
        int matchCount = 0;
        for (LottoNumber lottoNumber: lottoNumbers) {
            matchCount += lottoTicket.isMatchNumber(lottoNumber);
        }
        return matchCount;
    }

    public int size() {
        return this.lottoNumbers.size();
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private int isMatchNumber(LottoNumber number) {
        boolean isMatch = lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.isMatch(number));

        if (isMatch) {
            return LOTTO_MATCH;
        }

        return LOTTO_NOT_MATCH;
    }

    private void makeLottoTicket() {
        Collections.shuffle(lottoAllNumbers);

        List<LottoNumber> newLottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_TICKET_SIZE; i++) {
            newLottoNumbers.add(lottoAllNumbers.get(i));
        }

        Collections.sort(newLottoNumbers);
        this.lottoNumbers =  newLottoNumbers;
    }

    private void validateNumber(String[] splitNumbers) {
        if (splitNumbers.length != LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException("6개의 당첨번호를 입력해야 합니다. ,(콤마) 구분");
        }
    }
}
