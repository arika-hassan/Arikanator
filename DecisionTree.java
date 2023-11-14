public class DecisionTree {

    // Constructor
    public DecisionTree() {

    }

    // Eliminate sitcoms that don't match the user's answer
    public ST<Integer, String> eliminate(String answer, ST<Integer, String>
            sitcoms, ST<Integer, String> answers) {
        // Create new symbol table to hold the non-eliminated sitcom
        ST<Integer, String> updatedSitcoms = new ST<Integer, String>();

        // Check through all sitcoms in the symbol table
        for (Integer key : sitcoms.keys())
            // If the sitcom answer to given question matches user answer
            // insert that sitcom (and key) into updated sitcom array
            if (answers.get(key).equals(answer)) {
                updatedSitcoms.put(key, sitcoms.get(key));
            }
        return updatedSitcoms; // return symbol table of non-eliminated sitcoms
    }

    public static void main(String[] args) {
        DecisionTree tree = new DecisionTree();

        // Symbol table to hold list of sitcoms (integer as key)
        ST<Integer, String> sitcoms = new ST<Integer, String>();

        // Calling in sitcom and answer data from text file "data"
        In dataSet = new In("data.txt");

        int n = dataSet.readInt(); // number of shows

        // Symbol table to hold list of answers for question 1 (integer as key)
        ST<Integer, String> a1 = new ST<Integer, String>();
        // Symbol table to hold list of answers for question 2 (integer as key)
        ST<Integer, String> a2 = new ST<Integer, String>();
        // Symbol table to hold list of answers for question 3 (integer as key)

        for (int i = 0; i < n; i++) {
            sitcoms.put(i, dataSet.readString()); // read in sitcoms
            a1.put(i, dataSet.readString()); // read in answers to q1
            a2.put(i, dataSet.readString()); // read in answers to q2
        }

        // Ask questions and eliminate shows until it's narrowed down to 1 show
        while (sitcoms.size() != 1) {
            StdOut.println("Was the show set in NYC?"); // print question 1
            // calls eliminate()
            sitcoms = tree.eliminate(StdIn.readString(), sitcoms, a1);

            StdOut.println("Did show premier before 2000?"); // print question 2
            // calls eliminate()
            sitcoms = tree.eliminate(StdIn.readString(), sitcoms, a2);
        }

        // Print the show that has not been eliminated
        for (Integer keys : sitcoms.keys()) {
            StdOut.println(sitcoms.get(keys));
        }
    }
}
