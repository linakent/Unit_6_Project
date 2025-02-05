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
    private int[][] orderedHandsB;
    private PartOne partOne;

    private static int handIndex = 0;

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
        orderedHandsB = new int[orderedHandsA.length][5];
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

    public int[] getCardsArray(int numOfCards, int assignedCardNum, int cardIndex) {
        int[] array = new int[numOfCards];
        for (int y = handIndex; y < orderedHandTypes.length; y ++) {
            //System.out.println("if (orderedHandTypes[y](" + orderedHandTypes[y] + " == assignedCardNum(" + assignedCardNum + ")");
            if (orderedHandTypes[y] == assignedCardNum) {
                for (int x = 0; x < numOfCards; x ++) {
                    array[x] = orderedHandsA[y][cardIndex];
                    //System.out.println("array[x] = orderedHandsA[" + y + "][" + cardIndex + "];");
                }
            }
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    private void swap(int hand1, int hand2) {
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

    public int[] orderCardArray(int[] array, int numOfHandsInFront) {
        int[] origArray = array;
        int[] orderedArray = new int[array.length];
        int numOfIndex = 0;
        int temp;
        for (int x = 0; x < array.length; x ++) {
            for (int y = 0; y < array.length; y ++) {
                if (origArray[x] < origArray[y]) {
                    numOfIndex ++;
                }
            }
            if (numOfIndex == array.length - x) {
                swap(x, x+1);
            }
        }
        return orderedArray;
    }

    public void orderByCard() {

        int handIndex = 0;

        int[] cardsOfFive = new int[partOne.fiveOfAKind];
        int fiveCounter = 0;
        int numOfFives = partOne.fiveOfAKind;
        while (ifHaveRepeatedElement(cardsOfFive)) {
            numOfFives = cardsOfFive.length;
            cardsOfFive = getCardsArray(numOfFives, 7, fiveCounter);
            cardsOfFive = orderCardArray(cardsOfFive, handIndex);
            fiveCounter ++;
        }

        int[] cardsOfFour = new int[partOne.fourOfAKind];
        int fourCounter = 0;
        int numOfFours = partOne.fourOfAKind;
        while (ifHaveRepeatedElement(cardsOfFive)) {
            numOfFours = cardsOfFour.length;
            cardsOfFour = getCardsArray(numOfFours, 6, fourCounter);
            cardsOfFive = orderCardArray(cardsOfFour, handIndex);
            fourCounter ++;
        }


        int[] cardsOfFull = new int[partOne.fullHouse];
        int fullCounter = 0;
        int numOfFulls = partOne.fullHouse;
        while (ifHaveRepeatedElement(cardsOfFull)) {
            numOfFulls = cardsOfFull.length;
            cardsOfFull = getCardsArray(numOfFulls, 5, fullCounter);
            cardsOfFull = orderCardArray(cardsOfFull, handIndex);
            fiveCounter ++;
        }
        System.out.println("Stuck four");

        //MISSING 4

        int[] cardsOfThree = new int[partOne.threeOfAKind];
        int threeCounter = 0;
        int numOfThrees;
        while (ifHaveRepeatedElement(cardsOfThree)) {
            numOfThrees = cardsOfThree.length;
            cardsOfThree = getCardsArray(numOfThrees, 4, threeCounter);
            cardsOfThree = orderCardArray(cardsOfThree, handIndex);
            fiveCounter ++;
        }
        System.out.println("Stuck five");

        int[] cardsOfTwo = new int[partOne.twoPair];
        int twoCounter = 0;
        int numOfTwos;
        while (ifHaveRepeatedElement(cardsOfTwo)) {
            numOfTwos = cardsOfTwo.length;
            cardsOfTwo = getCardsArray(numOfTwos, 3, twoCounter);
            cardsOfTwo = orderCardArray(cardsOfTwo, handIndex);
            fiveCounter ++;
        }


        int[] cardsOfOne = new int[partOne.onePair];
        int oneCounter = 0;
        int numOfOnes;
        while (ifHaveRepeatedElement(cardsOfOne)) {
            numOfOnes = cardsOfOne.length;
            cardsOfOne = getCardsArray(numOfOnes, 2, oneCounter);
            cardsOfOne = orderCardArray(cardsOfOne, handIndex);
            oneCounter ++;
        }


        int[] cardsOfHigh = new int[partOne.highCard];
        int highCounter = 0;
        int numOfHighs;
        while (ifHaveRepeatedElement(cardsOfHigh)) {
            numOfHighs = cardsOfHigh.length;
            cardsOfHigh = getCardsArray(numOfHighs, 1, highCounter);
            cardsOfHigh = orderCardArray(cardsOfHigh, handIndex);
            highCounter ++;
        }

//
//        System.out.println("OrderedBidArray = " + Arrays.toString(orderedBidArray));
//        System.out.println("here! orderedHandsA = " + Arrays.deepToString(orderedHandsA));
//        for (int x = 0; x < orderedHandsA.length - 1; x ++) {
//            System.out.println("Checking if " + orderedHandTypes[x] + " == " + orderedHandTypes[x + 1]);
//            if (orderedHandTypes[x] == orderedHandTypes[x + 1]) {
//                for (int y = 0; y < 5; y++) {
//                    int temp;
//                    int[] temp2;
//
//                    if (orderedHandsA[x][y] != orderedHandsA[x + 1][y]) {
//                        if ((orderedHandsA[x][y] > orderedHandsA[x + 1][y])) {
//                            System.out.println("Com```pared if " + orderedHandsA[x][y] + " > " + orderedHandsA[x + 1][y]);
//                            System.out.println("orderedBidArray[x] = " + orderedBidArray[x]);
//                            System.out.println("orderedBidArray[x + 1] = " + orderedBidArray[x + 1]);
//                            temp = orderedBidArray[x];
//                            System.out.println("temp = " + temp);
//                            orderedBidArray[x] = orderedBidArray[x + 1];
//                            System.out.println("orderedbidArray[x] = " + orderedBidArray[x]);
//                            orderedBidArray[x + 1] = temp;
//                            System.out.println("orderedBidArray[x + 1] = " + orderedBidArray[x + 1]);
//
//                            temp2 = orderedHandsA[x];
//                            orderedHandsA[x] = orderedHandsA[x + 1];
//                            orderedHandsA[x + 1] = temp2;
//
//                            System.out.println();
//                            System.out.println("OrderedBidArray = " + Arrays.toString(orderedBidArray));
//                            System.out.println("OrderedHandsA = " + Arrays.deepToString(orderedHandsA));
//                            System.out.println();
//                            y = 5;
//                        }
//                        if (!ifHaveRepeatedElement(orderedHandTypes)) {
//                            y = 5;
//                        }
//                    }
//
//                }
//            }
//            orderedHandsB[x] = orderedHandsA[x];
//        }
//        orderedHandsB[orderedHandsB.length - 1] = orderedHandsA[orderedHandsA.length - 1];
//        System.out.println("OrderedHandsA = " + Arrays.deepToString(orderedHandsA));
//        System.out.println("OrderedHandsB = " + Arrays.deepToString(orderedHandsB));
    }

//    public int findBidVal() {
//        orderByHandType();
//        if (ifHaveRepeatedElement(orderedHandTypes)) {
//            orderByCard();
//        }
//        int total = 0;
//
//        System.out.print("(");
//        for (int x = 1; x <= orderedBidArray.length; x ++) {
//            System.out.print(orderedBidArray[x - 1] + " * " + x + " + ");
//            total += orderedBidArray[x - 1] * x;
//        }
//        System.out.println(")");
//        return total;
//    }

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
