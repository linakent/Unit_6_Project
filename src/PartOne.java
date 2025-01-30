public class PartOne {

    
    private int fiveOfAKind;
    private int fourOfAKind;
    private int fullHouse;
    private int threeOfAKind;
    private int twoPair;
    private int onePair;
    private int highCard;

    public void getPartOneAnswer(String[] inputArray) {
        for (int x = 0; x < inputArray.length; x ++) {
            GroupHand hand = new GroupHand(inputArray[x]);
            String handType = hand.assignHand();
            if (handType.equals("five")) {
                fiveOfAKind ++;
            }
            else if (handType.equals("four")) {
                fourOfAKind ++;
            } else if (handType.equals("five")) {
                
            } else if (handType.equals("three")) {
                threeOfAKind ++;
            } else if (handType.equals("two")) {
                twoPair ++;
            }
        }
    }

}
