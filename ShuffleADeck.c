/**
 * Shuffle: Write a method to shuffle a deck of cards, it must be a perfect shuffle, i.e. each of the 52! permutations should be equally likely.
 * Assume a perfect random number generator.
 * Shuffle = selection of one card for each of 52 locations, without replacement, where order matters
 * i.e. a permutation of 52 cards selecting 52 cards, one at a time
 * 52C1 * 51C1 * 50C1 * ..... * 3C1 * 2C1 * 1C1
 * 52!/51!1! * 51!/50!1! * 50!/49!1! * ...... * 3!/2!1! * 2!/1!1! * 1!/1!
 * 52! * 1 * 1 * 1....
 * 52!
 */

/* Assuming rand() as the RNG function */
#include <math.h>

struct card {
	int num; /* A, 1, 2, 3..., 10, J, Q, K, Jokers, or could be a custom type, enum or another struct */
	int suit; /* Spade, Club, Heart, Diamond */
	bool taken; /* Has been chosen, so cannot be chosen again */
};

/* Assuming standard playing cards
 * Modifications for different sets, Uno, Monopoly, etc can be made by parameterizing the array in struct deck
 * Much easier with OOP, but syntax for OOP would throw me off
 */
struct deck {
	struct card cards[52]; /* Assuming Jokers removed */
};

struct deck shuffle;

/**
 * @deck: Pointer to struct of type deck containing an order of cards to be shuffled
 * @return: Returns a pointer to a struct of type deck containing a shuffled order
 */
struct deck *shuffle (struct deck *deck)
{
	int i = 0, j = 0, select = 0;
	for (i = 52, j = 0; i >= 1, j <= 51; i--, j++) {
		select = rand() % i;
		if (!deck.cards[select].taken) {
			shuffle.cards[j].num = deck.cards[select].num;
			shuffle.cards[j].suit = deck.cards[select].suit;
			dec.cards[select].taken = true;
		} else {
			j--;
			i++;
		}
	}
	return shuffle;
}
