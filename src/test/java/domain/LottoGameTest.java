package domain;

import static org.assertj.core.api.Assertions.assertThat;

import enums.Rank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.CreateAutoNumberMachine;

class LottoGameTest {


    private List<LottoNumbers> lottoNumbers = new ArrayList<>();
    private LottoNumbers winnerNumbers;
    private BonusNumber bonusNumber;

    @BeforeEach
    public void setup(){
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5,6);
        List<Integer> numbers2 = Arrays.asList(1,5,7,8,9,10);
        List<Integer> numbers3 = Arrays.asList(10,11,12,13,14,15);
        List<Integer> numbers4 = Arrays.asList(16,12,13,14,15,17);
        List<Integer> numbers5 = Arrays.asList(21,22,23,24,25,26);
        List<Integer> numbers6 = Arrays.asList(31,32,33,34,35,36);
        List<Integer> numbers7 = Arrays.asList(11,22,33,44,45,16);
        lottoNumbers.add(CreateAutoNumberMachine.createNumbers(numbers1));
        lottoNumbers.add(CreateAutoNumberMachine.createNumbers(numbers2));
        lottoNumbers.add(CreateAutoNumberMachine.createNumbers(numbers3));
        lottoNumbers.add(CreateAutoNumberMachine.createNumbers(numbers4));
        lottoNumbers.add(CreateAutoNumberMachine.createNumbers(numbers5));
        lottoNumbers.add(CreateAutoNumberMachine.createNumbers(numbers6));
        lottoNumbers.add(CreateAutoNumberMachine.createNumbers(numbers7));
        bonusNumber = new BonusNumber(22);
        winnerNumbers = CreateAutoNumberMachine.createNumbers(numbers1);
    }

    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.")
    @Test
    void countPurchaseAmountTicketTest(){
        LottoGame lottoGame = new LottoGame(10_000);
        assertThat(lottoGame.getMoney().getTicketCount()).isEqualTo(10);
    }

    @DisplayName("1등 우승자 인원 구하기")
    @Test
    void countFirstPlace(){

        List<Rank> ranks = findWinners(winnerNumbers);
        int count = (int) ranks
            .stream()
            .filter(rank ->
                rank == Rank.FIRST_PLACE)
            .count();
        assertThat(count).isEqualTo(1);
    }

    public List<Rank> findWinners(LottoNumbers winNumbers){
        return this.lottoNumbers
            .stream()
            .filter(lottoNumbers -> lottoNumbers.isRank(winNumbers.getNumbers()))
            .map(lottoNumbers -> lottoNumbers.convertRank(winNumbers.getNumbers(), bonusNumber))
            .collect(Collectors.toList());
    }
}
