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
        for (int x = 0; x < inputArray.length; x ++) {
            GroupHand hand = new GroupHand(inputArray[x]);
            String handType = hand.assignHand();
            if (handType.equals("five")) {
                fiveOfAKind ++;
            }
            else if (handType.equals("four")) {
                fourOfAKind ++;
            }
            else if (handType.equals("full")) {
                fullHouse ++;
            }
            else if (handType.equals("three")) {
                threeOfAKind ++;
            }
            else if (handType.equals("two")) {
                twoPair++;
            }
            else if (handType.equals("one")) {
                onePair ++;
            }
            else if (handType.equals("high")) {
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
