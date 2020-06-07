package study.step3.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket {
    private final static String LOTTO_DUPLICATION_EXCEPTION = "로또 번호는 중복되지 않는 6개의 번호로 입력 가능합니다.";
    private final static String DELIMITER = ",";
    private final static int LOTTO_NUMBERS_CONDITION = 6;

    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(String inputLottoNumbers){
        this(convertToSet(splitNumbers(inputLottoNumbers)));
    }

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private static String [] splitNumbers(String inputLottoNumbers) {
        return inputLottoNumbers.split(DELIMITER);
    }

    private static Set<LottoNumber> convertToSet(String [] lottoNumbers) {
        return Stream.of(lottoNumbers)
                     .map(LottoNumber::new)
                     .collect(Collectors.toSet());
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
        return WinningRank.findRanking(getMatchingCount(winningLottoTicket), winningLottoTicket.isMatchBonus(lottoNumbers));
    }

    private long getMatchingCount(WinningLotto winningLottoTicket) {
        Set<LottoNumber> matchedLottos = new HashSet<>(this.lottoNumbers);
        matchedLottos.retainAll(winningLottoTicket.getLottoNumbers());
        return matchedLottos.size();
    }
}