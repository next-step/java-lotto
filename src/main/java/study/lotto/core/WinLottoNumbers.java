package study.lotto.core;

import java.util.List;

/**
 * 로또 당첨 번호
 */
public class WinLottoNumbers extends Lotto {

    public WinLottoNumbers(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public void match(Lotto lotto) {

        if (lotto.lottoStatus == LottoStatus.HAS_BEEN_LOTTERY) {
            throw new IllegalArgumentException("이미 추첨한 로또입니다.");
        }
        
        // 일치하는 번호 추가
        this.lottoNumbers.stream()
                .filter(lotto::contains)
                .forEach(lotto::addMatchingNumber);

        // 로또 상태 변경
        lotto.lottery();
    }

}
