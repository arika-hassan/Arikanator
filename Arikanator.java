public class Arikanator {

    public static void draw(String sitcom) {
        StdDraw.setXscale(-2.5, 2.5);
        StdDraw.setYscale(-50, 50);
        StdDraw.show();
        StdDraw.picture(0, 0, sitcom + ".jpg", 2.75, 80);
    }

    public static void main(String[] args) {

        // Symbol table to hold list of sitcoms (integer as key)
        ST<Integer, String> sitcoms = new ST<Integer, String>();

        // Symbol table to hold list of answers for question 1 (integer as key)
        ST<Integer, String> a1 = new ST<Integer, String>();
        // Symbol table to hold list of answers for question 2 (integer as key)
        ST<Integer, String> a2 = new ST<Integer, String>();
        // Symbol table to hold list of answers for question 3 (integer as key)
        ST<Integer, String> a3 = new ST<Integer, String>();
        // Symbol table to hold list of answers for question 4 (integer as key)
        ST<Integer, String> a4 = new ST<Integer, String>();
        // Symbol table to hold list of answers for question 5 (integer as key)
        ST<Integer, String> a5 = new ST<Integer, String>();
        // Symbol table to hold list of answers for question 6 (integer as key)
        ST<Integer, String> a6 = new ST<Integer, String>();
        // Symbol table to hold list of answers for question 7 (integer as key)
        ST<Integer, String> a7 = new ST<Integer, String>();
        // Symbol table to hold list of answers for question 8 (integer as key)
        ST<Integer, String> a8 = new ST<Integer, String>();
        // Symbol table to hold list of answers for question 9 (integer as key)
        ST<Integer, String> a9 = new ST<Integer, String>();
        // Symbol table to hold list of answers for question 10 (integer as key)
        ST<Integer, String> a10 = new ST<Integer, String>();

        // Decision Tree object called tree
        DecisionTree tree = new DecisionTree();

        // Calling in sitcom and answer data from text file "Arikanator"
        In dataSet = new In("Arikanator.txt");
        // Calling in questions data from text file "questions"
        In questions = new In("questions.txt");

        int n = dataSet.readInt(); // number of shows

        // Reading in data from text files
        for (int i = 0; i < n; i++) {
            sitcoms.put(i, dataSet.readString()); // read in sitcoms
            a1.put(i, dataSet.readString()); // read in answers to q1
            a2.put(i, dataSet.readString()); // read in answers to q2
            a3.put(i, dataSet.readString()); // read in answers to q3
            a4.put(i, dataSet.readString()); // read in answers to q4
            a5.put(i, dataSet.readString()); // read in answers to q5
            a6.put(i, dataSet.readString()); // read in answers to q6
            a7.put(i, dataSet.readString()); // read in answers to q7
            a8.put(i, dataSet.readString()); // read in answers to q8
            a9.put(i, dataSet.readString()); // read in answers to q9
            a10.put(i, dataSet.readString()); // read in answers to q10
        }

        // Ask questions and eliminate shows until it's narrowed down to 1 show
        while (sitcoms.size() != 1) {
            StdOut.println(questions.readString()); // print question 1
            String answer = StdIn.readString(); // read in answer from terminal
            // calls eliminate(), makes sitcoms symbol table equal to the
            // updated symbol table
            sitcoms = tree.eliminate(answer, sitcoms, a1);

            // if 1 show left, stop asking questions (restart while loop)
            if (sitcoms.size() == 1) continue;
            StdOut.println(questions.readString()); // print question 2
            answer = StdIn.readString(); // read in answer from terminal
            // calls eliminate(), makes sitcoms symbol table equal to the
            // updated symbol table
            sitcoms = tree.eliminate(answer, sitcoms, a2);

            // if 1 show left, stop asking questions (restart while loop)
            if (sitcoms.size() == 1) continue;
            StdOut.println(questions.readString()); // print question 3
            answer = StdIn.readString(); // read in answer from terminal
            // calls eliminate(), makes sitcoms symbol table equal to the
            // updated symbol table
            sitcoms = tree.eliminate(answer, sitcoms, a3);

            // if 1 show left, stop asking questions (restart while loop)
            if (sitcoms.size() == 1) continue;
            StdOut.println(questions.readString()); // print question 4
            answer = StdIn.readString(); // read in answer from terminal
            // calls eliminate(), makes sitcoms symbol table equal to the
            // updated symbol table
            sitcoms = tree.eliminate(answer, sitcoms, a4);

            // if 1 show left, stop asking questions (restart while loop)
            if (sitcoms.size() == 1) continue;
            StdOut.println(questions.readString()); // print question 5
            answer = StdIn.readString(); // read in answer from terminal
            // calls eliminate(), makes sitcoms symbol table equal to the
            // updated symbol table
            sitcoms = tree.eliminate(answer, sitcoms, a5);

            // if 1 show left, stop asking questions (restart while loop)
            if (sitcoms.size() == 1) continue;
            StdOut.println(questions.readString()); // print question 6
            answer = StdIn.readString(); // read in answer from terminal
            // calls eliminate(), makes sitcoms symbol table equal to the
            // updated symbol table
            sitcoms = tree.eliminate(answer, sitcoms, a6);

            // if 1 show left, stop asking questions (restart while loop)
            if (sitcoms.size() == 1) continue;
            StdOut.println(questions.readString()); // print question 7
            answer = StdIn.readString(); // read in answer from terminal
            // calls eliminate(), makes sitcoms symbol table equal to the
            // updated symbol table
            sitcoms = tree.eliminate(answer, sitcoms, a7);

            // if 1 show left, stop asking questions (restart while loop)
            if (sitcoms.size() == 1) continue;
            StdOut.println(questions.readString()); // print question 8
            answer = StdIn.readString(); // read in answer from terminal
            // calls eliminate(), makes sitcoms symbol table equal to the
            // updated symbol table
            sitcoms = tree.eliminate(answer, sitcoms, a8);

            // if 1 show left, stop asking questions (restart while loop)
            if (sitcoms.size() == 1) continue;
            StdOut.println(questions.readString()); // print question 9
            answer = StdIn.readString(); // read in answer from terminal
            // calls eliminate(), makes sitcoms symbol table equal to the
            // updated symbol table
            sitcoms = tree.eliminate(answer, sitcoms, a9);

            // if 1 show left, stop asking questions (restart while loop)
            if (sitcoms.size() == 1) continue;
            StdOut.println(questions.readString()); // print question 10
            answer = StdIn.readString(); // read in answer from terminal
            // calls eliminate(), makes sitcoms symbol table equal to the
            // updated symbol table
            sitcoms = tree.eliminate(answer, sitcoms, a10);
        }

        // Print the show that has not been eliminated
        for (Integer keys : sitcoms.keys()) {
            StdOut.println(sitcoms.get(keys));
            draw(sitcoms.get(keys));
        }

    }
}
