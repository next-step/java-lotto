package step2.domain.checker;

import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoList;
import step2.domain.lotto.LottoNumber;
import step2.dto.LottoConfirmationRequestDto;

import java.util.List;

public final class LottoWinningChecker {

    private final Lotto lotto;

    private LottoWinningChecker(LottoConfirmationRequestDto confirmationRequestDto) {
        this(confirmationRequestDto.getLotto());
    }

    private LottoWinningChecker(Lotto lotto) {
        this.lotto = lotto;
    }

    public static final LottoWinningChecker newInstance(LottoConfirmationRequestDto confirmationRequestDto) {
        return new LottoWinningChecker(confirmationRequestDto);
    }

    public static final LottoWinningChecker newInstance(Lotto lotto) {
        return new LottoWinningChecker(lotto);
    }

    public void 비즈니스_로직을_검증하기위한_메서드(LottoList lottoList) {
        List<Lotto> data = lottoList.getLottoList();
        for(Lotto resultLotto : data) {
            int temp = 0;
            List<LottoNumber> data2 = resultLotto.getLottoNumbers();
            for (LottoNumber each : lotto.getLottoNumbers()){
                if(data2.contains(each)) temp++;
            }
            if(temp == 3) System.out.println("3개일치");
            if(temp == 4) System.out.println("4개일치");
            if(temp == 5) System.out.println("5개일치");
            if(temp == 6) System.out.println("6개일치");
        }

        // LottoList -> Lotto -> LottoNumber;
    }

}
