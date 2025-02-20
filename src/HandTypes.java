public class HandTypes {

    private int fiveOfAKind;
    private int fourOfAKind;
    private int fullHouse;
    private int threeOfAKind;
    private int twoPair;
    private int onePair;
    private int highCard;

    public HandTypes() {
        fiveOfAKind = 0;
        fourOfAKind = 0;
        fullHouse = 0;
        threeOfAKind = 0;
        twoPair = 0;
        onePair = 0;
        highCard = 0;
    }

    public int getFiveOfAKind (){
        return fiveOfAKind;
    }
    public int getFourOfAKind (){
        return fourOfAKind;
    }
    public int getFullHouse (){
        return fullHouse;
    }
    public int getThreeOfAKind (){
        return threeOfAKind;
    }
    public int getTwoPair (){
        return twoPair;
    }
    public int getOnePair (){
        return onePair;
    }
    public int getHighCard (){
        return highCard;
    }

    public int[] countingHands(String[] inputArray) {
        int[] handTypeArray = new int[inputArray.length];
        for (int x = 0; x < inputArray.length; x ++) {
            GroupHand hand = new GroupHand(inputArray[x]);
            String handType = hand.assignHand();
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

    public int[] countingHands(String[] inputArray, boolean jack) {
        int[] handTypeArray = new int[inputArray.length];
        for (int x = 0; x < inputArray.length; x ++) {
            GroupHand hand = new GroupHand(inputArray[x], jack);
            String handType = hand.assignHand();
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
        String temp = "";
        temp += "Number of five of a kind hands: " + fiveOfAKind;
        temp += "\nNumber of full house hands: " + fullHouse;
        temp += "\nNumber of four of a kind hands: " + fourOfAKind;
        temp += "\nNumber of three of a kind hands: " + threeOfAKind;
        temp += "\nNumber of two pair hands: " + twoPair;
        temp += "\nNumber of one pair hands: " + onePair;
        temp += "\nNumber of high card hands: " + highCard;
        return temp;
    }

}