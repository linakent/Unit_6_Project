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
    }

    public int[] translateCardArray(String[] cardsArray) {
        int[] temp = new int[cardsArray.length];
        for (int x = 0; x < temp.length; x ++) {
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
        //System.out.println("orderedBidArray1 = " + Arrays.toString(orderedBidArray));
    }

    public void orderByCard() {
        //System.out.println("here! orderedHandsA = " + Arrays.deepToString(orderedHandsA));
        for (int x = 0; x < orderedHandsA.length - 1; x ++) {
            //System.out.println("Checking if " + orderedHandTypes[x] + " == " + orderedHandTypes[x + 1]);
            if (orderedHandTypes[x] == orderedHandTypes[x + 1]) {
                for (int y = 0; y < 5; y++) {
                    int temp;
                    int[] temp2;
                    if ((orderedHandsA[x][y] > orderedHandsA[x + 1][y])) {
                        //System.out.println("Compared if " + orderedHandsA[x][y] + " < " + orderedHandsA[x + 1][y]);
                        //System.out.println("orderedBidArray[x] = " + orderedBidArray[x]);
                        //System.out.println("orderedBidArray[x + 1] = " + orderedBidArray[x + 1]);
                        temp = orderedBidArray[x];
                        //System.out.println("temp = " + temp);
                        orderedBidArray[x] = orderedBidArray[x + 1];
                        //System.out.println("orderedbidArray = " + orderedBidArray[x + 1]);
                        orderedBidArray[x + 1] = temp;
                        //System.out.println("orderedBidArray[x + 1] = " + temp);

                        temp2 = orderedHandsA[x];
                        orderedHandsA[x] = orderedHandsA[x + 1];
                        orderedHandsA[x + 1] = temp2;
                        y = 5;
                    }
                }
            }
            orderedHandsB[x] = orderedHandsA[x];
        }
        orderedHandsB[orderedHandsB.length - 1] = orderedHandsA[orderedHandsA.length - 1];
        //System.out.println("OrderedHandsA = " + Arrays.deepToString(orderedHandsA));
        //System.out.println("OrderedHandsB = " + Arrays.deepToString(orderedHandsB));
    }

    public int findBidVal() {
        orderByHandType();
        orderByCard();
        int total = 0;

        //System.out.print("(");
        for (int x = 1; x <= orderedBidArray.length; x ++) {
            //System.out.print(orderedBidArray[x - 1] + " * " + x + " + ");
            total += orderedBidArray[x - 1] * x;
        }
        //System.out.println(")");
        return total;
    }

    public String toString() {
        return "Total Bid Value: " + findBidVal();
    }


}
