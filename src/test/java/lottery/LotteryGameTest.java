package lottery;

public class LotteryGameTest {
/*
    @DisplayName("LotteryMachine 객체 정상 생성 테스트")
    @ParameterizedTest
    @ValueSource(longs = {1300, 5000, 2300, 6000})
    public void makeLotteryMachineObject(long userInput) {
        PurchasePrice purchasePrice = new PurchasePrice(userInput);
        LotteryMachine lotteryMachine = new LotteryMachine(purchasePrice);
        int lotteryTicketPrice = 1000;

        assertThat(lotteryMachine.getLotteryTicketCounts())
                .isEqualTo(userInput / lotteryTicketPrice);
    }

    @DisplayName("LotteryMachine 객체 생성 실패 테스트 (로또 티켓 가격보다 구매 금액이 낮은 경우)")
    @ParameterizedTest
    @ValueSource(longs = {999, 980, 300, 500, 1})
    public void throwExceptionOnMakingLotteryMachineObject(long userInput) {
        PurchasePrice purchasePrice = new PurchasePrice(userInput);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LotteryMachine lotteryMachine = new LotteryMachine(purchasePrice);
                });
    }

    @DisplayName("LotteryMachine에서 주어진 금액만큼 LotteryTicket 생성해 LotteryTicketGroups를 get")
    @ParameterizedTest
    @ValueSource(longs = {1000, 2000, 3000, 4000})
    public void getLotteryTicketGroups(long userInput) {
        PurchasePrice purchasePrice = new PurchasePrice(userInput);
        LotteryMachine lotteryMachine = new LotteryMachine(purchasePrice);

        assertThatCode(() -> {
            lotteryMachine.makeLotteryTicketsGroup();
        }).doesNotThrowAnyException();

        LotteryTicketsGroup lotteryTicketsGroup = lotteryMachine.makeLotteryTicketsGroup();

        assertThat(lotteryTicketsGroup.getLotteryTicketsNumbers().size())
                .isEqualTo(userInput / 1000);
    }

    @DisplayName("LotteryMachine에서 당첨 번호를 비교해 당첨된 로또 티켓들의 개수를 저장한 Map 반환")
    @ParameterizedTest
    @MethodSource("mockLotteryTicketBuilder")
    public void findLotteryWinnerTicketsGroup(LotteryTicket winnerTicket, LotteryRank lotteryRank,
                                              int winnerCounts) {
        LotteryMachine lotteryMachine = new LotteryMachine(new PurchasePrice(1000));
        LotteryTicket loser = new LotteryTicket(Arrays.stream("1,2,3,4,5,6".split(","))
                .map(number -> new LotteryNumber(Integer.parseInt(number)))
                .collect(Collectors.toList()));
        LotteryTicket winner = new LotteryTicket(Arrays.stream("11,22,33,44,1,2".split(","))
                .map(number -> new LotteryNumber(Integer.parseInt(number)))
                .collect(Collectors.toList()));

        LotteryTicketsGroup lotteryTicketsGroup = new LotteryTicketsGroup(Arrays.asList(winner, loser));
        Map<LotteryRank, Integer> winnerTicketsGroup = lotteryMachine
                .findWinnerTicketCountsByRankMap(lotteryTicketsGroup, winnerTicket);

        assertThat(winnerTicketsGroup.get(lotteryRank)).isEqualTo(winnerCounts);
    }

    private static Stream<Arguments> mockLotteryTicketBuilder() {
        return Stream.of(
                Arguments.of(new LotteryTicket(StringParser.parseString("11, 22, 33, 44, 1, 2")),
                        LotteryRank.FIRST_PRIZE, 1),
                Arguments.of(new LotteryTicket(StringParser.parseString("1, 2, 3, 44, 9, 8")),
                        LotteryRank.FOURTH_PRIZE, 2)
        );
    }*/
}
