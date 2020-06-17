package lotto;

public enum Prize {
    FIRST(2000000000, 6),
    SECOND(1500000, 5),
    THIRD(50000, 4),
    FORTH(5000, 3);

    private int money;
    private int cnt;

    Prize(int money, int cnt) {
        this.money = money;
        this.cnt = cnt;
    }

    public int getCnt() {
        return this.cnt;
    }

    static public int matchPrize(int cnt) {
        switch (cnt) {
            case 6: {
                return FIRST.money;
            }
            case 5: {
                return SECOND.money;
            }
            case 4: {
                return THIRD.money;
            }
            case 3: {
                return FORTH.money;
            }
            default:
                return 0;
        }
    }
}
