package lotto.domain;

import lotto.exception.LottoExceptionMessage;
import utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final String LOTTO_NUMBER_DELIMITER = ",";

    private List<LottoNumber> winningLottoNumbers;

    private WinningLotto(List<LottoNumber> winningLottoNumbers) {
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public static WinningLotto of(String lottoNumbers) {
        List<LottoNumber> winningLottoNumbers = Arrays.stream(lottoNumbers.split(LOTTO_NUMBER_DELIMITER))
                .map(String::trim)
                .map(StringUtils::toNumber)
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        validLottoNumberCount(winningLottoNumbers);

        return new WinningLotto(winningLottoNumbers);
    }

    private static void validLottoNumberCount(List<LottoNumber> winningLottoNumbers) {
        if (winningLottoNumbers.size() != LottoTicketMaker.DEFAULT_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoExceptionMessage.INVALID_LOTTO_NUMBER_COUNT);
        }
    }

    public LottoRank getWinningRank(LottoTicket lottoTicket) {
        int matchCount = lottoTicket.getMatchCountWith(winningLottoNumbers);

        return LottoRank.of(matchCount);
    }
}
