package lotto.domain;

import lotto.service.util.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final String STRING_NUMBERS_DELIMITER = ",";

    private List<Lotto> allLottoNumbers = new ArrayList<>();

    public LottoTicket(int autoTicketCount, List<String> manualNumbers) {

        createManualTicket(manualNumbers);
        createAutoTicket(autoTicketCount);

    }

    private LottoTicket(List<Lotto> lottoNumbers) {

        this.allLottoNumbers = lottoNumbers;
    }

    public static LottoTicket from(List<Lotto> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    private void createManualTicket(List<String> lottoNumbers) {

        if (lottoNumbers == null) {
            throw new IllegalArgumentException("수동 구매 넘버는 null일 수 없습니다.");
        }

        for (String lottoNumber : lottoNumbers) {

            String[] input = lottoNumber.split(STRING_NUMBERS_DELIMITER);
            Arrays.stream(input)
                    .forEach(Validation::constantCheck);

            List<Integer> manualNumbers = Arrays.stream(input)
                    .map(s -> Integer.valueOf(s.trim()))
                    .collect(Collectors.toList());

            allLottoNumbers.add(Lotto.manualFrom(manualNumbers));
        }
    }

    private void createAutoTicket(int orderCount) {
        for(int i = 0; i < orderCount; i ++) {
            allLottoNumbers.add(new Lotto());
        }
    }

    public List<Lotto> getLotto() {
        return Collections.unmodifiableList(allLottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(allLottoNumbers, that.allLottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allLottoNumbers);
    }

}
