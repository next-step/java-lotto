package step4.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoFactory {

    private static final int PICK_COUNT = 6;
    private static final List<LottoNo> LOTTO_NOS = IntStream.rangeClosed(LottoConfig.FIRST_LOTTO_NUMBER, LottoConfig.LAST_LOTTO_NUMBER)
            .mapToObj(LottoNo::new)
            .collect(Collectors.toList());

    private LottoFactory() {

    }

    public static List<Lotto> createsByLottoPurchaseCount(int lottoPurchaseCount) {
        return IntStream.range(0, lottoPurchaseCount)
                .mapToObj(i -> new Lotto(pickRandomLottoBalls()))
                .collect(Collectors.toList());
    }

    public static Lotto createByLottoNos(int[] lottoNos) {
        return new Lotto(pickLottoBalls(lottoNos));
    }

    public static LottoNo pickLottoBall(int no) {
        return LOTTO_NOS.stream()
                .filter(lottoNo -> lottoNo.equalsLottoNo(no))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static List<LottoNo> pickLottoBalls(int[] lottoNos) {
        return Arrays.stream(lottoNos)
                .mapToObj(lottoNo -> pickLottoBall(lottoNo))
                .collect(Collectors.toList());
    }

    private static List<LottoNo> pickRandomLottoBalls() {
        Collections.shuffle(LOTTO_NOS);
        return LOTTO_NOS.subList(0, PICK_COUNT)
                .stream()
                .collect(Collectors.toList());
    }

}
