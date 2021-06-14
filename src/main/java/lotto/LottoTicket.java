package lotto;

import java.util.*;

import static lotto.LottoConstant.*;

public class LottoTicket {
    private List<Integer> numbers;

    public LottoTicket(){
        numbers = new ArrayList<>();
        createRandomNumber();
        validateNumbers();
    }

    private void validateNumbers() {
        for(int number : numbers) {
            if(number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException("1부터 45사이의 숫자가 아닙니다.");
            }
        }
        if(numbers.size() != LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException("6개의 숫자로 이루어져 있지 않습니다.");
        }
    }

    private void createRandomNumber() {
        List<Integer> lottoBalls = new ArrayList<>();
        for(int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            lottoBalls.add(i);
        }

        Collections.shuffle(lottoBalls);
        for(int i = 0; i < LOTTO_TICKET_SIZE; i++) {
            numbers.add(lottoBalls.get(i));
        }
        Collections.sort(numbers);
    }

    public List<Integer> getLottoTicket() {
        return numbers;
    }

}
