package lotto.fixture;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.ManualLottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.lotto.number.LottoNumber;
import lotto.domain.lotto.number.LottoNumbers;

import java.util.Arrays;
import java.util.List;

public class LottoFixture {

    public static List<LottoNumber> createOneToSixLottoNumberSequence() {
        return Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
    }

    public static List<LottoNumber> createOneToFiveLottoNumberSequence() {
        return Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5)
        );
    }

    public static List<LottoNumber> createOneToSevenLottoNumberSequence() {
        return Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6),
                LottoNumber.of(7)
        );
    }

    public static List<LottoNumber> createOneToThreeAndDifferentThreeNumberSequence() {
        return Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(14),
                LottoNumber.of(15),
                LottoNumber.of(16)
        );
    }

    public static Lottos getLottos() {
        List<LottoNumber> lottoNumbers = createOneToSixLottoNumberSequence();
        Lotto lottoFirst = Lotto.of(LottoNumbers.of(lottoNumbers));
        List<LottoNumber> lottoNumbersFirst = createOneToThreeAndDifferentThreeNumberSequence();
        Lotto lottoSecond = Lotto.of(LottoNumbers.of(lottoNumbersFirst));

        return Lottos.of(Arrays.asList(lottoFirst, lottoSecond));
    }

    public static WinningLotto getWinningLotto() {
        List<LottoNumber> winningLottoNumbers = createOneToSixLottoNumberSequence();
        LottoNumber bonusNumber = getWinningLottoNumber();

        return WinningLotto.of(LottoNumbers.of(winningLottoNumbers), bonusNumber);
    }

    public static LottoNumber getWinningLottoNumber() {
        return LottoNumber.of(43);
    }

    public static ManualLottos getOneManaualLottos() {
        List<LottoNumber> lottoNumberList = createOneToSixLottoNumberSequence();
        LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberList);
        Lotto lotto = Lotto.of(lottoNumbers);
        return ManualLottos.of(Arrays.asList(lotto));
    }

    public static ManualLottos getFiveManaualLottos() {
        List<LottoNumber> lottoNumberList = createOneToSixLottoNumberSequence();
        LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberList);
        Lotto lotto = Lotto.of(lottoNumbers);
        return ManualLottos.of(Arrays.asList(lotto, lotto, lotto, lotto, lotto));
    }

}
