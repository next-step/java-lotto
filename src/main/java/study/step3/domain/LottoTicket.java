package study.step3.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket {
    private final static String LOTTO_DUPLICATION_EXCEPTION = "로또 번호는 중복되지 않는 6개의 번호로 입력 가능합니다.";
    private final static String LOTTO_NULL_EXCEPTION = "당첨번호는 빈 값을 입력할 수 없습니다.";
    private final static String LOTTO_BONUS_BALL_EXCEPTION = "이미 입력한 번호는 보너스로 입력 불가합니다.";
    private final static String DELIMITER = ",";
    private final static int LOTTO_NUMBERS_CONDITION = 6;

    private final Set<Integer> lottoNumbers;

    public LottoTicket(){
        this.lottoNumbers = new HashSet<>();
    }

    public LottoTicket(String inputLottoNumbers){
        this(convertToSet(splitNumbers(validateLottoNumbersString(inputLottoNumbers))));
    }

    public LottoTicket(Set<Integer> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        validateLottoNumberMinMax(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private static String validateLottoNumbersString(String inputLottoNumbers) {
        if (Objects.isNull(inputLottoNumbers) || inputLottoNumbers.trim().isEmpty()){
            throw new IllegalArgumentException(LOTTO_NULL_EXCEPTION);
        }
        return inputLottoNumbers;
    }

    private static String [] splitNumbers(String inputLottoNumbers) {
        return inputLottoNumbers.split(DELIMITER);
    }


    private static Set<Integer> convertToSet(String [] lottoNumbers) {
        return Stream.of(lottoNumbers)
                .map(Integer::new)
                .collect(Collectors.toSet());
    }

    private void validateLottoNumbers(Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_CONDITION){
            throw new IllegalArgumentException(LOTTO_DUPLICATION_EXCEPTION);
        }
    }

    private void validateLottoNumberMinMax(Set<Integer> lottoNumbers) {
        if (Collections.max(lottoNumbers) > 45 || Collections.min(lottoNumbers) < 1){
            throw new IllegalArgumentException("로또 번호는 1보다 작거나 45보다 클 수 없습니다.");
        }
    }

    public LottoTicket auto(){
        return new LottoTicket(LottoNumber.getLottoNumbers());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                           .sorted()
                           .collect(Collectors.toList());
    }

    public WinningRank checkWinningRank(LottoTicket winningLottoTicket, int bonusBall){
        Set<Integer> matchedLottos = new HashSet<>(this.lottoNumbers);
        matchedLottos.retainAll(winningLottoTicket.lottoNumbers);
        validateDuplicationBonusBall(winningLottoTicket.lottoNumbers, bonusBall);

        long matchingCount =  matchedLottos.size();
        return WinningRank.findRanking(matchingCount, isMatchBonus(bonusBall));
    }

    private void validateDuplicationBonusBall(Set<Integer> lottoNumbers, int bonusBall) {
        if(lottoNumbers.contains(bonusBall)){
            throw new IllegalArgumentException(LOTTO_BONUS_BALL_EXCEPTION);
        }
    }

    private boolean isMatchBonus(int bonusBall) {
        return this.lottoNumbers.contains(bonusBall);
    }
}
