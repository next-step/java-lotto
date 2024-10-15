package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

public class Lotto {

    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateLottoNunbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoRankingEnum getRanking(Lotto winningLotto) {
        int matchCnt = (int) winningLotto.lottoNumbers.stream().filter(x -> lottoNumbers.contains(x)).count();
        return LottoRankingEnum.getEnumByMatchCount(matchCnt);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private static void validateLottoNunbers(List<Integer> numbers) {
        if(numbers == null || numbers.isEmpty()){
            throw new IllegalArgumentException("유효하지 않은 당첨 로또 번호 입니다");
        }
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6자리여야 합니다.");
        }
        int cnt = (int) numbers.stream().filter(x-> x > 45 || x < 1).count();

        if (cnt > 0) {
            throw new IllegalArgumentException("로또 번호는 1-45 범위내 숫자 여야 합니다.");
        }
        int distinctCnt = (int) numbers.stream().distinct().count();
        if (distinctCnt == numbers.size()) {
            return;
        }
        throw new IllegalArgumentException("로또 번호는 중복을 허용하지 않습니다.");
    }
}
