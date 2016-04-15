/**
 * You once had a nice deck of cards.
 *
 * The cards in the decal had the following values:
 *  Ace = 1
 *  2 = 2
 *  3 = 3
 *  ... etc ...
 *  10 = 10
 *  Jack = 11
 *  Queen = 12
 *  King = 13
 *
 * The symbols for the suits are:
 *
 *  Clubs = ♣
 *  Diamonds = ♢
 *  Hearts = ♡
 *  Spades = ♠
 *
 * Unfortunately you've lost the following cards:
 *  - King of Spades
 *  - All of the 3s except 3 of Diamonds
 *
 * All of the cards that are divisible by 3 and have a suit that is red have been torn.
 *
 * All of the face cards (ace, jack, queen, king) in the hearts and clubs suits have been water damaged.
 *
 * Any card whose value is the same as the number of letters in the card's suit (in plural form) is face down. All other
 * cards are face up. For example, the 6 of Hearts would be face down because "Hearts" is 6 letters long and the value
 * of the card is 6.
 *
 * Your task is to describe your deck of cards:
 *
 * Output the cards in ascending order by value, grouped by suit, in alphabetical order.
 *  - Ace of Clubs, 2 of clubs, 3 of clubs ... etc ... queen of spades, king of spades.
 *
 * For face cards output the first letter of the card. IE: A, J, Q, or K.
 *
 * For 10s output "t".
 *
 * For all other cards output the value of the card. IE: 2, 3, 4...., or 9.
 *
 * Cards in good shape are output like this: [A♢], [9♠], [t♣], etc.
 *
 * Cards that are torn are output like this: -A♢-, -9♠-, -t♣-, etc.
 *
 * Cards that are water damaged are output like this: ~A♢~, ~9♠~, ~t♣~ etc
 *
 * Cards that are torn AND water damaged are output like this: -~A♢~-, -~9♠~-, -~t♣~- etc
 *
 * Cards that are face down are output with asterisks instead of the card's value and suit. For example, [**], -**-, or ~**~.
 *
 * Output one card per line.
 *
 * Lastly, output the number of cards you have in your deck on its own line.
 *
 */
public class LostCards {

    public static void main(String[] args) {

        /*suit codes
        clubs = 0
        diamonds = 1
        hearts = 2
        spades = 3 */


        //initializing suit symbols

        /*
        String clubs = "♣";
        String diamonds = "♢";
        String hearts = "♡";
        String spades = "♠";
        */

        //init total

        int total = 0;

        //initial loop (for whole deck)


        for (int suit = 0; suit <= 3; suit++, total++) {

            //secondary loop (for each suit)

            for (int cardValue = 1; cardValue <= 13; cardValue++, total++) {

                //init boolean rules

                boolean torn = false;
                boolean water = false;
                boolean lost = false;
                boolean faceDown = false;

                //exception checks

                if ((cardValue == 5 && suit == 0) || (cardValue == 8 && suit == 1) ||
                        (cardValue == 6 && suit == 2) || (cardValue == 6 && suit == 3)){
                    faceDown = true;
                }

                if (((suit == 3 && cardValue == 13)) || ((cardValue == 3) && (suit != 1))){
                    lost = true;
                }

                if ((cardValue % 3 == 0) && (suit == 1 || suit == 2)){
                    torn = true;
                }

                if ((cardValue == 1 || cardValue == 11 || cardValue == 12 || cardValue == 13) &&
                        (suit == 0 || suit == 2)){
                    water = true;
                }



                //card printing

                if(lost){

                total -= 2;
                continue;

                }

                if(torn && water){

                    System.out.print("-~");

                }

                else if(torn){

                    System.out.print("-");

                }

                else if(water){

                    System.out.print("~");

                }

                else if (!torn && !water) {

                    System.out.print("[");

                }

                if(faceDown){

                    System.out.print("**");

                }

                //basic switches

                if(!faceDown) {

                    switch (cardValue) {

                        case 1:
                            System.out.print("A");
                            break;
                        case 10:
                            System.out.print("t");
                            break;
                        case 11:
                            System.out.print("J");
                            break;
                        case 12:
                            System.out.print("Q");
                            break;
                        case 13:
                            System.out.print("K");
                            break;
                        default:
                            System.out.print(cardValue);

                    }

                    switch (suit) {

                        case 0:
                            System.out.print("♣");
                            break;
                        case 1:
                            System.out.print("♢");
                            break;
                        case 2:
                            System.out.print("♡");
                            break;
                        case 3:
                            System.out.print("♠");
                            break;

                    }
                }

                //boolean rules part 2

                if(!torn && !water) {

                    System.out.println("]");

                }

                if(torn && water){

                    System.out.println("~-");

                }

                else if(water){

                    System.out.println("~");

                }

                else if(torn){

                    System.out.println("-");

                }



                }
            }
        System.out.println(total);
        }

    }


