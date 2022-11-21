package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private static final String LOTTO_NULLPOINT_EXCEPTION = "로또가 없습니다.";

    private List<LottoTicket> lottos;

    public Lottos(List<LottoTicket>lottos) {
        validationLottoNullCheck(lottos);
        this.lottos = lottos;
    }

    private void validationLottoNullCheck (List<LottoTicket> lottos){
        if(lottos.isEmpty()){
            throw new NullPointerException(LOTTO_NULLPOINT_EXCEPTION);
        }
    }

    public static Lottos lottosMake(Money money){
        return new Lottos(IntStream.range(0, money.lottoCount())
                .mapToObj(i -> LottoTicket.valueOf())
                .collect(Collectors.toList()));
    }


    public List<Reward> lottosMatch(WinningNumbers winningNumbers){
        return lottos.stream()
                .map(lottoTicket -> Reward.rewardMatchCount(lottoTicket.lottoNumberMatchCount(winningNumbers)
                        , lottoTicket.bonusNumberMatch(winningNumbers)))
                .collect(Collectors.toList());
    }


    public List<LottoTicket> getLottos() {
        return lottos;
    }
}
