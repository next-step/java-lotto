package lotto.domain;

import lotto.exception.LottoExceptionMessage;
import utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final String LOTTO_NUMBER_DELIMITER = ",";

    private List<LottoNumber> winningLottoNumbers;
    private LottoNumber bonusNumber;

    private WinningLotto(List<LottoNumber> winningLottoNumbers, LottoNumber bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(String lottoNumbers, String bonusNumberInput) {
        List<Integer> winningLottoNumbers = Arrays.stream(lottoNumbers.split(LOTTO_NUMBER_DELIMITER))
                .map(String::trim)
                .map(StringUtils::toNumber)
                .collect(Collectors.toList());
        int bonusNumber = StringUtils.toNumber(bonusNumberInput);

        validLottoNumberCount(winningLottoNumbers);
        validBonusNumber(bonusNumber, winningLottoNumbers);

        return WinningLotto.from(winningLottoNumbers, bonusNumber);
    }

    private static WinningLotto from(List<Integer> winningLottoNumbers, int bonusNumber) {
        List<LottoNumber> lottoNumbers = winningLottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        return new WinningLotto(lottoNumbers, LottoNumber.of(bonusNumber));
    }

    private static void validBonusNumber(int bonusNumber, List<Integer> winningLottoNumbers) {
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoExceptionMessage.INVALID_BONUS_NUMBER_DUPLICATION);
        }
    }

    private static void validLottoNumberCount(List<Integer> winningLottoNumbers) {
        if (winningLottoNumbers.size() != LottoTicketMaker.DEFAULT_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoExceptionMessage.INVALID_LOTTO_NUMBER_COUNT);
        }
    }

    public LottoRank getWinningRank(LottoTicket lottoTicket) {
        long matchCount = lottoTicket.getMatchCountWith(winningLottoNumbers);
        boolean matchBonus = lottoTicket.getMatchWith(bonusNumber);

        return LottoRank.of(matchCount, matchBonus);
    }
}
