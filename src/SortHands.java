import java.util.ArrayList;
import java.util.Arrays;
public class SortHands {
    private int[] bidArray;
    private int[] orderedBidArray;
    private int[] handType;
    private int[] orderedHandTypes;
    private int[][] hands;
    private int[][] orderedHandsA;
    private HandTypes partOne;
    private boolean jackIsWild;

    public SortHands(String[] inputArray, int[] handType) {
        jackIsWild = false;
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
            bidArray[x] = hand.bidValue;
        }
        partOne = new HandTypes();
        partOne.countingHands(inputArray);
    }

    public SortHands(String[] inputArray, int[] handType, boolean jack) {
        jackIsWild = jack;
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
            bidArray[x] = hand.bidValue;
        }
        partOne = new HandTypes();
        partOne.countingHands(inputArray);
    }

    public boolean isJackIsWild() {
        return jackIsWild;
    }

    public int[] translateCardArray(String[] cardsArray) {
        int[] temp = new int[cardsArray.length];
        for (int x = 0; x < temp.length; x ++) {

            if (jackIsWild) {
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
    }

    public int[][] appendArrays(int handType) {
        int numOfHands = getNumOfHands(handType);
        int[][] appendedArrays = new int[numOfHands][6];
        int numOfHandsCount = 0;
        int x = 0;
        while (numOfHandsCount != numOfHands) {
            if (orderedHandTypes[x] == handType) {
                for (int y = 0; y < 5; y ++) {
                    appendedArrays[numOfHandsCount][y] = orderedHandsA[x][y];
                }
                appendedArrays[numOfHandsCount][5] = orderedBidArray[x];
                numOfHandsCount++;
            }
            x ++;
        }
        return appendedArrays;
    }

    public int findIndexOf(int target, int[] array) {
        for (int x = 0; x < array.length; x ++) {
            if (array[x] == target) {
                return x;
            }
        }
        return -1;
    }

    public int[][] orderedArray(int[][] array) {
        ArrayList<int[]> unsorted = new ArrayList<>();
        ArrayList<int[]> sorted = new ArrayList<>();

        for (int x = 0; x < array.length; x ++) {
            unsorted.add(array[x]);
        }

        while (!unsorted.isEmpty()) {
            int[] item = unsorted.remove(0);
            if (sorted.isEmpty()) {
                sorted.add(item);
            } else {
                boolean inserted = false;
                for (int i = 0; i < sorted.size(); i++) {
                    if (compareHands(item, sorted.get(i)) < 0) {
                        sorted.add(i, item);
                        inserted = true;
                        break;
                    }
                }
                if (!inserted) {
                    sorted.add(item);
                }
            }
        }
        return sorted.toArray(new int[sorted.size()][]);
    }

    private int compareHands(int[] hand1, int[] hand2) {
        for (int x = 0; x < 6; x ++) {
            if (hand1[x] < hand2[x]) {
                return -1;
            } else if (hand1[x] > hand2[x]) {
                return 1;
            }
        }
        return 0;
    }

    public boolean isArrayEmpty(int[][] array) {
        int count = 0;
        for (int x = 0; x < array.length; x ++) {
            if (array[x][0] == 0) {
               count ++;
            }
        }
        return count == array.length;
    }

    public int[][] orderBidArrayByCards() {
        int[][] five;
        int[][] four;
        int[][] full;
        int[][] three;
        int[][] two;
        int[][] one;
        int[][] high;

        five = appendArrays(7);
        four = appendArrays(6);
        full = appendArrays(5);
        three = appendArrays(4);
        two = appendArrays(3);
        one = appendArrays(2);
        high = appendArrays(1);

        five = orderedArray(five);
        four = orderedArray(four);
        full = orderedArray(full);
        three = orderedArray(three);
        two = orderedArray(two);
        one = orderedArray(one);
        high = orderedArray(high);

        int totalBidNum = partOne.getFiveOfAKind() + partOne.getFullHouse() + partOne.getFourOfAKind() + partOne.getThreeOfAKind() + partOne.getTwoPair() + partOne.getOnePair() + partOne.getHighCard();
        int[][] finalArray = new int[totalBidNum][6];
        int finalArrayIndex = 0;

        if (!isArrayEmpty(high)) {
            for (int a = 0; a < high.length; a ++) {
                finalArray[finalArrayIndex] = high[a];
                finalArrayIndex ++;
            }
        }

        if (!isArrayEmpty(one)) {
            for (int b = 0; b < one.length; b ++) {
                finalArray[finalArrayIndex] = one[b];
                finalArrayIndex ++;
            }
        }

        if (!isArrayEmpty(two)) {
            for (int c = 0; c < two.length; c ++) {
                finalArray[finalArrayIndex] = two[c];
                finalArrayIndex ++;
            }
        }

        if (!isArrayEmpty(three)) {
            for (int d = 0; d < three.length; d ++) {
                finalArray[finalArrayIndex] = three[d];
                finalArrayIndex ++;
            }
        }

        if (!isArrayEmpty(full)) {
            for (int e = 0; e < full.length; e ++) {
                finalArray[finalArrayIndex] = full[e];
                finalArrayIndex ++;
            }
        }

        if (!isArrayEmpty(four)) {
            for (int f = 0; f < four.length; f ++) {
                finalArray[finalArrayIndex] = four[f];
                finalArrayIndex ++;
            }
        }

        if (!isArrayEmpty(five)) {
            for (int g = 0; g < five.length; g ++) {
                finalArray[finalArrayIndex] = five[g];
                finalArrayIndex ++;
            }
        }
        return finalArray;
    }

    public int findBidVal() {
        orderByHandType();
        int[][] orderedArray = orderBidArrayByCards();
        int totalBid = 0;
        for (int x = 0; x < orderedArray.length; x ++) {
            totalBid += orderedArray[x][5] * (x + 1);
        }
        return totalBid;
    }

    public String toString() {
        String temp = "Total Bid Value: " + findBidVal();
        if (jackIsWild) {
            temp = "Total Bid Value with Jacks Wild: " + findBidVal();
        }
        return temp;
    }

}
