public class GroupHand {

    private String[] cards;

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
        for (int x = 0; x < cards.length; x ++;) {
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


        if (numOfAce == 5 || numOfKing == 5 || numOfQueen == 5 || numOfJack == 5 || numOf10 == 5 || numOf9 == 5 || numOf8 == 5 || numOf7 == 5 || numOf6 == 5 || numOf5 == 5 || numOf4 == 5 || numOf4 == 5 || numOf3 == 5 || numOf2 == 5){
            return "five";
        }
        else if (numOfAce == 4 || numOfKing == 4 || numOfQueen == 4 || numOfJack == 4 || numOf10 == 4 || numOf9 == 4 || numOf8 == 4 || numOf7 == 4 || numOf6 == 4 || numOf5 == 4 || numOf4 == 4 || numOf4 == 4 || numOf3 == 4 || numOf2 == 4){
            return "four";
        }
        else if (numOfAce == 3 || numOfKing == 3 || numOfQueen == 3 || numOfJack == 3 || numOf10 == 3 || numOf9 == 3 || numOf8 == 3 || numOf7 == 3 || numOf6 == 3 || numOf5 == 3 || numOf4 == 3 || numOf4 == 3 || numOf3 == 3 || numOf2 == 3){
            return "three";
        }
        else if (numOfAce == 2 || numOfKing == 2 || numOfQueen == 2 || numOfJack == 2 || numOf10 == 2 || numOf9 == 2 || numOf8 == 2 || numOf7 == 2 || numOf6 == 2 || numOf5 == 2 || numOf4 == 2 || numOf4 == 2 || numOf3 == 2 || numOf2 == 2){
            return "two";
        }
        else if (numOfAce == 1 || numOfKing == 1 || numOfQueen == 1 || numOfJack == 1 || numOf10 == 1 || numOf9 == 1 || numOf8 == 1 || numOf7 == 1 || numOf6 == 1 || numOf5 == 1 || numOf4 == 1 || numOf4 == 1 || numOf3 == 1 || numOf2 == 1){
            return "one";
        }
        else {
            return "high";
        }
    }
}
