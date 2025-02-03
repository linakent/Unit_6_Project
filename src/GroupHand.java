public class GroupHand {
    public int bidValue = 0;
    public String[] cards;
    private PartTwo partTwo;

    public GroupHand (String playerHand){
        cards = new String[5];
        cards[0] = playerHand.substring(0, playerHand.indexOf(","));
        playerHand = playerHand.substring(playerHand.indexOf(",") + 1);
        cards[1] = playerHand.substring(0, playerHand.indexOf(","));
        playerHand = playerHand.substring(playerHand.indexOf(",") + 1);
        cards[2] = playerHand.substring(0, playerHand.indexOf(","));
        playerHand = playerHand.substring(playerHand.indexOf(",") + 1);
        cards[3] = playerHand.substring(0, playerHand.indexOf(","));
        playerHand = playerHand.substring(playerHand.indexOf(",") + 1);
        cards[4] = playerHand.substring(0, playerHand.indexOf("|"));
        bidValue = Integer.parseInt(playerHand.substring(playerHand.indexOf("|") + 1));
        int[] bdjhgjhdas = {0, 1};
        partTwo = new PartTwo(cards, bdjhgjhdas);
    }

    public int countCard(String target) {
        int numOfTimes = 0;
        for (int x = 0; x < cards.length; x ++) {
            if (cards[x].equals(target)) {
                numOfTimes ++;
            }
        }
        return numOfTimes;
    }

    public String assignHand(){

        int numOfAce = countCard("Ace");
        int numOfKing = countCard("King");
        int numOfQueen = countCard("Queen");
        int numOfJack = countCard("Jack");
        int numOf10 = countCard("10");
        int numOf9 = countCard("9");
        int numOf8 = countCard("8");
        int numOf7 = countCard("7");
        int numOf6 = countCard("6");
        int numOf5 = countCard("5");
        int numOf4 = countCard("4");
        int numOf3 = countCard("3");
        int numOf2 = countCard("2");

        String string = "" + numOfAce + numOfKing + numOfQueen + numOfJack + numOf2 + numOf3 + numOf4 + numOf5 + numOf6 + numOf7 + numOf8 + numOf9 + numOf10;
        boolean ifOnePair = string.indexOf("2") != -1;
        boolean ifTwoPair = false;
        if (ifOnePair) {
            string = string.substring(string.indexOf("2") + 1);
            ifTwoPair = string.indexOf("2") != -1;
        }
        if (partTwo.jackIsWild == true){

            if ((numOfAce == 3 || numOfKing == 3 || numOfQueen == 3 || numOfJack == 3 || numOf10 == 3 || numOf9 == 3 || numOf8 == 3 || numOf7 == 3 || numOf6 == 3 || numOf5 == 3 || numOf4 == 3 || numOf3 == 3 || numOf2 == 3) && (numOfAce == 2 || numOfKing == 2 || numOfQueen == 2 || numOfJack == 2 || numOf10 == 2 || numOf9 == 2 || numOf8 == 2 || numOf7 == 2 || numOf6 == 2 || numOf5 == 2 || numOf4 == 2 || numOf3 == 2 || numOf2 == 2)) {
                return "full";
            }
            else if (numOfAce == 5 || numOfKing == 5 || numOfQueen == 5 || numOfJack == 5 || numOf10 == 5 || numOf9 == 5 || numOf8 == 5 || numOf7 == 5 || numOf6 == 5 || numOf5 == 5 || numOf4 == 5 || numOf3 == 5 || numOf2 == 5) {
                return "five";
            }
            else if (numOfAce == 4 || numOfKing == 4 || numOfQueen == 4 || numOf10 == 4 || numOf9 == 4 || numOf8 == 4 || numOf7 == 4 || numOf6 == 4 || numOf5 == 4 || numOf4 == 4 || numOf3 == 4 || numOf2 == 4) {
                if (numOfJack == 1){
                   return "five";
                }
                else return "four";

            }
            else if (numOfAce == 3 || numOfKing == 3 || numOfQueen == 3 || numOf10 == 3 || numOf9 == 3 || numOf8 == 3 || numOf7 == 3 || numOf6 == 3 || numOf5 == 3 || numOf4 == 3 || numOf3 == 3 || numOf2 == 3) {
                if (numOfJack == 2){
                    return "five";
                }
                else if (numOfJack == 1){
                    return "four";
                }
                else return "three";
            }
            else if (ifTwoPair) {
                if (numOfJack == 1){
                    return "full";
                }
                else return "two";
            }
            else if (ifOnePair) {
                if (numOfJack == 1){
                    return "three";
                }
                else return "one";
            }
            else {
                if (numOfJack == 1){
                    return "one";
                }
                else return "high";
            }
        }
        else {
            if ((numOfAce == 3 || numOfKing == 3 || numOfQueen == 3 || numOfJack == 3 || numOf10 == 3 || numOf9 == 3 || numOf8 == 3 || numOf7 == 3 || numOf6 == 3 || numOf5 == 3 || numOf4 == 3 || numOf3 == 3 || numOf2 == 3) && (numOfAce == 2 || numOfKing == 2 || numOfQueen == 2 || numOfJack == 2 || numOf10 == 2 || numOf9 == 2 || numOf8 == 2 || numOf7 == 2 || numOf6 == 2 || numOf5 == 2 || numOf4 == 2 || numOf3 == 2 || numOf2 == 2)) {
                return "full";
            } else if (numOfAce == 5 || numOfKing == 5 || numOfQueen == 5 || numOfJack == 5 || numOf10 == 5 || numOf9 == 5 || numOf8 == 5 || numOf7 == 5 || numOf6 == 5 || numOf5 == 5 || numOf4 == 5 || numOf3 == 5 || numOf2 == 5) {
                return "five";
            } else if (numOfAce == 4 || numOfKing == 4 || numOfQueen == 4 || numOfJack == 4 || numOf10 == 4 || numOf9 == 4 || numOf8 == 4 || numOf7 == 4 || numOf6 == 4 || numOf5 == 4 || numOf4 == 4 || numOf3 == 4 || numOf2 == 4) {
                return "four";
            } else if (numOfAce == 3 || numOfKing == 3 || numOfQueen == 3 || numOfJack == 3 || numOf10 == 3 || numOf9 == 3 || numOf8 == 3 || numOf7 == 3 || numOf6 == 3 || numOf5 == 3 || numOf4 == 3 || numOf3 == 3 || numOf2 == 3) {
                return "three";
            } else if (ifTwoPair) {
                return "two";
            } else if (ifOnePair) {
                return "one";
            } else {
                return "high";
            }
        }
    }
}

