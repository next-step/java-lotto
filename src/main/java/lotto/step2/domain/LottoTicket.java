package lotto.step2.domain;

import lotto.step2.domain.factory.LottoNumbersFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final String LOTTO_NUMBERS_INPUT_FORM = "(4[0-5]|[1-3][0-9]|[1-9])(,(4[0-5]|[1-3][0-9]|[1-9])){5}";
    private static final String INPUT_FORMAT_EXCEPTION_MESSAGE = "올바른 입력 값이 아닙니다. 다시 입력해 주세요.";
    private static final int MAX_COUNT_OF_LOTTO_NUMBER = 6;
    private static final String DELIMITER = ",";
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    
    private final List<LottoNumber> lottoTicket;
    
    public LottoTicket(List<LottoNumber> lottoTicket) {
        if (lottoTicket.size() > MAX_COUNT_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
        this.lottoTicket = lottoTicket;
    }
    
    public LottoTicket(String lottoTicket) {
        this.lottoTicket = getLottoNumbers(lottoTicket);
    }
    
    private List<LottoNumber> getLottoNumbers(final String lottoTicket) {
        final List<LottoNumber> lottoNumbersInstance = LottoNumbersFactory.getInstance();
        
        return Arrays.stream(split(checkLottoTicketInputForm(removeSpace(lottoTicket))))
                .mapToInt(Integer::parseInt)
                .map(lottoNumber -> lottoNumber - 1)
                .mapToObj(lottoNumbersInstance::get)
                .collect(Collectors.toList());
    }
    
    private String checkLottoTicketInputForm(final String lottoTicket) {
        final Matcher matcher = Pattern.compile(LOTTO_NUMBERS_INPUT_FORM).matcher(lottoTicket);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
        
        return lottoTicket;
    }
    
    private String[] split(final String lottoTicket) {
        return lottoTicket.split(DELIMITER);
    }
    
    private String removeSpace(final String lottoTicket) {
        return lottoTicket.replace(SPACE, EMPTY);
    }
    
    public int countMatchingNumber(WinningLottoNumbers winningLottoNumbers) {
        return winningLottoNumbers.countMatchingNumber(lottoTicket);
    }
    
    public boolean isExistBonusLottoNumber(WinningLottoNumbers winningLottoNumbers) {
        return winningLottoNumbers.isExistBonusLottoNumber(lottoTicket);
    }
    
    public List<LottoNumber> getLottoTicket() {
        return lottoTicket;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoTicket, that.lottoTicket);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(lottoTicket);
    }
}
