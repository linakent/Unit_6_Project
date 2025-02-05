public class PartOne {

    public int fiveOfAKind;
    public int fourOfAKind;
    public int fullHouse;
    public int threeOfAKind;
    public int twoPair;
    public int onePair;
    public int highCard;

    public PartOne() {
        fiveOfAKind = 0;
        fourOfAKind = 0;
        fullHouse = 0;
        threeOfAKind = 0;
        twoPair = 0;
        onePair = 0;
        highCard = 0;
    }

    public int[] countingHands(String[] inputArray) {
        int[] handTypeArray = new int[inputArray.length];
        for (int x = 0; x < inputArray.length; x ++) {
            GroupHand hand = new GroupHand(inputArray[x]);
            String handType = hand.assignHand();
            //System.out.println("Hand #" + x + " = " + handType);
            if (handType.equals("five")) {
                fiveOfAKind ++;
                handTypeArray[x] = 7;
            }
            else if (handType.equals("four")) {
                fourOfAKind ++;
                handTypeArray[x] = 6;
            }
            else if (handType.equals("full")) {
                fullHouse ++;
                handTypeArray[x] = 5;
            }
            else if (handType.equals("three")) {
                threeOfAKind ++;
                handTypeArray[x] = 4;
            }
            else if (handType.equals("two")) {
                twoPair++;
                handTypeArray[x] = 3;
            }
            else if (handType.equals("one")) {
                onePair ++;
                handTypeArray[x] = 2;
            }
            else if (handType.equals("high")) {
                highCard ++;
                handTypeArray[x] = 1;
            }
        }
        return handTypeArray;
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
