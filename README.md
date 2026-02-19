# Recursive Arithmetic Expression Tree

**Language:** Java | **Concepts:** Recursion, Binary Trees, Stacks, Parsing

### Project Overview
An algorithmic parser that evaluates complex mathematical expressions. It converts **Postfix Notation** strings into a **Binary Expression Tree**, allowing for efficient traversal and calculation of values.

### Key Features
* **Recursive Traversal:** Uses pure recursion to traverse the tree for calculation and printing (Prefix/Infix notation).
* **Stack-Based Parsing:** Implements a variation of the Shunting-yard algorithm using `java.util.Stack` to construct the tree from raw strings.
* **Polymorphic Nodes:** `BinTreeNode` handles both Operator (internal nodes) and Operand (leaf nodes) logic.

### Technical Structure
* `ExpressionTree.java`: Manages the recursive calls for `getPrefixNotation` and `getValue`.
* `BinTreeNode.java`: The recursive data structure holding `left` and `right` child pointers.
* `Tester.java`: Includes robust error handling for malformed math strings.

### Example
**Input (Postfix):** `5 3 + 2 *`  
**Output (Infix):** `((5 + 3) * 2)`  
**Result:** `16`
