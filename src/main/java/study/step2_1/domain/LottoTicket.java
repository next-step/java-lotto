package study.step2_1.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket {
    private final static String LOTTO_DUPLICATION_EXCEPTION = "로또 번호는 중복되지 않는 6개의 번호로 입력 가능합니다.";
    private final static String LOTTO_NULL_EXCEPTION = "당첨번호는 빈 값을 입력할 수 없습니다.";
    private final static String DELIMITER = ",";
    private final static int LOTTO_NUMBERS_CONDITION = 6;

    private final Set<Integer> lottoNumbers;

    public LottoTicket(){
        this.lottoNumbers = new HashSet<>();
    }

    public LottoTicket(String inputLottoNumbers){
        this(convertToSet(validateLottoNumbersString(inputLottoNumbers)));
    }

    private LottoTicket(Set<Integer> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private static String validateLottoNumbersString(String inputLottoNumbers) {
        if (Objects.isNull(inputLottoNumbers) || inputLottoNumbers.trim().isEmpty()){
            throw new IllegalArgumentException(LOTTO_NULL_EXCEPTION);
        }
        return inputLottoNumbers;
    }

    private static Set<Integer> convertToSet(String inputLottoNumbers) {
        String [] splitLottoNumbers = inputLottoNumbers.split(DELIMITER);
        return Stream.of(splitLottoNumbers)
                .map(Integer::new)
                .collect(Collectors.toSet());
    }

    private void validateLottoNumbers(Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() < LOTTO_NUMBERS_CONDITION){
            throw new IllegalArgumentException(LOTTO_DUPLICATION_EXCEPTION);
        }
    }

    public LottoTicket buyAuto(){
        return new LottoTicket(new RandomLottoNumber().getLottoNumbers());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                           .sorted()
                           .collect(Collectors.toList());
    }

    public WinningRank checkWinningRank(LottoTicket winningLottoTicket){
        long matchingCount =  winningLottoTicket.getLottoNumbers()
                                                .stream()
                                                .filter(winningNumber -> this.lottoNumbers.contains(winningNumber))
                                                .count();
        return WinningRank.findRanking(matchingCount);
    }
}
