#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void urlify(char* string, int len)
{
	int i, space = 0, empty_spots;
	char *a = NULL;

	for (i = 0; i < len; i++) {
		if (string[i] == ' ')
			space++;
	}
	empty_spots = space * 2;

	a = malloc(len + empty_spots + 1);
	memcpy(a, string, len);
	a[len+empty_spots] = '\0';

	for (i = len - 1; i != 0; i--) {
		if (string[i] != ' ') {
			a[i + empty_spots] = string[i];
		} else {
			a[i + empty_spots] = '0';
			empty_spots--;
			a[i + empty_spots] = '2';
			empty_spots--;
			a[i + empty_spots] = '%';
		}
	}
	printf("a = %s\n", a);
}

int main(int argc, char *argv[])
{
	urlify(argv[1], strlen(argv[1]));
	return 0;
}
