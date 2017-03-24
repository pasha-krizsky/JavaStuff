package task1;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * Entry point
 */
public class Solver {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out   = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(in.readLine());
        HashTable<Integer> hashTable = new HashTable<>(n, n);

        while (true) {
            int x;
            try {
                x = Integer.parseInt(stringTokenizer.nextToken());
            } catch (NoSuchElementException e) {
                break;
            }
            hashTable.insert(x);
        }

        for (int i = 0; i <= hashTable.getMaxIndex(); ++i) {
            List l = (List) hashTable.get(i);
            System.out.print(i + ": ");
            if (l != null) {
                l.printList();
            }
            System.out.println();
        }

        out.println();
        out.flush();
    }
}
