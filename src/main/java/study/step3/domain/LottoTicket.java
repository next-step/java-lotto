package study.step3.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket {
    private static final String LOTTO_DUPLICATION_EXCEPTION = "로또 번호는 중복되지 않는 6개의 번호로 입력 가능합니다.";
    private static final String DELIMITER = ",";
    private static final int LOTTO_NUMBERS_CONDITION = 6;

    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(String inputLottoNumbers){
        this(convertToSet(parseInt(splitNumbers(inputLottoNumbers))));
    }
    private static String [] splitNumbers(String inputLottoNumbers) {
        return inputLottoNumbers.split(DELIMITER);
    }

    private static int[] parseInt(String[] splitNumbers) {
        return Arrays.stream(splitNumbers)
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }

    private static Set<LottoNumber> convertToSet(int [] lottoNumbers) {
        return Arrays.stream(lottoNumbers)
                     .mapToObj(LottoNumber::cacheNumber)
                     .collect(Collectors.toSet());
    }

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumbers(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_CONDITION){
            throw new IllegalArgumentException(LOTTO_DUPLICATION_EXCEPTION);
        }
    }

    public static LottoTicket auto(){
        return new LottoTicket(LottoNumbers.getLottoNumbers());
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers.stream()
                           .sorted()
                           .collect(Collectors.toList());
    }

    public List<Integer> getLottoNumbersForPrint() {
        return lottoNumbers.stream()
                           .sorted()
                           .map(LottoNumber::getLottoNumber)
                           .collect(Collectors.toList());
    }

    public WinningRank checkWinningRank(WinningLotto winningLottoTicket){
        return WinningRank.findRanking(getMatchingCount(winningLottoTicket),
                                        winningLottoTicket.isMatchBonus(lottoNumbers));
    }

    private long getMatchingCount(WinningLotto winningLottoTicket) {
        return winningLottoTicket.matchCount(this);
    }

    public long matchNumbers(LottoTicket matchedLottos) {
        Set<LottoNumber> intersection = new HashSet<>(matchedLottos.lottoNumbers);
        intersection.retainAll(this.lottoNumbers);
        return intersection.size();
    }
}