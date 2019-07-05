package step2.domain;

import java.util.stream.Collectors;

import step2.dto.LottosDTO;

public class UserPickLottosFactory implements LottoFactory<LottosDTO, Lottos> {
    @Override
    public Lottos apply(LottosDTO lottosDTO) {
        return new Lottos(lottosDTO.getLottos()
                                   .stream()
                                   .map(lottoDTO -> Lotto.create(lottoDTO.getLottoNumbers()))
                                   .collect(Collectors.toList()));
    }
}
