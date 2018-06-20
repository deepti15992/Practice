struct node_tree {
	int payload;
	struct node *left, *right;
};

struct node_list {
	int payload;
	struct node_list *next, *prev;
};

/*
 *	10					10		5
 *     /  \					/
 *    12  15					5
 *   /\   / 
 * 25 30 36
 *	 / \
 *	45 14
 * In-order traversal: left, node, right
 * 25-12-30-10-45-36-14-15			5-10		5
 */
/***********
struct node* convertBTreetoDLList (struct node* root)
{

	struct node *tmp = root, *leaf = NULL;
	static struct node *currentHEAD = NULL;

	if (root == NULL || (root->left == NULL && root->right == NULL))
		return root;

	leaf = convertBTreetoDLList(tmp->left);
	leaf->left = currentHEAD;
	leaf->right = tmp;
	currentHEAD = tmp;
	leaf = convertBTreetoDLList(tmp->right);
	leaf->left = currentHEAD;
	
}

	10					  10
	/					 /  \
       5				       12    15
					       / \   /
	leaf = 5			      25 30 36 
	5->left = NULL			25-12-30-10-36-15
	5->right = 10			10 ! NULL, 10->children ! NULL
	currentHEAD = 5				12
	NULL-5-10-NULL				12 ! NULL, 12->children ! NULL
							25
							25 ! NULL, 25->children = NULL
							return
							30
							30 ! NULL, 30->children = NULL;
							return
						current = 12->left = 25
						12->left = 25
						25->right = 12
						current = 12->right = 30
						12->right = 30
						30->left = 12
						15
						15 ! NULL, 15->children ! NULL
							36
							36 ! NULL, 36->children = NULL
							return
							No right kids
						current = 15->left = 36
						15->left = 36
						36->right = 15
						current = NULL
						15->right = NULL
					current = 10->left = 12
					current = 30
					10->left = 30
					30->right = 10
					current = 10->right = 15
					current = 36
					10->right = 36
					36->left = 10
						


In-order traverse: left, node, right
InOrderTraverse(left)
visit(node)
InOrderTraverse(right)
****/
void convertBTreetoDLList (struct node* root)
{
	if (root == NULL || (root->left == NULL && root->right == NULL))
		return;
	
	convertBTreetoDLList(root->left);
	convertBTreetoDLList(root->right);
	current = root->left;
	while (current && current->right != NULL)
		current = current->right;
	root->left = current;
	current->right = root;
	current = root->right;
	while (current && current->left != NULL)
		current = current->left;
	root->right = current;
	current->left = root;
}
