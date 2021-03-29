package step2.Domain;

import java.util.List;
import java.util.Map;

public class Rank {

    private Map<HitCount, List<Lotto>> rank;

    public Rank(Map<HitCount, List<Lotto>> rank){
        this.rank = rank;
    }

    public int size(HitCount hitCount){
        if(rank.get(hitCount) == null){
            return 0;
        }
        return rank.get(hitCount).size();
    }

    public Map<HitCount, List<Lotto>> getRank(){
        return rank;
    }
}
