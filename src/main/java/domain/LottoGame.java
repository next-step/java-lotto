package domain;

public class LottoGame {
    // - [x] 로또 번호는 1부터 45
    // - [x] 로또는 6개의 중복되지 않는 번호
    // - [x] 당첨번호는 6개의 중복되지 않는 번호
    // - [x] 보너스 번호는 당첨 번호와 동일해서는 안된다.
    
    public  int match(
            final Lotto userLotto,
            final WinningLotto winningLotto
    ) {
        return winningLotto.match(userLotto);
    }
}
