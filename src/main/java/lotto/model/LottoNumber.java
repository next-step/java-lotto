package lotto.model;

import lotto.exception.InvalidLottoNumberException;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_TICKET_SIZE = 6;
    private final int number;

    private static final Map<Integer, LottoNumber> lottoNumberMap =
            IntStream.range(MIN_NUMBER, MAX_NUMBER+1)
            .boxed()
            .collect(Collectors.toMap(Function.identity(), LottoNumber::new));

    public LottoNumber(String strNumber) {
        this(Integer.parseInt(strNumber));
    }

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber getLottoNumber(Integer number){
        if(lottoNumberMap.containsKey(number)){
            throw new InvalidLottoNumberException();
        }
        return lottoNumberMap.get(number);
    }

    private void validate(int number) {
        if(number < MIN_NUMBER || number > MAX_NUMBER){
            throw new InvalidLottoNumberException();
        }
    }

    public static LottoTicket generateLottoTicket() {
        List<LottoNumber> numberList = new ArrayList<>(lottoNumberMap.values());
        Collections.shuffle(numberList);
        return new LottoTicket(new ArrayList<>(numberList.subList(0, LOTTO_TICKET_SIZE)));
    }

    private int getNumber(){
        return this.number;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        return ((LottoNumber) o).getNumber() == getNumber();
    }

    @Override
    public int hashCode(){
        return Objects.hash(number);
    }

    @Override
    public String toString(){
        return String.valueOf(number);
    }
}
