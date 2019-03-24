package lotto.domain;

public interface Profitable {
    Profitable NONE = new Profitable() {
        @Override
        public int profit(int rank) {
            return 0;
        }
    };

    int profit(int rank);
}

class FirstRank implements Profitable {
    @Override
    public int profit(int rank) {
        return 2000000000;
    }
}

class SecondRank implements Profitable {
    @Override
    public int profit(int rank) {
        return 150000;
    }
}

class ThirdRank implements Profitable {
    @Override
    public int profit(int rank) {
        return 50000;
    }
}

class FourthRank implements Profitable{
    @Override
    public int profit(int rank) {
        return 5000;
    }
}


