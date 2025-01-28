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


    public void AssignHand (){
        if (){
            fiveOfAKind++;
        }
        if (){
            fourOfAKind++;
        }
        if (){
            threeOfAKind++;
        }
        if (){
            twoPair++;
        }
        if (){
            onePair++;
        }
        if (){
            highCard++;
        }
    }
}
