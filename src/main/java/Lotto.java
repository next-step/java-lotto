import java.util.List;

public class Lotto {

    private List<Integer> numbers;
    private String name;


    public Lotto(LottoGenerator lottoGenerator){
        this.numbers = lottoGenerator.generate();
        this.name = lottoGenerator.getName();
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    public String getName(){
        return this.name;
    }


}
