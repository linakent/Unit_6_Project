import java.util.ArrayList;

public class PartTwo {

    public ArrayList<String[][]> fiveOfAKindArray;
    public ArrayList<String[][]> fourOfAKindArray;
    public ArrayList<String[][]> fullHouseArray;
    public ArrayList<String[][]> threeOfAKindArray;
    public ArrayList<String[][]> twoPairArray;
    public ArrayList<String[][]> onePairArray;
    public ArrayList<String[][]> highCardArray;

    public PartTwo() {

        fiveOfAKindArray = new ArrayList<String[][]>();
        fourOfAKindArray = new ArrayList<String[][]>();
        fullHouseArray = new ArrayList<String[][]>();
        threeOfAKindArray = new ArrayList<String[][]>();
        twoPairArray = new ArrayList<String[][]>();
        onePairArray = new ArrayList<String[][]>();
        highCardArray = new ArrayList<String[][]>();

    }

    public String[] getBet(String input) {
        String[] temp = new String[1];
        temp[0] = input.substring(input.indexOf("|") + 1);
        return temp;
    }

    public String[][] in2DArray(String[] x, String[] y) {
        String[][] temp = new String[2][1];
        temp[0] = x;
        temp[1] = y;
        return temp;
    }

    public void sortArray(ArrayList<String[][]> arrayList) {
        boolean sameCard = true;
        for (int y = 0; y < arrayList.size(); y ++) {
            for (int x = 0; x < arrayList.size(); x ++) {
                while (sameCard) {
                    if ((arrayList.get(y)[0][0]).equals())
                }
            }
        }

    }

}
