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
        int numOfHandsCount = 0;
        int x = 0;
       while (numOfHandsCount != numOfHands) {
            if (orderedHandTypes[x] == handType) {
                for (int y = 0; y < 5; y ++) {
                    appendedArrays[numOfHandsCount][y] = orderedHandsA[x][y];
                }
                appendedArrays[numOfHandsCount ][5] = orderedBidArray[x];
                numOfHandsCount++;
//                System.out.println("AppenedArray = " + Arrays.deepToString(appendedArrays));
            }
//           System.out.println("NumOfHands = " + numOfHandsCount);
            x ++;
        }

        return appendedArrays;
    }

    public int[][] orderedArray(int[][] array) {

        int sortedIndexTracker = 0;
        ArrayList<int[]> unsorted = new ArrayList<>();
        for (int a = 0; a < array.length; a ++) {
            unsorted.add(array[a]);
        }
//        System.out.print("[");
//        for (int o = 0; o < unsorted.size(); o ++) {
//            int[] temp = unsorted.get(o);
//            System.out.print(Arrays.toString(temp) + ", ");
//        }
//        System.out.println("]");
        ArrayList<int[]> sorted = new ArrayList<>();

        while (!unsorted.isEmpty()) {
            int[] item = unsorted.remove(0);

            if (sorted.isEmpty()) {
                sorted.add(item);
                System.out.println("haiiiii");
            }
            else {
                for (int x = 0; x < 5; x ++) {
                    int[] firstHand = sorted.get(0);
                    int[] lastHand = sorted.get(sorted.size() - 1);
                    System.out.println("If " + item[x] + " < " + firstHand[x]);
                    if (item[x] < firstHand[x]) {
//                        System.out.println("Yes");
                        System.out.println("heyyyy");
                        sorted.add(0, item);
                        System.out.print("sorted = [");
                        for (int o = 0; o < sorted.size(); o ++) {
                            int[] temp = sorted.get(o);
                            System.out.print(Arrays.toString(temp) + ", ");
                        }
                        System.out.println("]");
//                        System.out.print("[");
//                        for (int o = 0; o < sorted.size(); o ++) {
//                            int[] temp = sorted.get(o);
//                            System.out.print(Arrays.toString(temp) + ", ");
//                        }
//                        System.out.println("]");
                        x = 5;

                    }
                    else if ((item[x] > lastHand[x])) {
                        System.out.println("hello");
                        sorted.add(item);
                        x = 5;
                    }
                    else {
                        for (int y = 0; y < sorted.size() - 1; y ++) {
                            int[] current = sorted.get(y);
                            int[] next = sorted.get(y + 1);
                            System.out.println("if (( item[" + x + "] == " + item[x] + " > " + current[x] + " ) && ( " + item[x] + " < " + next[x] + " ))");
                            if ((item[x] > current[x]) && (item[x] < next[x])) {
                                System.out.println("yesss");
                                sorted.add(y + 1, item);
                                x = 5;
                                y = sorted.size() -1;
                            }
                        }
                        System.out.print("sorted = [");
                        for (int o = 0; o < sorted.size(); o ++) {
                            int[] temp = sorted.get(o);
                            System.out.print(Arrays.toString(temp) + ", ");
                        }
                        System.out.println("]");
                    }
                }
            }
        }

        int[][] orderedArray = new int[sorted.size()][6];
        for (int i = 0; i != sorted.size(); i ++) {
            orderedArray[i] = sorted.get(i);
        }
//        System.out.println("OrderedArray = " + Arrays.deepToString(orderedArray));
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
//        System.out.println("five = " + Arrays.deepToString(five));
        four = appendArrays(6);
//        System.out.println("four = " + Arrays.deepToString(four));
        full = appendArrays(5);
//        System.out.println("full = " + Arrays.deepToString(full));
        three = appendArrays(4);
//        System.out.println("three = " + Arrays.deepToString(three));
        two = appendArrays(3);
//        System.out.println("two = " + Arrays.deepToString(two));
        one = appendArrays(2);
//        System.out.println("one = " + Arrays.deepToString(one));
        high = appendArrays(1);
//        System.out.println("high = " + Arrays.deepToString(high));

        five = orderedArray(five);
        System.out.println("Ordered five = " + Arrays.deepToString(five));
        four = orderedArray(four);
        System.out.println("Ordered four = " + Arrays.deepToString(four));
        full = orderedArray(full);
        System.out.println("Ordered full = " + Arrays.deepToString(full));
        three = orderedArray(three);
        System.out.println("Ordered three = " + Arrays.deepToString(three));
        two = orderedArray(two);
        System.out.println("Ordered two = " + Arrays.deepToString(two));
        System.out.println("nonOrdered One = " + Arrays.deepToString(one));
        one = orderedArray(one);
        System.out.println("Ordered One = " + Arrays.deepToString(one));
        high = orderedArray(high);
        System.out.println("Ordered high = " + Arrays.deepToString(high));

        int totalBidNum = partOne.getFiveOfAKind() + partOne.getFullHouse() + partOne.getFourOfAKind() + partOne.getThreeOfAKind() + partOne.getTwoPair() + partOne.getOnePair() + partOne.getHighCard();
//        System.out.println(partOne.getFiveOfAKind() + " + " + partOne.getFullHouse() + " + " + partOne.getFourOfAKind() + " + " + partOne.getThreeOfAKind() + " + " + partOne.getTwoPair() + " + " + partOne.getOnePair() + " + " + partOne.getHighCard());
//        System.out.println("totalBidNum = " + totalBidNum);
        int[][] finalArray = new int[totalBidNum][6];
//        System.out.println(Arrays.deepToString(finalArray));
        int finalArrayIndex = 0;

//        System.out.println("finalArrayIndex = " + finalArrayIndex);

        if (!isArrayEmpty(high)) {
//            System.out.println("high.length = " + high.length);
            for (int a = 0; a < high.length; a ++) {
                finalArray[finalArrayIndex] = high[a];
                finalArrayIndex ++;
            }
        }

        if (!isArrayEmpty(one)) {
//            System.out.println("hereeee");
//            System.out.println("one.length = " + one.length);
            for (int b = 0; b < one.length; b ++) {
                finalArray[finalArrayIndex] = one[b];
                finalArrayIndex ++;
            }
        }

//        System.out.println("finalArrayIndex after one = " + finalArrayIndex);

        if (!isArrayEmpty(two)) {
//            System.out.println("here, yes");
//            System.out.println("two.length = " + two.length);
            for (int c = 0; c < two.length; c ++) {
//                System.out.println("finalArray.length = " + finalArray.length);
//                System.out.println("finalArrayIndex = " + finalArrayIndex);
                finalArray[finalArrayIndex] = two[c];
                finalArrayIndex ++;
//                System.out.println("finalArray[" + c + "] = " + Arrays.toString(two[c]));
            }
        }

//        System.out.println("finalArrayIndex after two = " + finalArrayIndex);

        if (!isArrayEmpty(three)) {
//            System.out.println("three.length = " + three.length);
            for (int d = 0; d < three.length; d ++) {
                finalArray[finalArrayIndex] = three[d];
//                System.out.println("finalArray[" + finalArrayIndex + "]" + " = " + Arrays.toString(three[d]));
                finalArrayIndex ++;
            }
        }

//        System.out.println("finalArrayIndex after three = " + finalArrayIndex);

        if (!isArrayEmpty(full)) {
//            System.out.println("full.length = " + full.length);
            for (int e = 0; e < full.length; e ++) {
                finalArray[finalArrayIndex] = full[e];
                finalArrayIndex ++;
            }
        }

//        System.out.println("finalArrayIndex after full = " + finalArrayIndex);

        if (!isArrayEmpty(four)) {
//            System.out.println("four.length = " + four.length);
            for (int f = 0; f < four.length; f ++) {
                finalArray[finalArrayIndex] = four[f];
                finalArrayIndex ++;
            }
        }

//        System.out.println("finalArrayIndex after four = " + finalArrayIndex);

        if (!isArrayEmpty(five)) {
//            System.out.println("five.length = " + five.length);
            for (int g = 0; g < five.length; g ++) {
                finalArray[finalArrayIndex] = five[g];
                finalArrayIndex ++;
            }
        }
//        System.out.println("finalArrayIndex after five = " + finalArrayIndex);

        return finalArray;
    }

    public int findBidVal() {
        orderByHandType();
        int[][] orderedArray = orderBidArrayByCards();
//        System.out.println(Arrays.deepToString(orderedArray));
        int totalBid = 0;
        for (int x = 0; x < orderedArray.length; x ++) {
            totalBid += orderedArray[x][5] * (x + 1);
//            System.out.println("totalBid += (" + orderedArray[x][5] + " * " + (x + 1) + ")");
        }
        return totalBid;
    }

    public String toString() {
        return "Total Bid Value: " + findBidVal();
    }

}
