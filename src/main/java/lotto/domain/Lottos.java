package lotto.domain;

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

    public Lottos(){
        this.lottos = new ArrayList<>();
    }

    private void validationLottoNullCheck (List<LottoTicket> lottos){
        if(lottos.isEmpty()){
            throw new NullPointerException(LOTTO_NULLPOINT_EXCEPTION);
        }
    }

    public void autoLottos(Money money, int manualLottoCount, LottoMakeStrategy lottoMakeStrategy){
        IntStream.range(0, money.lottoCount() - manualLottoCount)
                .mapToObj(i -> new LottoTicket(lottoMakeStrategy))
                .forEach(lottos::add);
    }

    public void manualLottos(List<String> manualLotto){
        manualLotto.stream()
                .map(i -> Arrays.stream(i.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
                )
                .map(LottoTicket::new)
                .forEach(lottos::add);
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
