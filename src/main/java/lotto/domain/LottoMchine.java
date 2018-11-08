package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.utils.RandomNumberGenerator;

public class LottoMchine {
    private final int LOTTO_NUMERS = 6;
    private final int LOTTO_MAX_RANGE = 45;

    private List<LottoTicket> lssuedTickets;
    
    public LottoMchine() {
        this.lssuedTickets = new ArrayList<>();
    }

    public LottoTicket generate() {
        
        LottoTicket tiket = createTiket();
        lssuedTickets.add(tiket);
        return tiket;
    }

    private LottoTicket createTiket() {
        List<Integer> numbers = new ArrayList<>();
        int i = 0;
        while (i < LOTTO_NUMERS) {
            int number = nextNumber();
            if (isDuplicate(numbers, number)) {
                continue;
            }
            numbers.add(number);
            i++;
        }
        
        return  new LottoTicket(numbers);
    }

    private int nextNumber() {
        // 랜덤 번호는 0-45를 만들지만 로또 번호는 1에서 시작이므로 최대 범위를 줄이고 1을 더함.
        return RandomNumberGenerator.nextInt(LOTTO_MAX_RANGE - 1) + 1;
    }

    private boolean isDuplicate(List<Integer> numbers, int number) {
        return numbers.contains(number);
    }

    public Map<Integer, Integer> check(String winningNumber, List<LottoTicket> tikets) {
        List<Integer> numbers = convertToInts(winningNumber);
       
        Map<Integer, Integer> stats = new HashMap<>();
        for (LottoTicket ticket : tikets) {
            int howMany = ticket.howManyNumber(numbers);
            if (howMany > 0) {
                stats.merge(howMany, 1, (a, b) -> a + 1);
            }
        }
        
        return stats;
    }

    private List<Integer> convertToInts(String winningNumber) {
        return Arrays.stream(winningNumber.split(","))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
    }
}
