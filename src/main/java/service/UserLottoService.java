package service;

import domain.Lotto;
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
        int ticketCount = LottoSalesService.validateMoneyAndReturnTicketCount(money);

        for (int i = 0; i < ticketCount; i++) {
            List<Integer> lottoNumbers = LottoRandomNumberGenerator.generateLottoNumber();

            Lotto lotto = new Lotto(lottoNumbers);
            userLottoRepository.saveUserLottoTickets(lotto);
        }
    }
}
