/*
 * isUnique: Figures out if an input string consists of all unique characters
 *
 * Limitations: Only handles lowercase ASCII a-z
 * Future development:
 * a] Handle upper case
 * b] Expand to alphanumeric
 * c] Handle unicode
 */
char hashtable[26];

int insert(char ch) {

	int index = ch - 'a';

	if (index >= sizeof(hashtable))
		exit(1);

	if (hashtable[index] != '\0')
		return -EFAULT;

	hashtable[index] = ch;
	return 0;
}

bool isUnique(char *string) {

	int i;

	for (i = 0; i <= strlen(string); i++) {
		if (insert(string[i] == -EFAULT))
			return false;
	}
	return true;
}
