package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Positive;

import java.util.concurrent.atomic.AtomicReference;

public class AutoRetryInputView {

    public static Positive inputPrice() {
        AtomicReference<Positive> result = new AtomicReference<>();
        retryOnIllegalArgumentException(() -> result.set(InputView.inputPrice()));

        return result.get();
    }

    public static Positive inputSelfCount(Positive lottoCount) {
        AtomicReference<Positive> result = new AtomicReference<>();
        retryOnIllegalArgumentException(() -> result.set(InputView.inputSelfCount(lottoCount)));

        return result.get();
    }

    public static Lottos inputSelfLottos(Positive count) {
        AtomicReference<Lottos> result = new AtomicReference<>();
        retryOnIllegalArgumentException(() -> result.set(InputView.inputSelfLottos(count)));

        return result.get();
    }

    public static Lotto inputWinLotto() {
        AtomicReference<Lotto> result = new AtomicReference<>();
        retryOnIllegalArgumentException(() -> result.set(InputView.inputWinLotto()));

        return result.get();
    }

    public static LottoNumber inputBonusNumber(Lotto winNumbers) {
        AtomicReference<LottoNumber> result = new AtomicReference<>();
        retryOnIllegalArgumentException(() -> result.set(InputView.inputBonusNumber(winNumbers)));

        return result.get();
    }

    private static void retryOnIllegalArgumentException(Runnable runnable) {
        boolean end = false;
        while (!end) {
            end = run(runnable);
        }
    }

    private static boolean run(Runnable runnable) {
        try {
            runnable.run();
            return true;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
