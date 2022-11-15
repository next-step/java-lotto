package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private static final int lottoPrice = 1000;
    private static final String LOTTO_NULLPOINT_EXCEPTION = "로또가 없습니다.";

    private List<LottoTicket> lottos;

    public Lottos(List<LottoTicket> lottos) {
        validationLottoNullCheck(lottos);
        this.lottos = lottos;
    }

    private void validationLottoNullCheck (List<LottoTicket> lottos){
        if(lottos.isEmpty()){
            throw new NullPointerException(LOTTO_NULLPOINT_EXCEPTION);
        }
    }

    public static Lottos lottosMake(int money){
        int lottoCount = money / lottoPrice;
        return new Lottos(IntStream.range(0, lottoCount)
                .mapToObj(i -> LottoTicket.lottoMake())
                .collect(Collectors.toList()));
    }

    public List<Reward> lottosMatch(WinningNumbers winningNumbers){
        return lottos.stream()
                .map(lottoTicket -> Reward.rewardMatchCount(lottoTicket.lottoNumberMatchCount(winningNumbers)))
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getLottos() {
        return lottos;
    }
}
