package lotto;

import lotto.domain.LottoNumbersPicker;
import lotto.domain.LottoTicket;

public class LottoApplication {

    public static void main(String[] args) {
        // purchaseAmount 입력 받기

        // LottoNumbers n개 생성 ... (n회 반복)
        LottoTicket lottoTicket = new LottoTicket(LottoNumbersPicker.pick());

        // 당첨 번호 & 보너스볼 입력 받기

        // n개 LottoTicket에 대해 getRankComparedWith() 호출 (당첨 통계 내기)

        // 당첨 통계 출력

    }
}
