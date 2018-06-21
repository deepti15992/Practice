/**
Transpose a directed graph


 C-->A<-->B
 ^   | \  ^
 |   |  | |
 |  /    \|
 D <------E
*/
struct Graph {
	struct node nodes[];
};

struct node {
	char *name;
	bool visited;
	struct node* children;
};
/*
while (node_iter.visited = false)
	for each node in node_iter.children
		node.children.add(node_iter)
		node_iter.children.remove(node)
	node_iter.visited = true
	node_iter = graph.nodes.next
*/

int main()
{
	struct Graph a;
	reverse(a.nodes, countnodes(a));
	return 0;
}

void reverse(struct node *root, len)
{
	int i = 0;
	struct node* tmp = NULL;
	while (i < len) {
		if (!root)
			return;
		if (root[i].visited == false) {
			child = root[i].children;
			while (child != NULL)
				tmp = child->children->next;
				
				
			
			
}
