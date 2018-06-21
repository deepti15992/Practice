/**
 * Given two singly linked lists, determine if they intersect. Return the intersecting node.
 * a -> b -> c -> d
 * 		    \
 *     f -> g -> i -> e -> k -> l.
 */

struct node {
	int val;
	struct node *next;
};

int listlen(struct node *head)
{
	int len = 1;
	if (!head)
		return 0;

	while (head->next != NULL) {
		head = head->next;
		len++;
	}
	return len;
}

struct node *IntersectionNode(struct node *head1, struct node *head2)
{
	struct node *tmp = head1;
	uint64_t *table = NULL;
	int i = 0;
	if (!head1 || !head2)
		return NULL;

	table =	malloc(sizeof(uint64_t) * listlen(head1));
	while (tmp->next != NULL) {
		table[i] = tmp;
		tmp = tmp->next;
		i++;
	}

	tmp = head2;
	while (tmp->next != NULL) {
		if (contains (table, tmp))
			return tmp;
		tmp = tmp->next;
	}
	return NULL;
}
