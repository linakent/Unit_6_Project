public class GroupHand {

    private String[] cards;
    public int fiveOfAKind = 0;
    public int fourOfAKind = 0;
    public int threeOfAKind = 0;
    public int twoPair = 0;
    public int onePair = 0;
    public int highCard = 0;

    public GroupHand (String playerHand){
        cards = new String[5];
        cards[0] = playerHand.substring(0, playerHand.indexOf(","));
        playerHand = playerHand.substring(playerHand.indexOf(",") + 1);
        System.out.println(playerHand);
        cards[1] = playerHand.substring(0, playerHand.indexOf(","));
        playerHand = playerHand.substring(playerHand.indexOf(",") + 1);
        System.out.println(playerHand);
        cards[2] = playerHand.substring(0, playerHand.indexOf(","));
        playerHand = playerHand.substring(playerHand.indexOf(",") + 1);
        System.out.println(playerHand);
        cards[3] = playerHand.substring(0, playerHand.indexOf(","));
        playerHand = playerHand.substring(playerHand.indexOf(",") + 1);
        System.out.println(playerHand);
        cards[4] = playerHand.substring(0, playerHand.indexOf("|"));


    }

    public int countCard(String target) {
        int numOfTimes = 0;
        for (int x = 0; x < cards.length; x ++) {
            if (cards[x].equals(target))
                numOfTimes ++;
            }
        }
        return numOfTimes;
    }

    public void AssignHand (){

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

        if (1 == 0){
            fiveOfAKind++;
        }
        if (1 == 0){
            fourOfAKind++;
        }
        if (1 == 0){
            threeOfAKind++;
        }
        if (1 == 0){
            twoPair++;
        }
        if (1 == 0){
            onePair++;
        }
        if (1 == 0){
            highCard++;
        }
    }
}
