package service;

import domain.*;
import policy.LottoPrice;
import repository.UserLottoRepository;
import util.LottoRandomNumberGenerator;

import java.util.List;

public class UserLottoService {

    private final UserLottoRepository userLottoRepository;

    public UserLottoService(UserLottoRepository userLottoRepository) {
        this.userLottoRepository = userLottoRepository;
    }

    public List<Lotto> getAllLottoTickets() {
        return userLottoRepository.getUserLottoTickets();
    }
    public void buyRandomLottoTickets(final long money) {
        checkUnderZero(money);
        long lottoTicketCount = money / LottoPrice.LOTTO_PRICE;

        for (int i = 0; i < lottoTicketCount; i++) {
            List<Integer> lottoNumbers = LottoRandomNumberGenerator.generateLottoNumber();

            Lotto lotto = new Lotto(lottoNumbers);
            userLottoRepository.saveUserLottoTickets(lotto);
        }
    }

    private static void checkUnderZero(long money) {
        if (money < LottoPrice.LOTTO_PRICE) {
            throw new IllegalArgumentException(LottoPrice.LOTTO_PRICE + "원 이상부터 로또 구매가 가능합니다.");
        }
    }


}
