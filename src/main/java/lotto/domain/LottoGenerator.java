package lotto.domain;

import lotto.domain.game.Lotto;
import lotto.domain.game.LottoNumberSet;
import lotto.domain.game.LottoNumber;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created By mand2 on 2020-11-19.
 * 로또 번호 6개 자동 생성하는 객체
 */
public class LottoGenerator {

    private static List<Integer> lottoNumbers;
    private static final String tokenizer = ", ";

    static {
        lottoNumbers = IntStream.rangeClosed(LottoNumber.VALID_MIN_NUMBER, LottoNumber.VALID_MAX_NUMBER)
                .boxed()
                .collect(toList());
    }

    private LottoGenerator() {}

    public static Lottos generate(int totalRound) {
        return automateLotto(totalRound);
    }

    public static Lottos generate(SeedMoney seedMoney, InputManualLotto inputManualLotto) {
        int totalRounds = seedMoney.round();
        int manualRounds = inputManualLotto.getRound();

        Lottos manual = manualLotto(inputManualLotto);
        Lottos auto = automateLotto(totalRounds - manualRounds);

        return Lottos.of(manual, auto);
    }

    private static Lottos manualLotto(InputManualLotto inputManualLotto) {
        return inputManualLotto.getInputLottos().stream()
                .map(manual -> convertToLottoNumberSet(manual))
                .map(Lotto::of)
                .collect(Collectors.collectingAndThen(toList(), Lottos::of));
    }

    private static LottoNumberSet convertToLottoNumberSet(String manualLottoNumber) {
        return Arrays.stream(splitLottoNumber(manualLottoNumber))
                .map(LottoNumber::from)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoNumberSet::of));
    }

    private static String[] splitLottoNumber(String manualLottoNumber) {
        return manualLottoNumber.split(tokenizer);
    }

    private static Lottos automateLotto(int autoRound) {
        List<Lotto> lottos = Stream.generate(() -> Lotto.of(LottoNumberSet.of(convert())))
                .limit(autoRound)
                .collect(toList());
        return Lottos.of(lottos);
    }

    private static List<LottoNumber> convert() {
        shuffle();
        List<Integer> before = subList();

        return before.stream().map(LottoNumber::from).collect(toList());
    }

    private static void shuffle() {
        Collections.shuffle(lottoNumbers);
    }

    private static List<Integer> subList() {
        return lottoNumbers.subList(0, LottoNumberSet.VALID_LOTTO_SIZE);
    }

}
