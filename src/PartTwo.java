public class PartTwo {

    private int[] betArray;
    private int[][] handsArray;

    public PartTwo(String[] inputArray) {
        betArray = new int[inputArray.length];
        handsArray = new int[1][inputArray.length];
        for (int x = 0; x < inputArray.length; x++) {
            handsArray[0][x] = -1;
        }
    }

    public int[] translateArray(String[] cardsArray) {
        int[] temp = new int[cardsArray.length];
        for (int x = 0; x < temp.length; x ++) {
            if (cardsArray[x].equals("Ace")) {
                temp[x] = 1;
            }
        }
        return temp;
    }

    public void placeInHandArray(int[] cardsArray, String handType) {
        if (handType.equals("five")) {
            if (handsArray[0][0] == -1) {

            }
        }
    }


}
