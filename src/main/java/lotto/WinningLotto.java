package lotto;

import java.util.List;

public class WinningLotto {
    private Lotto lotto;
    private LottoNumber bonusBall;

    private WinningLotto() {
    }

    public static WinningLottoBuilder builder() {
        return new WinningLottoBuilder();
    }

    static class WinningLottoBuilder {
        private final WinningLotto winningLotto;

        private WinningLottoBuilder() {
            this.winningLotto = new WinningLotto();
        }

        public WinningLottoBuilder winningNumbers(int n1, int n2, int n3, int n4, int n5, int n6) {
            winningLotto.lotto = Lotto.manual(n1, n2, n3, n4, n5, n6);
            return this;
        }

        public WinningLottoBuilder winningNumbers(List<Integer> numbers) {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException("당첨 로또 숫자는 총 6개이어야 합니다.");
            }
            winningLotto.lotto = Lotto.manual(numbers);
            return this;
        }

        public WinningLottoBuilder bonusBall(int bonusBall) {
            winningLotto.bonusBall = LottoNumber.of(bonusBall);
            return this;
        }

        public WinningLotto build() {
            return winningLotto;
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}
