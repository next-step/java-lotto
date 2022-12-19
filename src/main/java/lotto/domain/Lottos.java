package lotto.domain;

import lotto.strategy.LottoAutoStrategy;
import lotto.strategy.LottoMakeStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private static final String LOTTO_NULLPOINT_EXCEPTION = "로또가 없습니다.";

    private final List<LottoTicket> lottos;

    public Lottos(List<LottoTicket>lottos) {
        validationLottoNullCheck(lottos);
        this.lottos = lottos;
    }

    public Lottos(Money money, List<String> manualLottoCount, LottoMakeStrategy lottoMakeStrategy){
        this.lottos = lottosMake(money, manualLottoCount, lottoMakeStrategy);
    }

    private void validationLottoNullCheck (List<LottoTicket> lottos){
        if(lottos.isEmpty()){
            throw new NullPointerException(LOTTO_NULLPOINT_EXCEPTION);
        }
    }

    private List<LottoTicket> lottosMake(Money money, List<String> manualLottoCount, LottoMakeStrategy lottoMakeStrategy){
        List<LottoTicket> lottos = autoLottos(money, manualLottoCount.size(), lottoMakeStrategy);
        lottos.addAll(manualLottos(manualLottoCount));
        return lottos;
    }

    private List<LottoTicket> autoLottos(Money money, int manualLottoCount, LottoMakeStrategy lottoMakeStrategy){
        return IntStream.range(0, money.lottoCount() - manualLottoCount)
                .mapToObj(i -> new LottoTicket(lottoMakeStrategy))
                .collect(Collectors.toList());
    }
    private List<LottoTicket> manualLottos(final List<String> manualLottos){
        return manualLottos.stream()
                .map(i -> Arrays.stream(i.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
                )
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }

    public List<Reward> lottosMatch(WinningNumbers winningNumbers){
        return lottos.stream()
                .map(lottoTicket -> lottoTicket.lottoNumberMatch(winningNumbers))
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getLottos() {
        return lottos;
    }
}
