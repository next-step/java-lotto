package step2.domain.checker;

import step2.domain.winning.WinningScore;
import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoList;
import step2.dto.LottoConfirmationRequestDto;

import java.util.EnumSet;
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
        EnumSet<WinningScore> enumSet = EnumSet.allOf(WinningScore.class);
        for(Lotto resultLotto : data) {
            int result = resultLotto.getCountContaining(lotto);
            WinningScore.valueOf(result);
        }
        enumSet.remove(WinningScore.MISS);
        enumSet.stream().forEach(System.out::println);
    }

}
