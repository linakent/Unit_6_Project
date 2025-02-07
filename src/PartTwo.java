import java.util.ArrayList;
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
        //System.out.println("orderedBidArray1 = " + Arrays.toString(orderedBidArray));
    }

    public int findIndexOf(int target, int[] array) {
        for (int x = 0; x < array.length; x ++) {
            if (array[x] == target) {
                return x;
            }
        }
        return -1;
    }

    public int[][] appendArrays(int handType) {

        int numOfHands = getNumOfHands(handType);
        int[][] appendedArrays = new int[numOfHands][6];
        int indexCount = 0;
        int x = 0;
       while (indexCount != numOfHands) {
            if (orderedHandTypes[x] == handType) {
                for (int y = 0; y < 5; y ++) {
                    appendedArrays[indexCount][y] = orderedHandsA[x][y];
                }
                appendedArrays[indexCount][5] = orderedBidArray[x];
                indexCount ++;
                System.out.println("AppenedArray = " + Arrays.deepToString(appendedArrays));
            }
            x ++;
        }

        return appendedArrays;
    }

    public int[][] orderedArray(int[][] array) {

        ArrayList<int[]> sorted = new ArrayList<>();

        for (int x = 0; x < array.length; x ++) {
            if (sorted.size() == 0) {
                sorted.add(array[x]);
                System.out.println(sorted);
            }
            else {
                for (int y = 0; y < 5; y ++) {
                    int[] firstIndex = sorted.get(0);
                    int[] secondIndex = sorted.get(sorted.size() - 1);
                    if (array[x][y] < firstIndex[y]){
                        System.out.println("if " + array[x][y] + " < " + firstIndex[y]);
                        sorted.add(0, array[x]);
                        System.out.println(sorted);
                        y = 5;
                    }
                    else if ((array[x][y] > secondIndex[y]) && (!isArrayEmpty(array[x]))) {
                        System.out.println("else if " + array[x][y] + " > " + secondIndex[y] + " && " + !isArrayEmpty(array[x]));
                        sorted.add(array[x]);
                        System.out.println(sorted);
                        y = 5;
                    }
                    for (int z = 0; z < sorted.size() - 1; z ++) {
                        int[] current = sorted.get(z);
                        int[] next = sorted.get(z + 1);
                        if ((array[x][y] < current[y]) && (array[x][y] > next[y])) {
                            sorted.add(z + 1, array[x]);
                            y = 5;
                            z = sorted.size();
                        }
                    }
                }
            }
        }
        int[][] orderedArray = new int[sorted.size()][6];
        for (int i = 0; i != sorted.size(); i ++) {
            orderedArray[i] = sorted.get(i);
        }
        return orderedArray;
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

    public boolean isArrayEmpty(int[] array) {
        int count = 0;
        for (int x = 0; x < array.length; x ++) {
            if (array[x] == 0) {
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
        System.out.println("five = " + Arrays.deepToString(five));
        four = appendArrays(6);
        System.out.println("four = " + Arrays.deepToString(four));
        full = appendArrays(5);
        System.out.println("full = " + Arrays.deepToString(full));
        three = appendArrays(4);
        System.out.println("three = " + Arrays.deepToString(three));
        two = appendArrays(3);
        System.out.println("two = " + Arrays.deepToString(two));
        one = appendArrays(2);
        System.out.println("one = " + Arrays.deepToString(one));
        high = appendArrays(1);
        System.out.println("high = " + Arrays.deepToString(high));

        five = orderedArray(five);
        four = orderedArray(four);
        full = orderedArray(full);
        three = orderedArray(three);
        two = orderedArray(two);
        one = orderedArray(one);
        high = orderedArray(high);

        int[][] finalArray = new int[bidArray.length][6];
        int indexNum = 0;
        if (isArrayEmpty(high)) {
            for (int a = indexNum; a < indexNum + high.length; a ++) {
                finalArray[a] = high[a];
            }
            indexNum += high.length - 1;
        }

        if (isArrayEmpty(one)) {
            for (int b = indexNum; b < indexNum + one.length; b ++) {
                finalArray[b] = one[b];
            }
            indexNum += one.length - 1;
        }

        if (isArrayEmpty(two)) {
            for (int c = indexNum; c < indexNum + two.length; c ++) {
                finalArray[c] = two[c];
            }
            indexNum += two.length - 1;
        }

        if (isArrayEmpty(three)) {
            for (int d = indexNum; d < indexNum + three.length; d ++) {
                finalArray[d] = three[d];
            }
            indexNum += three.length - 1;
        }

        if (isArrayEmpty(full)) {
            for (int e = indexNum; e < indexNum + full.length; e ++) {
                finalArray[e] = full[e];
            }
            indexNum += full.length - 1;
        }

        if (isArrayEmpty(four)) {
            for (int f = indexNum; f < indexNum + four.length; f ++) {
                finalArray[f] = four[f];
            }
            indexNum += four.length - 1;
        }

        if (isArrayEmpty(five)) {
            for (int g = indexNum; g < indexNum + five.length; g ++) {
                finalArray[g] = five[g];
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
        return "Total Bid Value: " + findBidVal();
    }

}
