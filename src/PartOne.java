public class PartOne {

    private int fiveOfAKind;
    private int fourOfAKind;
    private int fullHouse;
    private int threeOfAKind;
    private int twoPair;
    private int onePair;
    private int highCard;

    public PartOne() {
        fiveOfAKind = 0;
        fourOfAKind = 0;
        fullHouse = 0;
        threeOfAKind = 0;
        twoPair = 0;
        onePair = 0;
        highCard = 0;
    }

    public void getPartOneAnswer(String[] inputArray) {
        PartTwo partTwo = new PartTwo();
        for (int x = 0; x < inputArray.length; x ++) {
            GroupHand hand = new GroupHand(inputArray[x]);
            String handType = hand.assignHand();
            System.out.println("hand " + x + " = " + handType);
            if (handType.equals("five")) {
                partTwo.fiveOfAKindArray.add(partTwo.in2DArray(hand.cards, partTwo.getBet(inputArray[x])));
                fiveOfAKind ++;
            }
            else if (handType.equals("four")) {
                partTwo.fourOfAKindArray.add(partTwo.in2DArray(hand.cards, partTwo.getBet(inputArray[x])));
                fourOfAKind ++;
            }
            else if (handType.equals("full")) {
                partTwo.fullHouseArray.add(partTwo.in2DArray(hand.cards, partTwo.getBet(inputArray[x])));
                fullHouse ++;
            }
            else if (handType.equals("three")) {
                partTwo.threeOfAKindArray.add(partTwo.in2DArray(hand.cards, partTwo.getBet(inputArray[x])));
                threeOfAKind ++;
            }
            else if (handType.equals("two")) {
                partTwo.twoPairArray.add(partTwo.in2DArray(hand.cards, partTwo.getBet(inputArray[x])));
                twoPair++;
            }
            else if (handType.equals("one")) {
                partTwo.onePairArray.add(partTwo.in2DArray(hand.cards, partTwo.getBet(inputArray[x])));
                onePair ++;
            }
            else if (handType.equals("high")) {
                partTwo.highCardArray.add(partTwo.in2DArray(hand.cards, partTwo.getBet(inputArray[x])));
                highCard ++;
            }
        }
    }

    public String toString() {
        String temp = "Part One Answer: ";
        temp += "\nNumber of five of a kind hands: " + fiveOfAKind;
        temp += "\nNumber of full house hands: " + fullHouse;
        temp += "\nNumber of four of a kind hands: " + fourOfAKind;
        temp += "\nNumber of three of a kind hands: " + threeOfAKind;
        temp += "\nNumber of two pair hands: " + twoPair;
        temp += "\nNumber of one pair hands: " + onePair;
        temp += "\nNumber of high card hands: " + highCard;
        return temp;
    }

}
