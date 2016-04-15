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

        String clubs = "♣";
        String diamonds = "♢";
        String hearts = "♡";
        String spades = "♠";


        //initial loop (for whole deck)



        for (int suits = 0; suits <= 3; suits++) {

            //secondary loop (for each suit)

            for (int cards = 1; cards <= 13; cards++) {

                //exception handlers:


                //lost king of spades

                if ((suits == 3) && (cards == 12)) {

                    System.out.print("");

                }

                //brute force 6 of hearts

                else if ((cards == 6) && (suits == 2)) {

                    System.out.println("[**]");

                }

                // lost 3s (except 3 of diamonds)

                else if ((cards == 3) && (suits != 1)) {

                    System.out.print("");

                }

                //  torn and water damaged cards

                else if ((cards % 3 == 0) && (((cards == 1) || (cards == 11) || (cards == 12) || (cards == 13)) && (suits != 3))) {

                        switch (suits) {

                            case 0:
                                System.out.println("-~" + cards + clubs + "~-");
                                break;

                            case 1:
                                System.out.println("-~" + cards + diamonds + "~-");
                                break;

                            case 2:
                                System.out.println("-~" + cards + hearts + "~-");
                                break;

                            case 3:
                                System.out.println("-~" + cards + spades + "~-");
                                break;
                        }
                }
            }

            //  torn cards

                else if (((cards == 1) || (cards == 11) || (cards == 12) || (cards == 13)) && (suits == 0 || suits == 2)){

                    switch(suits) {

                        case 0:
                            System.out.println("~" + cards + clubs + "~");
                            break;

                        case 1:
                            System.out.println("~" + cards + diamonds + "~");
                            break;

                        case 2:
                            System.out.println("~" + cards + hearts + "~");
                            break;

                        case 3:
                            System.out.println("~" + cards + spades + "~");
                            break;

                    }
                }




            //  water damaged cards

                else if ((cards % 3 == 0) && (suits == 1 || suits == 2)){

                switch(suits) {

                    case 0:
                        System.out.println("-" + cards + clubs + "-");
                        break;

                    case 1:
                        System.out.println("-" + cards + diamonds + "-");
                        break;

                    case 2:
                        System.out.println("-" + cards + hearts + "-");
                        break;

                    case 3:
                        System.out.println("-" + cards + spades + "-");
                        break;

                }
            }

                

            //  face down cards

                else if (((cards == 5) && (suits == 0)) || ((cards == 8) && (suits == 1)) || ((cards == 6) && (suits == 2)) ||
                        ((cards == 6) && (suits == 3)))
                {

                    System.out.println("**");

                }



            //  regular card symbol printing

                else if (cards == 1) {

                    switch(suits) {

                        case 0:
                            System.out.println("[" + "A" + clubs + "]");
                            break;

                        case 1:
                            System.out.println("[" + "A" + diamonds + "]");
                            break;

                        case 2:
                            System.out.println("[" + "A" + hearts + "]");
                            break;

                        case 3:
                            System.out.println("[" + "A" + spades + "]");
                            break;
                    
                    }
                }

                else if (cards == 10) {

                    switch(suits) {

                        case 0:
                            System.out.println("[" + "t" + clubs + "]");
                            break;

                        case 1:
                            System.out.println("[" + "t" + diamonds + "]");
                            break;

                        case 2:
                            System.out.println("[" + "t" + hearts + "]");
                            break;

                        case 3:
                            System.out.println("[" + "t" + spades + "]");
                            break;

                    }

                }

                else if (cards == 11) {

                    switch(suits) {

                        case 0:
                            System.out.println("[" + "J" + clubs + "]");
                            break;

                        case 1:
                            System.out.println("[" + "J" + diamonds + "]");
                            break;

                        case 2:
                            System.out.println("[" + "J" + hearts + "]");
                            break;

                        case 3:
                            System.out.println("[" + "J" + spades + "]");
                            break;

                    }

                }

                else if (cards == 12) {

                    switch(suits) {

                        case 0:
                            System.out.println("[" + "Q" + clubs + "]");
                            break;

                        case 1:
                            System.out.println("[" + "Q" + diamonds + "]");
                            break;

                        case 2:
                            System.out.println("[" + "Q" + hearts + "]");
                            break;

                        case 3:
                            System.out.println("[" + "Q" + spades + "]");
                            break;

                    }

                }

                else if (cards == 13) {

                    switch(suits) {

                        case 0:
                            System.out.println("[" + "K" + clubs + "]");
                            break;

                        case 1:
                            System.out.println("[" + "K" + diamonds + "]");
                            break;

                        case 2:
                            System.out.println("[" + "K" + hearts + "]");
                            break;

                        case 3:
                            System.out.println("[" + "K" + spades + "]");
                            break;

                    }

                }

                //print suit symbols

                else {
                    switch(suits) {

                        case 0:
                            System.out.println("[" + cards + clubs + "]");
                            break;

                        case 1:
                            System.out.println("[" + cards + diamonds + "]");
                            break;

                        case 2:
                            System.out.println("[" + cards + hearts + "]");
                            break;

                        case 3:
                            System.out.println("[" + cards + spades + "]");
                            break;


                    }
                }

                }
            }
        }
    }

