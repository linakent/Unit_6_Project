import java.util.Arrays;
public class PartTwo {

    //array of all bet amounts
    private int[] bidArray;
    private int[] orderedBidArray;
    //array of all hand types
    private int[] handType;
    private int[] orderedHandTypes;
    //array of all hands with their cards
    private int[][] hands;
    private int[][] orderedHandsA;
    private PartOne partOne;


    public static boolean jackIsWild;

    public PartTwo(String[] inputArray, int[] handType) {
        bidArray = new int[inputArray.length];
        orderedBidArray = new int[bidArray.length];
        this.handType = new int[inputArray.length];
        orderedHandTypes = new int[handType.length];
        for (int x = 0; x < handType.length; x ++) {
            this.handType[x] = handType[x];
            orderedHandTypes[x] = handType[x];
        }
        Arrays.sort(orderedHandTypes);

        hands = new int[inputArray.length][5];
        orderedHandsA = new int[hands.length][5];
        for (int x = 0; x < inputArray.length; x ++) {
            GroupHand hand = new GroupHand(inputArray[x]);
            hands[x] = translateCardArray(hand.cards);
            //System.out.println("Hand #" + x + " = " + Arrays.toString(hands[x]));
            bidArray[x] = hand.bidValue;
        }
        //System.out.println("bidArray = " + Arrays.toString(bidArray));
        jackIsWild = false;
        partOne = new PartOne();
        partOne.countingHands(inputArray);
    }

    public int[] translateCardArray(String[] cardsArray) {
        int[] temp = new int[cardsArray.length];
        for (int x = 0; x < temp.length; x ++) {

            if (jackIsWild == true) {

                if (cardsArray[x].equals("Ace")) {
                    temp[x] = 13;
                }
                if (cardsArray[x].equals("King")) {
                    temp[x] = 12;
                }
                if (cardsArray[x].equals("Queen")) {
                    temp[x] = 11;
                }
                if (cardsArray[x].equals("10")) {
                    temp[x] = 10;
                }
                if (cardsArray[x].equals("9")) {
                    temp[x] = 9;
                }
                if (cardsArray[x].equals("8")) {
                    temp[x] = 8;
                }
                if (cardsArray[x].equals("7")) {
                    temp[x] = 7;
                }
                if (cardsArray[x].equals("6")) {
                    temp[x] = 6;
                }
                if (cardsArray[x].equals(("5"))) {
                    temp[x] = 5;
                }
                if (cardsArray[x].equals("4")) {
                    temp[x] = 4;
                }
                if (cardsArray[x].equals("3")) {
                    temp[x] = 3;
                }
                if (cardsArray[x].equals("2")) {
                    temp[x] = 2;
                }
                if (cardsArray[x].equals("Jack")) {
                    temp[x] = 1;
                }

            }

            else {
                if (cardsArray[x].equals("Ace")) {
                    temp[x] = 13;
                }
                if (cardsArray[x].equals("King")) {
                    temp[x] = 12;
                }
                if (cardsArray[x].equals("Queen")) {
                    temp[x] = 11;
                }
                if (cardsArray[x].equals("Jack")) {
                    temp[x] = 10;
                }
                if (cardsArray[x].equals("10")) {
                    temp[x] = 9;
                }
                if (cardsArray[x].equals("9")) {
                    temp[x] = 8;
                }
                if (cardsArray[x].equals("8")) {
                    temp[x] = 7;
                }
                if (cardsArray[x].equals("7")) {
                    temp[x] = 6;
                }
                if (cardsArray[x].equals("6")) {
                    temp[x] = 5;
                }
                if (cardsArray[x].equals(("5"))) {
                    temp[x] = 4;
                }
                if (cardsArray[x].equals("4")) {
                    temp[x] = 3;
                }
                if (cardsArray[x].equals("3")) {
                    temp[x] = 2;
                }
                if (cardsArray[x].equals("2")) {
                    temp[x] = 1;
                }
            }
        }
        return temp;
    }

    public int findIndexOf(int target, int[] array) {
        for (int x = 0; x < array.length; x ++) {
            if (array[x] == target) {
                return x;
            }
        }
        return -1;
    }

    public void orderByHandType() {
        int[] handTypeCopy = new int[handType.length];
        for (int x = 0; x < handType.length; x ++) {
            handTypeCopy[x] = handType[x];
        }
        int index;
        for (int x = 0; x < handType.length; x ++) {
            index = findIndexOf(orderedHandTypes[x], handTypeCopy);
            orderedHandsA[x] = hands[index];
            orderedBidArray[x] = bidArray[index];
            handTypeCopy[index] = 100;
        }
        System.out.println("orderedBidArray1 = " + Arrays.toString(orderedBidArray));
    }

    public boolean ifHaveRepeatedElement(int[] array) {
        for (int x = 0; x < array.length; x ++) {
            for (int y = 0; y < array.length; y ++) {
                if (array[x] == array[y]) {
                    if (x != y) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void swap(int[][] hand, int hand1, int hand2) {
        int[] tempHand = hands[hand1];
        hands[hand1] = hands[hand2];
        hands[hand2] = tempHand;

        int tempBid = orderedBidArray[hand1];
        orderedBidArray[hand1] = orderedBidArray[hand2];
        orderedBidArray[hand2] = tempBid;

        int tempType = handType[hand1];
        handType[hand1] = handType[hand2];
        handType[hand2] = tempType;
    }

    public int getNumOfHands(int handType) {
        if (handType == 7) {
            return partOne.getFiveOfAKind();
        }
        if (handType == 6) {
            return partOne.getFourOfAKind();
        }
        if (handType == 5) {
            return partOne.getFullHouse();
        }
        if (handType == 4) {
            return partOne.getThreeOfAKind();
        }
        if (handType == 3) {
            return partOne.getTwoPair();
        }
        if (handType == 2) {
            return partOne.getOnePair();
        }
        if (handType == 1) {
            return partOne.getHighCard();
        }
        return -1;
    }

    public int[][] appendArrays(int[][] array, int handType) {

        int numOfHands = getNumOfHands(handType);
        int[][] appendedArrays = new int[numOfHands][5];
        int indexCount = 0;

        for (int x = 0; x < orderedHandTypes.length; x ++) {
            if (orderedHandTypes[x] == handType) {
                appendedArrays[indexCount] = orderedHandsA[x];
                indexCount ++;
            }
        }

        return appendedArrays;
    }

    public int[][] orderedArray(int[][] array) {

        int[][] orderedArray = new int[array.length][5];

        for (int x = 0; x < orderedArray.length; x ++) {

        }

        return orderedArray;
    }

    public void orderBidArrayByCards() {
        int[][] five = new int[partOne.getFiveOfAKind()][5];
        int[][] four = new int[partOne.getFourOfAKind()][5];
        int[][] full = new int[partOne.getFullHouse()][5];
        int[][] three = new int[partOne.getThreeOfAKind()][5];
        int[][] two = new int[partOne.getTwoPair()][5];
        int[][] one = new int[partOne.getOnePair()][5];
        int[][] high = new int[partOne.getHighCard()][5];

        five = appendArrays(five, 7);
        four = appendArrays(four, 6);
        full = appendArrays(full, 5);
        three = appendArrays(three, 4);
        two = appendArrays(two, 3);
        one = appendArrays(one, 2);
        high = appendArrays(high, 1);






    }

    public int findBidVal() {
        orderByHandType();
        if (ifHaveRepeatedElement(orderedHandTypes)) {
            orderByCard();
        }

        int total = 0;
        System.out.print("(");
        for (int x = 1; x <= orderedBidArray.length; x ++) {
            System.out.println("Bid Value: " + orderedBidArray[x - 1] + " at position " + x);
            System.out.print(orderedBidArray[x - 1] + " * " + x + " + ");
            total += orderedBidArray[x - 1] * x;
        }
        System.out.println("Total bid value calculated: " + total);
        System.out.println(")");
        return total;
    }

    public String toString() {
        return "Total Bid Value: " + findBidVal();
    }


}
